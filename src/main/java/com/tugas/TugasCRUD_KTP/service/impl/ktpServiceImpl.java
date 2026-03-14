package com.tugas.TugasCRUD_KTP.service.impl;

import com.tugas.TugasCRUD_KTP.model.dto.ktpDto;
import com.tugas.TugasCRUD_KTP.model.dto.ktpRequest;
import com.tugas.TugasCRUD_KTP.model.entity.ktp;
import com.tugas.TugasCRUD_KTP.repository.ktpRepository;
import com.tugas.TugasCRUD_KTP.mapper.ktpMapper;
import com.tugas.TugasCRUD_KTP.service.ktpService;
import com.tugas.TugasCRUD_KTP.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ktpServiceImpl implements ktpService {

    private final ktpRepository ktpRepository;
    private final ktpMapper ktpMapper;
    private final ValidationUtil validationUtil;

    @Override
    public ktpDto addKtp(ktpRequest request) {
        validationUtil.validate(request);

        if (ktpRepository.existsByNomorKtp(request.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }

        ktp ktp = ktpMapper.toEntity(request);
        ktp savedKtp = ktpRepository.save(ktp);
        return ktpMapper.toDto(savedKtp);
    }

    @Override
    public List<ktpDto> getAllKtp() {
        return ktpRepository.findAll()
                .stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ktpDto getKtpById(Integer id) {
        ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));
        return ktpMapper.toDto(ktp);
    }

    @Override
    public ktpDto updateKtp(Integer id, ktpRequest request) {
        validationUtil.validate(request);

        ktp existingKtp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));

        if (!existingKtp.getNomorKtp().equals(request.getNomorKtp())
                && ktpRepository.existsByNomorKtp(request.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }

        existingKtp.setNomorKtp(request.getNomorKtp());
        existingKtp.setNamaLengkap(request.getNamaLengkap());
        existingKtp.setAlamat(request.getAlamat());
        existingKtp.setTanggalLahir(request.getTanggalLahir());
        existingKtp.setJenisKelamin(request.getJenisKelamin());

        ktp updatedKtp = ktpRepository.save(existingKtp);
        return ktpMapper.toDto(updatedKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new RuntimeException("Data KTP tidak ditemukan!");
        }
        ktpRepository.deleteById(id);
    }
}
