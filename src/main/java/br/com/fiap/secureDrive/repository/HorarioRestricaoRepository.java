package br.com.fiap.secureDrive.repository;

import br.com.fiap.secureDrive.model.HorarioRestricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRestricaoRepository extends JpaRepository<HorarioRestricao, Long> {
}
