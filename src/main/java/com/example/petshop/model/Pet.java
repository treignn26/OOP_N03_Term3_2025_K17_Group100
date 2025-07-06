package com.example.petshop.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;        // Mã SP (mã thú cưng)

    private String name;        // Tên thú cưng
    private String species;     // Loài
    private String gender;      // Giới tính
    private Integer age;        // Tuổi (tháng) – tuỳ ý
    private Double price;       // Giá bán
}
