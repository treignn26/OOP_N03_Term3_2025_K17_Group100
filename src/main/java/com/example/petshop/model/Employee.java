package com.example.petshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;        // Mã nhân viên

    private String name;        // Tên nhân viên
    private String phone;       // Số điện thoại
    private String email;       // Email
    private String role;        // Vai trò (ví dụ: bán hàng, quản lý...)
}
