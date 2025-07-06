package com.example.petshop.controller;

import com.example.petshop.model.Employee;
import com.example.petshop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public String viewEmployees(Model model) {
        List<Employee> employees = service.all();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @PostMapping("/add")
    public String add(Employee employee) {
        service.save(employee);
        return "redirect:/employees";
    }

    @PostMapping("/rename")
    public String rename(@RequestParam String code,
                         @RequestParam String newName) {
        service.rename(code, newName);
        return "redirect:/employees";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String code) {
        service.delete(code);
        return "redirect:/employees";
    }
}

