package com.tugas.TugasCRUD_KTP.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ktpDto {
    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
}
