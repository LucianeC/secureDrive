package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.model.Administrador;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {
    List<Administrador> getAllAdministradores();
    Optional<Administrador> getAdministradorById(Long id);
    Administrador createAdministrador(Administrador administrador);
    Administrador updateAdministrador(Long id, Administrador administradorDetails);
    void deleteAdministrador(Long id);
}
