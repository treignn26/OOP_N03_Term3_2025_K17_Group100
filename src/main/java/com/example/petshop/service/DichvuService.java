package com.example.petshop.service;

import com.example.petshop.model.Service;
import com.example.petshop.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository repo;

    public List<Service> all() { return repo.findAll(); }
    public Service save(Service s) { return repo.save(s); }
    public void delete(String code) { repo.deleteByCode(code); }

    public Service rename(String code, String newName) {
        Service s = repo.findByCode(code);
        if (s == null) return null;
        s.setName(newName);
        return repo.save(s);
    }
}
