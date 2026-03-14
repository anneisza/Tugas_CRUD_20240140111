package com.tugas.TugasCRUD_KTP.repository;

import com.tugas.TugasCRUD_KTP.model.entity.ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ktpRepository extends JpaRepository<ktp, Integer> {
    boolean existsByNomorKtp(String nomorKtp);
    Optional<ktp> findByNomorKtp(String nomorKtp);
}
