package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.dto.MoradorDTO;

import java.util.List;
import java.util.Optional;

public interface MoradorService {
    List<MoradorDTO> getAllMoradores();
    Optional<MoradorDTO> getMoradorById(Long id);
    MoradorDTO createMorador(MoradorDTO moradorDTO);
    MoradorDTO updateMorador(Long id, MoradorDTO moradorDetails);
    void deleteMorador(Long id);
}
