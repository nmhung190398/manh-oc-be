package net.devnguyen.repository;

import net.devnguyen.entity.NhanVien;
import net.devnguyen.entity.NhatKy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NhatKyRepository extends JpaRepository<NhatKy,Long> {

}
