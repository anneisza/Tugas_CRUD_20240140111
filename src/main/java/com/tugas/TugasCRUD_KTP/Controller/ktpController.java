package com.tugas.TugasCRUD_KTP.Controller;

import com.tugas.TugasCRUD_KTP.model.dto.ktpDto;
import com.tugas.TugasCRUD_KTP.model.dto.ktpRequest;
import com.tugas.TugasCRUD_KTP.service.ktpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
@RequiredArgsConstructor
public class ktpController {

    private final ktpService ktpService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> addKtp(@Valid @RequestBody ktpRequest request) {
        ktpDto result = ktpService.addKtp(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "status", "success",
                        "message", "Data KTP berhasil ditambahkan",
                        "data", result
                ));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllKtp() {
        List<ktpDto> result = ktpService.getAllKtp();
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getKtpById(@PathVariable Integer id) {
        ktpDto result = ktpService.getKtpById(id);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateKtp(
            @PathVariable Integer id,
            @Valid @RequestBody ktpRequest request) {
        ktpDto result = ktpService.updateKtp(id, request);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Data KTP berhasil diperbarui",
                "data", result
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteKtp(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Data KTP dengan id " + id + " berhasil dihapus"
        ));
    }
}
