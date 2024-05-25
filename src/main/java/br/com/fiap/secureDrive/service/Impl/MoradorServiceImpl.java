package br.com.fiap.secureDrive.service.Impl;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Morador;
import br.com.fiap.secureDrive.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import br.com.fiap.secureDrive.service.MoradorService;

@Service
public class MoradorServiceImpl implements MoradorService {
    @Autowired
    private MoradorRepository moradorRepository;

    @Override
    public List<Morador> getAllMoradores() {
        return moradorRepository.findAll();
    }

    @Override
    public Optional<Morador> getMoradorById(Long id) {
        return moradorRepository.findById(id);
    }

    @Override
    public Morador createMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    @Override
    public Morador updateMorador(Long id, Morador moradorDetails) {
        Optional<Morador> morador = moradorRepository.findById(id);
        if (morador.isPresent()) {
            Morador moradorToUpdate = morador.get();
            moradorToUpdate.setNome(moradorDetails.getNome());
            moradorToUpdate.setEmail(moradorDetails.getEmail());
            moradorToUpdate.setSenha(moradorDetails.getSenha());
            return moradorRepository.save(moradorToUpdate);
        } else {
            throw new ResourceNotFoundException("Morador não encontrado com o ID fornecido. -" + id);
        }
    }

    @Override
    public void deleteMorador(Long id) {
        if (moradorRepository.existsById(id)) {
            moradorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(" Morador não encontrado com o ID fornecido. -" + id);
        }
    }
}
