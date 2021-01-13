package com.max.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String getAllEmployees() {
        return "view_for_all_employees";
    }

    @GetMapping("/hr_info")
    public String getSalaries() {
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String getPerformance() {
        return "view_for_managers";
    }
}
