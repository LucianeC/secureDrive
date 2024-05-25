package br.com.fiap.secureDrive.mapper;

import br.com.fiap.secureDrive.dto.HorarioRestricaoDTO;
import br.com.fiap.secureDrive.model.HorarioRestricao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HorarioRestricaoMapper {
    HorarioRestricaoMapper INSTANCE = Mappers.getMapper(HorarioRestricaoMapper.class);

    HorarioRestricaoDTO toDto(HorarioRestricao horarioRestricao);

    HorarioRestricao toEntity(HorarioRestricaoDTO horarioRestricaoDTO);
}
