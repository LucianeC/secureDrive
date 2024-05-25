package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.dto.HorarioRestricaoDTO;

import java.util.List;
import java.util.Optional;

public interface HorarioRestricaoService {
    List<HorarioRestricaoDTO> getAllHorariosRestricao();
    Optional<HorarioRestricaoDTO> getHorarioRestricaoById(Long id);
    HorarioRestricaoDTO createHorarioRestricao(HorarioRestricaoDTO horarioRestricaoDTO);
    HorarioRestricaoDTO updateHorarioRestricao(Long id, HorarioRestricaoDTO horarioRestricaoDetails);
    void deleteHorarioRestricao(Long id);
}
