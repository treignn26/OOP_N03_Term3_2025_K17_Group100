package com.example.petshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.example.petshop.model.Customer;
import com.example.petshop.service.CustomerService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    /** Danh sách */
    @GetMapping
    public String list(Model model) {
        List<Customer> customers = service.all();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());   // để bind form thêm
        return "customer";                // customer.html
    }

    /** Thêm */
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("customer") Customer c,
                      BindingResult br, Model m) {
        if (br.hasErrors()) {             // lỗi validate -> quay lại trang
            m.addAttribute("customers", service.all());
            return "customer";
        }
        service.add(c);
        return "redirect:/customers";
    }

    /** Sửa */
    @PostMapping("/edit")
    public String edit(@RequestParam String code,
                       @Valid Customer in,
                       BindingResult br,
                       Model m) {
        if (br.hasErrors()) {
            m.addAttribute("customers", service.all());
            return "customer";
        }
        service.update(code, in);
        return "redirect:/customers";
    }

    /** Xoá */
    @PostMapping("/delete")
    public String delete(@RequestParam String code) {
        service.delete(code);
        return "redirect:/customers";
    }
}
