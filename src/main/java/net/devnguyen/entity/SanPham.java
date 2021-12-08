package net.devnguyen.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenSanPham;

    private int soDangKy;

    private LocalDate hanSuDung;

    private String quyCach;

    private LocalDate ngayDangKy;

    private int loId;

    private int congViecId;

}
