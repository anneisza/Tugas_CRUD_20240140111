package com.tugas.TugasCRUD_KTP.service;

import com.tugas.TugasCRUD_KTP.model.dto.ktpDto;
import com.tugas.TugasCRUD_KTP.model.dto.ktpRequest;
import java.util.List;

public interface ktpService {
    ktpDto addKtp(ktpRequest request);
    List<ktpDto> getAllKtp();
    ktpDto getKtpById(Integer id);
    ktpDto updateKtp(Integer id, ktpRequest request);
    void deleteKtp(Integer id);
}
