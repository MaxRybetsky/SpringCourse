package com.max.spring_boot.service;

import com.max.spring_boot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> getAllByName(String name);
}
