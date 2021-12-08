package net.devnguyen.controller;

import net.devnguyen.entity.NhanVien;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping
    public Page<NhanVien> search(Pageable pageable){
        return nhanVienRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> findById(@PathVariable Long id){
        return ResponseEntity.of(nhanVienRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> update(@PathVariable Long id,@RequestBody NhanVien nhanVien){
        nhanVienRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        nhanVien.setId(id);
        return ResponseEntity.ok(nhanVienRepository.save(nhanVien));
    }

    @PostMapping("")
    public ResponseEntity<NhanVien> create(@RequestBody NhanVien nhanVien){
        nhanVien.setId(null);
        return ResponseEntity.ok(nhanVienRepository.save(nhanVien));
    }
}
