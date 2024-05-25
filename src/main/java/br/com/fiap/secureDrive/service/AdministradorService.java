package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.dto.AdministradorDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {
    List<AdministradorDTO> getAllAdministradores();
    Optional<AdministradorDTO> getAdministradorById(Long id);
    AdministradorDTO createAdministrador(@Valid AdministradorDTO administrador);
    AdministradorDTO updateAdministrador(Long id, @Valid AdministradorDTO administradorDetails);
    void deleteAdministrador(Long id);
}
