package com.tugas.TugasCRUD_KTP.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ktpRequest {

    @NotBlank(message = "Nomor KTP tidak boleh kosong")
    @Size(min = 16, max = 16, message = "Nomor KTP harus 16 digit")
    private String nomorKtp;

    @NotBlank(message = "Nama lengkap tidak boleh kosong")
    private String namaLengkap;

    private String alamat;

    private LocalDate tanggalLahir;

    @NotBlank(message = "Jenis kelamin harus dipilih")
    private String jenisKelamin;
}
