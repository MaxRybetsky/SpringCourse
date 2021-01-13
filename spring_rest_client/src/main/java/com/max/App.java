package com.max;

import com.max.configuration.MyConfig;
import com.max.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication",
                Communication.class);
        for (Employee emp : communication.getAllEmployees()) {
            System.out.println(emp);
        }
        System.out.println();
        System.out.println(communication.getEmployee(2));
//        Employee employee = new Employee("John", "Jobs", "IT", 1000);
//        communication.saveEmployee(employee);
//        employee = communication.getEmployee(6);
//        employee.setName("Salat");
//        employee.setSurname("Salatov");
//        employee.setDepartment("HR");
//        employee.setSalary(2000);
//        communication.saveEmployee(employee);
        communication.deleteEmployee(7);
        context.close();
    }
}
