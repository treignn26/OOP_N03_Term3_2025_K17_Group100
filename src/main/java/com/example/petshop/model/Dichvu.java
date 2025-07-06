package com.example.petshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;     // Mã dịch vụ

    private String name;     // Tên dịch vụ
    private String type;     // Loại dịch vụ (chăm sóc, tiêm phòng,...)
    private Double price;    // Giá dịch vụ
}
