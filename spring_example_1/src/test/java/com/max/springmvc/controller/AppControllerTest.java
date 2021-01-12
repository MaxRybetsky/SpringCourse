package com.max.springmvc.controller;

import com.max.springmvc.EmployeeInitializer;
import com.max.springmvc.model.Employee;
import com.max.springmvc.service.EmployeeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AppControllerTest {
    @Mock
    EmployeeService service;

    @Mock
    MessageSource messageSource;

    @InjectMocks
    AppController appController;

    @Spy
    List<Employee> employees = new ArrayList<>();

    @Spy
    ModelMap model;

    @Mock
    BindingResult bindingResult;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employees = EmployeeInitializer.getEmployeeList();
    }

    @Test
    public void listEmployees() {
        when(service.findAllEmployees()).thenReturn(employees);
        Assert.assertEquals(appController.listEmployees(model), "allemployees");
        Assert.assertEquals(model.get("employees"), employees);
        verify(service, atLeastOnce()).findAllEmployees();
    }

    @Test
    public void newEmployee() {
        Assert.assertEquals(appController.newEmployee(model), "registration");
        Assert.assertNotNull(model.get("employee"));
        Assert.assertFalse((Boolean) model.get("edit"));
        Assert.assertEquals(((Employee) model.get("employee")).getId(), 0);
    }

    @Test
    public void saveEmployeeWithValidationError() {
        when(bindingResult.hasErrors()).thenReturn(true);
        doNothing().when(service).saveEmployee(any(Employee.class));
        Assert.assertEquals(appController.saveEmployee(employees.get(0), bindingResult, model),
                "registration");
    }

    @Test
    public void aveEmployeeWithValidationErrorNonUniqueSSN() {
        when(bindingResult.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.saveEmployee(employees.get(0), bindingResult, model),
                "registration");
    }

    @Test
    public void saveEmployeeWithSuccess() {
        when(bindingResult.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).saveEmployee(any(Employee.class));
        Assert.assertEquals(appController.saveEmployee(employees.get(0), bindingResult, model),
                "success");
        Assert.assertEquals(model.get("success"),
                "Employee Axel registered successfully");
    }

    @Test
    public void editEmployee() {
        Employee employee = employees.get(0);
        when(service.findEmployeeBySsn(anyString())).thenReturn(employee);
        Assert.assertEquals(appController.editEmployee(anyString(), model), "registration");
        Assert.assertNotNull(model.get("employee"));
        Assert.assertTrue((Boolean) model.get("edit"));
        Assert.assertEquals(((Employee) model.get("employee")).getId(), 1);
    }

    @Test
    public void updateEmployeeWithValidationError() {
        when(bindingResult.hasErrors()).thenReturn(true);
        doNothing().when(service).updateEmployee(any(Employee.class));
        Assert.assertEquals(appController.updateEmployee(employees.get(0), bindingResult, model, ""),
                "registration");
    }

    @Test
    public void updateEmployeeWithValidationErrorNonUniqueSSN() {
        when(bindingResult.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.updateEmployee(employees.get(0), bindingResult, model, ""),
                "registration");
    }

    @Test
    public void updateEmployeeWithSuccess() {
        when(bindingResult.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).updateEmployee(any(Employee.class));
        Assert.assertEquals(appController.updateEmployee(employees.get(0), bindingResult, model, ""),
                "success");
        Assert.assertEquals(model.get("success"),
                "Employee Axel updated successfully");
    }

    @Test
    public void deleteEmployee() {
        doNothing().when(service).deleteEmployeeBySsn(anyString());
        Assert.assertEquals(appController.deleteEmployee("123"), "redirect:/list");
    }
}