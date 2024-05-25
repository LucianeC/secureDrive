package br.com.fiap.secureDrive.service.Impl;

import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Veiculo;
import br.com.fiap.secureDrive.repository.VeiculoRepository;
import br.com.fiap.secureDrive.repository.MoradorRepository;
import br.com.fiap.secureDrive.service.VeiculoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import br.com.fiap.secureDrive.dto.VeiculoDTO;
import br.com.fiap.secureDrive.mapper.VeiculoMapper;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    @Override
    public List<VeiculoDTO> getAllVeiculos() {
        return veiculoRepository.findAll().stream()
                .map(VeiculoMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VeiculoDTO> getVeiculoById(Long id) {
        return veiculoRepository.findById(id)
                .map(VeiculoMapper.INSTANCE::toDto);
    }

    @Override
    public VeiculoDTO createVeiculo(VeiculoDTO veiculoDTO) {
        if (moradorRepository.existsById(veiculoDTO.getMoradorId())) {
            Veiculo veiculo = VeiculoMapper.INSTANCE.toEntity(veiculoDTO);
            return VeiculoMapper.INSTANCE.toDto(veiculoRepository.save(veiculo));
        } else {
            throw new ResourceNotFoundException("Morador não encontrado com o ID fornecido - " + veiculoDTO.getMoradorId());
        }
    }

    @Override
    public VeiculoDTO updateVeiculo(Long id, VeiculoDTO veiculoDetails) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (veiculo.isPresent()) {
            Veiculo veiculoToUpdate = veiculo.get();
            veiculoToUpdate.setModelo(veiculoDetails.getModelo());
            veiculoToUpdate.setPlaca(veiculoDetails.getPlaca());
            return VeiculoMapper.INSTANCE.toDto(veiculoRepository.save(veiculoToUpdate));
        } else {
            throw new ResourceNotFoundException("Veículo não encontrado com o ID fornecido - " + id);
        }
    }

    @Override
    public void deleteVeiculo(Long id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Veículo não encontrado com o ID fornecido - " + id);
        }
    }
}
