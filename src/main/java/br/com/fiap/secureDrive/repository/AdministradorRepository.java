package br.com.fiap.secureDrive.repository;

import br.com.fiap.secureDrive.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
