package com.example.petshop.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.example.petshop.model.Pet;
import com.example.petshop.service.PetService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService service;

    /** Hiển thị trang */
    @GetMapping
    public String viewPets(Model model) {
        List<Pet> pets = service.all();
        model.addAttribute("pets", pets);
        model.addAttribute("totalMoney",
            pets.stream().mapToDouble(Pet::getPrice).sum());
        return "pets";
    }

    /** Thêm mới */
    @PostMapping("/add")
    public String add(Pet pet) {
        service.save(pet);
        return "redirect:/pets";
    }

    /** Đổi tên */
    @PostMapping("/rename")
    public String rename(@RequestParam String code,
                         @RequestParam String newName) {
        service.rename(code, newName);
        return "redirect:/pets";
    }

    /** Xoá theo mã */
    @PostMapping("/delete")
    public String delete(@RequestParam String code) {
        service.delete(code);
        return "redirect:/pets";
    }
} 
