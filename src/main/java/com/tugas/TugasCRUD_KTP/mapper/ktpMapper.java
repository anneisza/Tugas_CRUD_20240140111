package com.tugas.TugasCRUD_KTP.mapper;

import com.tugas.TugasCRUD_KTP.model.dto.ktpDto;
import com.tugas.TugasCRUD_KTP.model.dto.ktpRequest;
import com.tugas.TugasCRUD_KTP.model.entity.ktp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ktpMapper {

    ktpMapper MAPPER = Mappers.getMapper(ktpMapper.class);

    ktp toEntity(ktpRequest request);

    ktpDto toDto(ktp ktp);
}
