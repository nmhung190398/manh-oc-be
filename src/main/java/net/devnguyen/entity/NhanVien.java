package net.devnguyen.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@Data
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate ngaySinh;

    private boolean gioiTinh;

    private String hoTen;

    private String diaChi;

    private BigDecimal heSoBaoHiem;

    private BigDecimal luongBaoHiem;

    private Long phongBanId;

    private Long chucVuId;

    @Transient
    private PhongBan phongBan;

    @Transient
    private ChucVu chucVu;
}
