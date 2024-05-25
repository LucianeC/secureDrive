package br.com.fiap.secureDrive.service.Impl;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.HorarioRestricao;
import br.com.fiap.secureDrive.repository.HorarioRestricaoRepository;
import br.com.fiap.secureDrive.service.HorarioRestricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioRestricaoServiceImpl implements HorarioRestricaoService {

    @Autowired
    private HorarioRestricaoRepository horarioRestricaoRepository;

    @Override
    public List<HorarioRestricao> getAllHorariosRestricao() {
        return horarioRestricaoRepository.findAll();
    }

    @Override
    public Optional<HorarioRestricao> getHorarioRestricaoById(Long id) {
        return horarioRestricaoRepository.findById(id);
    }

    @Override
    public HorarioRestricao createHorarioRestricao(HorarioRestricao horarioRestricao) {
        return horarioRestricaoRepository.save(horarioRestricao);
    }

    @Override
    public HorarioRestricao updateHorarioRestricao(Long id, HorarioRestricao horarioRestricaoDetails) {
        Optional<HorarioRestricao> horarioRestricao = horarioRestricaoRepository.findById(id);
        if (horarioRestricao.isPresent()) {
            HorarioRestricao horarioRestricaoToUpdate = horarioRestricao.get();
            horarioRestricaoToUpdate.setInicio(horarioRestricaoDetails.getInicio());
            horarioRestricaoToUpdate.setFim(horarioRestricaoDetails.getFim());
            horarioRestricaoToUpdate.setTipoVeiculo(horarioRestricaoDetails.getTipoVeiculo());
            return horarioRestricaoRepository.save(horarioRestricaoToUpdate);
        } else {
            throw new ResourceNotFoundException("HorarioRestricao não encontrado com o ID fornecido. - " + id);
        }
    }

    @Override
    public void deleteHorarioRestricao(Long id) {
        if (horarioRestricaoRepository.existsById(id)) {
            horarioRestricaoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("HorarioRestricao não encontrado com o ID fornecido. -" + id);
        }
    }

}
