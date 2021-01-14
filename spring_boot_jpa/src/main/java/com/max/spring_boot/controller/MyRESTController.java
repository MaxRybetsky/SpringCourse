package com.max.spring_boot.controller;

import com.max.spring_boot.entity.Employee;
import com.max.spring_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        service.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return service.getAllByName(name);
    }
}
