package com.EmployeeManage.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Employee")
public class Employee {

    @Id
    @Column(name = "Employee_id")
    private int Employee_id;

    @Column(name = "Employee_name")
    private String Employee_name;
    @Column(name = "Employee_mail")
    private String Employee_mail;
    @Column(name = "Employee_domain")
    private String Employee_domain;

    public Employee() {
    }

    public Employee(int employee_id, String employee_name, String employee_mail, String employee_domain) {
        Employee_id = employee_id;
        Employee_name = employee_name;
        Employee_mail = employee_mail;
        Employee_domain = employee_domain;
    }

    public int getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(int employee_id) {
        Employee_id = employee_id;
    }

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }

    public String getEmployee_mail() {
        return Employee_mail;
    }

    public void setEmployee_mail(String employee_mail) {
        Employee_mail = employee_mail;
    }

    public String getEmployee_domain() {
        return Employee_domain;
    }

    public void setEmployee_domain(String employee_domain) {
        Employee_domain = employee_domain;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee_id=" + Employee_id +
                ", Employee_name='" + Employee_name + '\'' +
                ", Employee_mail='" + Employee_mail + '\'' +
                ", Employee_domain='" + Employee_domain + '\'' +
                '}';
    }
}
