package com.example.petshop.repository;

import com.example.petshop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByCode(String code);
    void deleteByCode(String code);
}
