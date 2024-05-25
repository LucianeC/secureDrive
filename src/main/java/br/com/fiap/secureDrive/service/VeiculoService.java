package br.com.fiap.secureDrive.service;

import br.com.fiap.secureDrive.model.Veiculo;
import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    List<Veiculo> getAllVeiculos();
    Optional<Veiculo> getVeiculoById(Long id);
    Veiculo createVeiculo(Veiculo veiculo);
    Veiculo updateVeiculo(Long id, Veiculo veiculoDetails);
    void deleteVeiculo(Long id);
}
