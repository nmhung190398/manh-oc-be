package net.devnguyen.repository;

import net.devnguyen.entity.NhanVien;
import net.devnguyen.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SanPhamRepository extends JpaRepository<SanPham,Long> {

}
