package com.max.springmvc;

import com.max.springmvc.model.Employee;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInitializer {
    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        // Employee #1
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Axel");
        e1.setJoiningDate(new LocalDate());
        e1.setSalary(new BigDecimal(10000));
        e1.setSsn("XXX111");
        // Employee #2
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Jeremy");
        e2.setJoiningDate(new LocalDate());
        e2.setSalary(new BigDecimal(20000));
        e2.setSsn("XXX222");
        // Add employees to list
        employees.add(e1);
        employees.add(e2);
        return employees;
    }
}
