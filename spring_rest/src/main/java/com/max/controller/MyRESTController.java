package com.max.controller;

import com.max.entity.Employee;
import com.max.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        return employees;
    }
}
