package com.example.petshop.repository;

import com.example.petshop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByCode(String code);
    void deleteByCode(String code);
}

