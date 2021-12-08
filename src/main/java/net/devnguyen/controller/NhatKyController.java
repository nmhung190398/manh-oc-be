package net.devnguyen.controller;

import net.devnguyen.entity.NhatKy;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.NhatKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nhat-ky")
public class NhatKyController {
    @Autowired
    private NhatKyRepository nhatKyRepository;

    @GetMapping
    public Page<NhatKy> search(Pageable pageable){
        return nhatKyRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhatKy> findById(@PathVariable Long id){
        return ResponseEntity.of(nhatKyRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<NhatKy> update(@PathVariable Long id,@RequestBody NhatKy nhatKy){
        nhatKyRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        nhatKy.setId(id);
        return ResponseEntity.ok(nhatKyRepository.save(nhatKy));
    }

    @PostMapping("")
    public ResponseEntity<NhatKy> create(@RequestBody NhatKy nhatKy){
        nhatKy.setId(null);
        return ResponseEntity.ok(nhatKyRepository.save(nhatKy));
    }
}
