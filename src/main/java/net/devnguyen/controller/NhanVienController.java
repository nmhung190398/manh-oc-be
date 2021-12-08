package net.devnguyen.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.devnguyen.entity.ChucVu;
import net.devnguyen.entity.NhanVien;
import net.devnguyen.entity.PhongBan;
import net.devnguyen.exception.errorcode.NotFoundException;
import net.devnguyen.repository.ChucVuRepository;
import net.devnguyen.repository.NhanVienRepository;
import net.devnguyen.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienRepository nhanVienRepository;
    private final ChucVuRepository chucVuRepository;
    private final PhongBanRepository phongBanRepository;

    @GetMapping
    public Page<NhanVien> search(Pageable pageable){
        var page = nhanVienRepository.findAll(pageable);
        map(page.toList());
        return page;
    }


    public List<NhanVien> map(List<NhanVien> nhanViens){
        if(CollectionUtils.isEmpty(nhanViens)){
            return List.of();
        }
        var chucVuIds = nhanViens.stream().map(NhanVien::getChucVuId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        var phongBanIds = nhanViens.stream().map(NhanVien::getPhongBanId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        var chucVus = chucVuRepository.findAllById(chucVuIds).stream().collect(Collectors.toMap(ChucVu::getId,r -> r));
        var phongBans = phongBanRepository.findAllById(phongBanIds).stream().collect(Collectors.toMap(PhongBan::getId, r -> r));
        for (NhanVien nhanVien : nhanViens) {
            nhanVien.setChucVu(chucVus.get(nhanVien.getChucVuId()));
            nhanVien.setPhongBan(phongBans.get(nhanVien.getPhongBanId()));
        }
        return nhanViens;
    }
    public NhanVien map(NhanVien nhanVien){
        return map(List.of(nhanVien)).get(0);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> findById(@PathVariable Long id){
        return ResponseEntity.of(nhanVienRepository.findById(id).map(this::map));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        nhanVienRepository.deleteById(id);
        return ResponseEntity.ok().build();
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
