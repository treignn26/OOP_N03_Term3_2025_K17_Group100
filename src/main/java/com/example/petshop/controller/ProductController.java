package com.example.petshop.controller;

import com.example.petshop.model.Product;
import com.example.petshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = service.all();
        model.addAttribute("products", products);
        return "products"; // Tên file HTML
    }

    @PostMapping("/add")
    public String add(Product product) {
        try {
            service.save(product);
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String update(@RequestParam String code, Product p) {
        try {
            service.update(code, p);
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String code) {
        try {
            service.delete(code);
        } catch (Exception e) {
            System.out.println("Lỗi khi xoá sản phẩm: " + e.getMessage());
        }
        return "redirect:/products";
    }
}
