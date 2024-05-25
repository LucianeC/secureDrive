package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.dto.VeiculoDTO;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    List<VeiculoDTO> getAllVeiculos();
    Optional<VeiculoDTO> getVeiculoById(Long id);
    VeiculoDTO createVeiculo(VeiculoDTO veiculoDTO);
    VeiculoDTO updateVeiculo(Long id, VeiculoDTO veiculoDetails);
    void deleteVeiculo(Long id);
}
