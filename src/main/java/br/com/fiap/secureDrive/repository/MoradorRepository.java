package br.com.fiap.secureDrive.repository;

import br.com.fiap.secureDrive.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoradorRepository extends JpaRepository<Morador, Long> {
}
