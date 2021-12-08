package net.devnguyen.controller;

import net.devnguyen.entity.ChucVu;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping
    public Page<ChucVu> search(Pageable pageable){
        return chucVuRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChucVu> findById(@PathVariable Long id){
        return ResponseEntity.of(chucVuRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ChucVu> update(@PathVariable Long id,@RequestBody ChucVu chucVu){
        chucVuRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        chucVu.setId(id);
        return ResponseEntity.ok(chucVuRepository.save(chucVu));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        chucVuRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<ChucVu> create(@RequestBody ChucVu chucVu){
        chucVu.setId(null);
        return ResponseEntity.ok(chucVuRepository.save(chucVu));
    }
}
