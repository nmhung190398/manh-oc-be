package net.devnguyen.repository;

import net.devnguyen.entity.ChucVu;
import net.devnguyen.entity.CongViec;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CongViecRepository extends JpaRepository<CongViec,Long> {

}
