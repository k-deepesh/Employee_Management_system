package com.EmployeeManage.ControllerLayer;

import com.EmployeeManage.Entity.Employee;
import com.EmployeeManage.ServiceLayer.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagementController {

    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }


    @PostMapping("/addemployee")
    public String addEmployee(@RequestBody Employee employee) {
        managementService.save(employee);
        return "Employee added with ID " + employee.getEmployee_id() + " successfully";
    }

    @PutMapping("/updateemployee")
    public String updateEmployee(@RequestBody Employee employee) {
        managementService.update(employee);
        return "Employee updated with ID " + employee.getEmployee_id() + " successfully";
    }

    @GetMapping("/getemployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = managementService.getDetails(id);
        if (employee == null) {
            return null;
        }
        return managementService.getDetails(id);
    }

    @DeleteMapping("/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee deletedEmployee = managementService.deleteEmployee(id);
        if (deletedEmployee != null) {
            managementService.deleteEmployee(id);
        }
        return "not found";
    }

}
