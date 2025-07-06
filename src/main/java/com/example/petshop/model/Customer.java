package com.example.petshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table( name = "customers",
        uniqueConstraints = @UniqueConstraint(name="uk_customer_email", columnNames = "email") )
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 30)
    @NotBlank(message = "Mã KH không được để trống")
    private String code;          // Mã khách hàng

    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    /** Số ĐT 10‑11 số, chỉ 0‑9 */
    @Pattern(regexp = "^[0-9]{10,11}$",
             message = "SĐT phải 10‑11 ký tự số")
    private String phone;

    private String address;
}
