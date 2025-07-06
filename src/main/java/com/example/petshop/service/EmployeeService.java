package com.example.petshop.service;

import com.example.petshop.model.Employee;
import com.example.petshop.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repo;

    public List<Employee> all() { return repo.findAll(); }

    public Employee save(Employee e) { return repo.save(e); }

    public void delete(String code) { repo.deleteByCode(code); }

    public Employee rename(String code, String newName) {
        Employee e = repo.findByCode(code);
        if (e == null) return null;
        e.setName(newName);
        return repo.save(e);
    }
}
