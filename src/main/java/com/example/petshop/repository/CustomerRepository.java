package com.example.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    Customer findByCode(String code);
    void deleteByCode(String code);
}
