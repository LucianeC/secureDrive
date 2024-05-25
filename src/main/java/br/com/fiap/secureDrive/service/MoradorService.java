package br.com.fiap.secureDrive.service;
import br.com.fiap.secureDrive.model.Morador;

import java.util.List;
import java.util.Optional;
public interface MoradorService {
    List<Morador> getAllMoradores();
    Optional<Morador> getMoradorById(Long id);
    Morador createMorador(Morador morador);
    Morador updateMorador(Long id, Morador moradorDetails);
    void deleteMorador(Long id);
}
