package net.devnguyen.repository;

import lombok.Data;
import net.devnguyen.entity.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;


public interface PhongBanRepository extends JpaRepository<PhongBan,Long> {

}
