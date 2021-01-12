package com.max.springmvc.service;

import com.max.springmvc.EmployeeInitializer;
import com.max.springmvc.dao.EmployeeDao;
import com.max.springmvc.model.Employee;
import org.mockito.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTest {
    @Mock
    EmployeeDao dao;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Spy
    List<Employee> employees = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employees = EmployeeInitializer.getEmployeeList();
    }

    @Test
    public void findById() {
        Employee emp = employees.get(0);
        when(dao.findById(anyInt())).thenReturn(emp);
        Assert.assertEquals(employeeService.findById(emp.getId()), emp);
    }

    @Test
    public void saveEmployee() {
        doNothing().when(dao).saveEmployee(any(Employee.class));
        employeeService.saveEmployee(any(Employee.class));
        verify(dao, atLeastOnce()).saveEmployee(any(Employee.class));
    }

    @Test
    public void updateEmployee() {
        Employee emp = employees.get(0);
        when(dao.findById(anyInt())).thenReturn(emp);
        employeeService.updateEmployee(emp);
        verify(dao, atLeastOnce()).findById(anyInt());
    }

    @Test
    public void deleteEmployee() {
        doNothing().when(dao).deleteEmployeeBySsn(anyString());
        employeeService.deleteEmployeeBySsn(anyString());
        verify(dao, atLeastOnce()).deleteEmployeeBySsn(anyString());
    }

    @Test
    public void findAllEmployees() {
        when(dao.findAllEmployees()).thenReturn(employees);
        Assert.assertEquals(employeeService.findAllEmployees(), employees);
    }

    @Test
    public void deleteEmployeeBySsn() {
        Employee emp = employees.get(0);
        when(dao.findEmployeeBySsn(anyString())).thenReturn(emp);
        Assert.assertEquals(employeeService.findEmployeeBySsn(anyString()), emp);
    }

    @Test
    public void isEmployeeSsnUnique() {
        Employee emp = employees.get(0);
        when(dao.findEmployeeBySsn(anyString())).thenReturn(emp);
        Assert.assertEquals(employeeService.isEmployeeSsnUnique(emp.getId(), emp.getSsn()),
                true);
    }
}