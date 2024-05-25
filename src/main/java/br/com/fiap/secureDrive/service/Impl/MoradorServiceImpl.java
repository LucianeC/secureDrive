package br.com.fiap.secureDrive.service.Impl;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Morador;
import br.com.fiap.secureDrive.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import br.com.fiap.secureDrive.service.MoradorService;
import br.com.fiap.secureDrive.dto.MoradorDTO;
import br.com.fiap.secureDrive.mapper.MoradorMapper;
import java.util.stream.Collectors;


@Service
public class MoradorServiceImpl implements MoradorService {
    @Autowired
    private MoradorRepository moradorRepository;

    @Override
    public List<MoradorDTO> getAllMoradores() {
        return moradorRepository.findAll().stream()
                .map(MoradorMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MoradorDTO> getMoradorById(Long id) {
        return moradorRepository.findById(id)
                .map(MoradorMapper.INSTANCE::toDto);
    }

    @Override
    public MoradorDTO createMorador(MoradorDTO moradorDTO) {
        Morador morador = MoradorMapper.INSTANCE.toEntity(moradorDTO);
        return MoradorMapper.INSTANCE.toDto(moradorRepository.save(morador));
    }

    @Override
    public MoradorDTO updateMorador(Long id, MoradorDTO moradorDetails) {
        Optional<Morador> morador = moradorRepository.findById(id);
        if (morador.isPresent()) {
            Morador moradorToUpdate = morador.get();
            moradorToUpdate.setNome(moradorDetails.getNome());
            moradorToUpdate.setEmail(moradorDetails.getEmail());
            return MoradorMapper.INSTANCE.toDto(moradorRepository.save(moradorToUpdate));
        } else {
            throw new ResourceNotFoundException("Morador não encontrado com o ID fornecido - " + id);
        }
    }

    @Override
    public void deleteMorador(Long id) {
        if (moradorRepository.existsById(id)) {
            moradorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Morador não encontrado com o ID fornecido - " + id);
        }
    }
}
