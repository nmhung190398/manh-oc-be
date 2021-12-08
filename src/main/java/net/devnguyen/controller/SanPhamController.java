package net.devnguyen.controller;

import net.devnguyen.entity.SanPham;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping
    public Page<SanPham> search(Pageable pageable){
        return sanPhamRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SanPham> findById(@PathVariable Long id){
        return ResponseEntity.of(sanPhamRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SanPham> update(@PathVariable Long id,@RequestBody SanPham sanPham){
        sanPhamRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        sanPham.setId(id);
        return ResponseEntity.ok(sanPhamRepository.save(sanPham));
    }

    @PostMapping("")
    public ResponseEntity<SanPham> create(@RequestBody SanPham sanPham){
        sanPham.setId(null);
        return ResponseEntity.ok(sanPhamRepository.save(sanPham));
    }
}
