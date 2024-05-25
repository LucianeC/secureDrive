package br.com.fiap.secureDrive.mapper;

import br.com.fiap.secureDrive.dto.AdministradorDTO;
import br.com.fiap.secureDrive.model.Administrador;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdministradorMapper {
    AdministradorMapper INSTANCE = Mappers.getMapper(AdministradorMapper.class);

    AdministradorDTO toDto(Administrador administrador);

    Administrador toEntity(AdministradorDTO administradorDTO);
}
