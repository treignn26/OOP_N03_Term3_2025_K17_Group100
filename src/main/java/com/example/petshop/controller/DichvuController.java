package com.example.petshop.controller;

import com.example.petshop.model.Service;
import com.example.petshop.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService service;

    @GetMapping
    public String view(Model model) {
        List<Service> list = service.all();
        model.addAttribute("services", list);
        model.addAttribute("total", list.stream().mapToDouble(Service::getPrice).sum());
        return "services"; // sẽ tạo file `services.html`
    }

    @PostMapping("/add")
    public String add(Service s) {
        service.save(s);
        return "redirect:/services";
    }

    @PostMapping("/rename")
    public String rename(@RequestParam String code, @RequestParam String newName) {
        service.rename(code, newName);
        return "redirect:/services";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String code) {
        service.delete(code);
        return "redirect:/services";
    }
}
