package br.com.fiap.secureDrive.mapper;

import br.com.fiap.secureDrive.dto.VeiculoDTO;
import br.com.fiap.secureDrive.model.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeiculoMapper {
    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    VeiculoDTO toDto(Veiculo veiculo);

    Veiculo toEntity(VeiculoDTO veiculoDTO);
}
