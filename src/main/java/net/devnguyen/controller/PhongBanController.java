package net.devnguyen.controller;

import net.devnguyen.entity.PhongBan;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phong-ban")
public class PhongBanController {
    @Autowired
    private PhongBanRepository phongBanRepository;

    @GetMapping
    public Page<PhongBan> search(Pageable pageable){
        return phongBanRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhongBan> findById(@PathVariable Long id){
        return ResponseEntity.of(phongBanRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PhongBan> update(@PathVariable Long id,@RequestBody PhongBan phongBan){
        phongBanRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        phongBan.setId(id);
        return ResponseEntity.ok(phongBanRepository.save(phongBan));
    }

    @PostMapping("")
    public ResponseEntity<PhongBan> create(@RequestBody PhongBan phongBan){
        phongBan.setId(null);
        return ResponseEntity.ok(phongBanRepository.save(phongBan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        phongBanRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
