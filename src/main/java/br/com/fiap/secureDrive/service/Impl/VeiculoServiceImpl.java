package br.com.fiap.secureDrive.service.Impl;

import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Veiculo;
import br.com.fiap.secureDrive.repository.VeiculoRepository;
import br.com.fiap.secureDrive.service.VeiculoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    @Override
    public Optional<Veiculo> getVeiculoById(Long id) {
        return veiculoRepository.findById(id);
    }

    @Override
    public Veiculo createVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo updateVeiculo(Long id, Veiculo veiculoDetails) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (veiculo.isPresent()) {
            Veiculo veiculoToUpdate = veiculo.get();
            veiculoToUpdate.setPlaca(veiculoDetails.getPlaca());
            veiculoToUpdate.setModelo(veiculoDetails.getModelo());
            veiculoToUpdate.setCor(veiculoDetails.getCor());
            veiculoToUpdate.setAutorizado(veiculoDetails.isAutorizado());
            return veiculoRepository.save(veiculoToUpdate);
        } else {
            throw new ResourceNotFoundException("Veiculo not found with id " + id);
        }
    }

    @Override
    public void deleteVeiculo(Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Veiculo not found with id " + id);
        }
    }
}
