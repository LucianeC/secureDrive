package br.com.fiap.secureDrive.service.Impl;
import br.com.fiap.secureDrive.dto.HorarioRestricaoDTO;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.mapper.HorarioRestricaoMapper;
import br.com.fiap.secureDrive.model.HorarioRestricao;
import br.com.fiap.secureDrive.repository.HorarioRestricaoRepository;
import br.com.fiap.secureDrive.service.HorarioRestricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HorarioRestricaoServiceImpl implements HorarioRestricaoService {

    @Autowired
    private HorarioRestricaoRepository horarioRestricaoRepository;

    @Override
    public List<HorarioRestricaoDTO> getAllHorariosRestricao() {
        return horarioRestricaoRepository.findAll().stream()
                .map(HorarioRestricaoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<HorarioRestricaoDTO> getHorarioRestricaoById(Long id) {
        return horarioRestricaoRepository.findById(id)
                .map(HorarioRestricaoMapper.INSTANCE::toDto);
    }

    @Override
    public HorarioRestricaoDTO createHorarioRestricao(HorarioRestricaoDTO horarioRestricaoDTO) {
        HorarioRestricao horarioRestricao = HorarioRestricaoMapper.INSTANCE.toEntity(horarioRestricaoDTO);
        return HorarioRestricaoMapper.INSTANCE.toDto(horarioRestricaoRepository.save(horarioRestricao));
    }

    @Override
    public HorarioRestricaoDTO updateHorarioRestricao(Long id, HorarioRestricaoDTO horarioRestricaoDetails) {
        Optional<HorarioRestricao> horarioRestricao = horarioRestricaoRepository.findById(id);
        if (horarioRestricao.isPresent()) {
            HorarioRestricao horarioRestricaoToUpdate = horarioRestricao.get();
            horarioRestricaoToUpdate.setInicio(horarioRestricaoDetails.getInicio());
            horarioRestricaoToUpdate.setFim(horarioRestricaoDetails.getFim());
            return HorarioRestricaoMapper.INSTANCE.toDto(horarioRestricaoRepository.save(horarioRestricaoToUpdate));
        } else {
            throw new ResourceNotFoundException("Horário de Restrição não encontrado com o ID fornecido - " + id);
        }
    }

    @Override
    public void deleteHorarioRestricao(Long id) {
        if (horarioRestricaoRepository.existsById(id)) {
            horarioRestricaoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Horário de Restrição não encontrado com o ID fornecido - " + id);
        }
    }

}
