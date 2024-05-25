package br.com.fiap.secureDrive.controller;

import br.com.fiap.secureDrive.dto.VeiculoDTO;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoDTO> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> getVeiculoById(@PathVariable Long id) {
        Optional<VeiculoDTO> veiculoDTO = veiculoService.getVeiculoById(id);
        return veiculoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> createVeiculo(@Validated @RequestBody VeiculoDTO veiculoDTO) {
        try {
            VeiculoDTO createdVeiculo = veiculoService.createVeiculo(veiculoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdVeiculo);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> updateVeiculo(@PathVariable Long id, @Validated @RequestBody VeiculoDTO veiculoDetails) {
        try {
            VeiculoDTO updatedVeiculo = veiculoService.updateVeiculo(id, veiculoDetails);
            return ResponseEntity.ok(updatedVeiculo);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        try {
            veiculoService.deleteVeiculo(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
