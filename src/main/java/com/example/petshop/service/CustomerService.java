package com.example.petshop.service;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.example.petshop.model.Customer;
import com.example.petshop.repository.CustomerRepository;
import com.example.petshop.exception.*;

@Service @RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repo;

    public List<Customer> all() { return repo.findAll(); }

    /** THÊM mới – kiểm tra trùng email */
    public Customer add(@Valid Customer c) {
        if (repo.existsByEmail(c.getEmail()))
            throw new DuplicateCustomerException("Email đã tồn tại!");
        return repo.save(c);
    }

    /** SỬA – tìm theo code rồi cập nhật */
    public Customer update(String code, @Valid Customer in) {
        Customer c = repo.findByCode(code);
        if (c == null) throw new CustomerNotFoundException("Không tìm thấy KH: " + code);
        c.setFullName(in.getFullName());
        c.setPhone(in.getPhone());
        c.setAddress(in.getAddress());
        return repo.save(c);
    }

    public void delete(String code) {
        if (repo.findByCode(code) == null)
            throw new CustomerNotFoundException("Không tìm thấy KH để xoá!");
        repo.deleteByCode(code);
    }
}

