package net.devnguyen.controller;

import net.devnguyen.entity.CongViec;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.CongViecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cong-viec")
public class CongViecController {
    @Autowired
    private CongViecRepository congViecRepository;

    @GetMapping
    public Page<CongViec> search(Pageable pageable){
        return congViecRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CongViec> findById(@PathVariable Long id){
        return ResponseEntity.of(congViecRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CongViec> update(@PathVariable Long id,@RequestBody CongViec congViec){
        congViecRepository.findById(id).orElseThrow(NotFoundException.DATA_NOT_FOUND::exception);

        congViec.setId(id);
        return ResponseEntity.ok(congViecRepository.save(congViec));
    }

    @PostMapping("")
    public ResponseEntity<CongViec> create(@RequestBody CongViec congViec){
        congViec.setId(null);
        return ResponseEntity.ok(congViecRepository.save(congViec));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        congViecRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
