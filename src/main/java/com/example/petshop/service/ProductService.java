package com.example.petshop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.petshop.model.Product;
import com.example.petshop.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public List<Product> all() {
        return repo.findAll();
    }

    public Product save(Product p) {
        return repo.save(p);
    }

    public void delete(String code) {
        repo.deleteByCode(code);
    }

    public Product update(String code, Product updated) {
        Product product = repo.findByCode(code);
        if (product == null) throw new RuntimeException("Sản phẩm không tồn tại");
        product.setName(updated.getName());
        product.setPrice(updated.getPrice());
        product.setDescription(updated.getDescription());
        product.setQuantity(updated.getQuantity());
        return repo.save(product);
    }
}
