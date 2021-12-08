package net.devnguyen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenChucVu;

    private String moTa;
}
