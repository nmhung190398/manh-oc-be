package net.devnguyen.controller;

import net.devnguyen.entity.Lo;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.LoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lo")
public class LoController {
    @Autowired
    private LoRepository loRepository;

    @GetMapping
    public Page<Lo> search(Pageable pageable){
        return loRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lo> findById(@PathVariable Long id){
        return ResponseEntity.of(loRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Lo> update(@PathVariable Long id,@RequestBody Lo lo){
        loRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        lo.setId(id);
        return ResponseEntity.ok(loRepository.save(lo));
    }

    @PostMapping("")
    public ResponseEntity<Lo> create(@RequestBody Lo lo){
        lo.setId(null);
        return ResponseEntity.ok(loRepository.save(lo));
    }
}
