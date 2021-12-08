package net.devnguyen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class NhatKy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenNhatKy;

    private String congViecId;
}
