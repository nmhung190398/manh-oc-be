package net.devnguyen.repository;

import net.devnguyen.entity.ChucVu;
import net.devnguyen.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NhanVienRepository extends JpaRepository<NhanVien,Long> {

}
