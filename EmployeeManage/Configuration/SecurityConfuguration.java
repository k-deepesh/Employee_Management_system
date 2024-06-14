package com.EmployeeManage.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfuguration {


    @Bean
    public InMemoryUserDetailsManager SecurityConfuguration(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();


        UserDetails mary=User.builder()
                .username("mary")
                .password("{noop}1234")
                .roles("EMPLOYEE","MANANAGER")
                .build();

        UserDetails susan=User.builder()
                .username("susan")
                .password("{noop}1234")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->configurer
                .requestMatchers(HttpMethod.GET, "/getemployee/{id}").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/addemployee").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/updateemployee").hasAnyRole("MANAGER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/deleteemployee/{id}").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
}
