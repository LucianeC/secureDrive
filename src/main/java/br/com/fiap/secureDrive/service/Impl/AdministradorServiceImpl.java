package br.com.fiap.secureDrive.service.Impl;

import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Administrador;
import br.com.fiap.secureDrive.repository.AdministradorRepository;
import br.com.fiap.secureDrive.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    @Override
    public Optional<Administrador> getAdministradorById(Long id) {
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador createAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public Administrador updateAdministrador(Long id, Administrador administradorDetails) {
        Optional<Administrador> administrador = administradorRepository.findById(id);
        if (administrador.isPresent()) {
            Administrador administradorToUpdate = administrador.get();
            administradorToUpdate.setNome(administradorDetails.getNome());
            administradorToUpdate.setEmail(administradorDetails.getEmail());
            administradorToUpdate.setSenha(administradorDetails.getSenha());
            return administradorRepository.save(administradorToUpdate);
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
