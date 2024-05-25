package br.com.fiap.secureDrive.mapper;

import br.com.fiap.secureDrive.dto.MoradorDTO;
import br.com.fiap.secureDrive.model.Morador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MoradorMapper {
    MoradorMapper INSTANCE = Mappers.getMapper(MoradorMapper.class);

    MoradorDTO toDto(Morador morador);

    Morador toEntity(MoradorDTO moradorDTO);
}
