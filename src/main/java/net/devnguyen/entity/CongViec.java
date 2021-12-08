package net.devnguyen.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class CongViec {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenCongViec;

    private BigDecimal dinhMucKhoan;

    private String donVi;

    private BigDecimal heSoKhoan;

    private BigDecimal dinhMucLaoDong;
}
