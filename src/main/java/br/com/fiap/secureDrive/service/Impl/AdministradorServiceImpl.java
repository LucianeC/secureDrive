package br.com.fiap.secureDrive.service.Impl;

import br.com.fiap.secureDrive.dto.AdministradorDTO;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Administrador;
import br.com.fiap.secureDrive.repository.AdministradorRepository;
import br.com.fiap.secureDrive.service.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.secureDrive.mapper.AdministradorMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<AdministradorDTO> getAllAdministradores() {
        return administradorRepository.findAll().stream()
                .map(AdministradorMapper.INSTANCE::toDto)
                .collect(Collectors.toList()).reversed();
    }

    @Override
    public Optional<AdministradorDTO> getAdministradorById(Long id) {
        return administradorRepository.findById(id)
                .map(AdministradorMapper.INSTANCE::toDto);
    }


    @Override
    public AdministradorDTO createAdministrador(AdministradorDTO administradorDTO) {
        Administrador administrador = AdministradorMapper.INSTANCE.toEntity(administradorDTO);
        return AdministradorMapper.INSTANCE.toDto(administradorRepository.save(administrador));
    }

    @Override
    public AdministradorDTO updateAdministrador(Long id, @Valid AdministradorDTO administradorDetails) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()) {
            Administrador administradorToUpdate = administrador.get();
            administradorToUpdate.setNome(administradorDetails.getNome());
            administradorToUpdate.setEmail(administradorDetails.getEmail());
            administradorToUpdate.setSenha(administradorDetails.getSenha());
            return AdministradorMapper.INSTANCE.toDto(administradorRepository.save(administradorToUpdate));
        } else {
            throw new ResourceNotFoundException("Administrador não encontrado com o ID fornecido - " + id);
        }
    }

    @Override
    public void deleteAdministrador(Long id) {
        if (administradorRepository.existsById(id)) {
            administradorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Administrador  não encontrado com o ID fornecido - " + id);
        }
    }
}
