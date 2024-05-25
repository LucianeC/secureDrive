package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.model.HorarioRestricao;
import java.util.List;
import java.util.Optional;
public interface HorarioRestricaoService {
    List<HorarioRestricao> getAllHorariosRestricao();
    Optional<HorarioRestricao> getHorarioRestricaoById(Long id);
    HorarioRestricao createHorarioRestricao(HorarioRestricao horarioRestricao);
    HorarioRestricao updateHorarioRestricao(Long id, HorarioRestricao horarioRestricaoDetails);
    void deleteHorarioRestricao(Long id);
}
