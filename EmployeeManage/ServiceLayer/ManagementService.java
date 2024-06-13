package com.EmployeeManage.ServiceLayer;

import com.EmployeeManage.DAOLayer.EmployeeDAO;
import com.EmployeeManage.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagementService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public ManagementService(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @Transactional
    public void save(Employee employee){
        employeeDAO.save(employee);
    }
    @Transactional
    public void update(Employee employee){
        employeeDAO.save(employee);
    }

    @Transactional
    public Employee getDetails(int id){
        Optional<Employee> result=employeeDAO.findById(id);
        return result.orElse(null);
    }
    @Transactional
    public Employee deleteEmployee(int id) {
        Optional<Employee> employee = employeeDAO.findById(id);
        if (employee.isPresent()) {
            Employee deletedEmployee = employee.get();
            employeeDAO.deleteById(id);
            return deletedEmployee;
        }
        return null;
    }



}
