package com.EmployeeManage.DAOLayer;

import com.EmployeeManage.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
