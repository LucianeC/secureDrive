package br.com.fiap.secureDrive.controller;

import br.com.fiap.secureDrive.dto.MoradorDTO;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moradores")
public class MoradorController {
    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public List<MoradorDTO> getAllMoradores() {
        return moradorService.getAllMoradores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoradorDTO> getMoradorById(@PathVariable Long id) {
        Optional<MoradorDTO> moradorDTO = moradorService.getMoradorById(id);
        return moradorDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<MoradorDTO> createMorador(@Validated @RequestBody MoradorDTO moradorDTO) {
        MoradorDTO createdMorador = moradorService.createMorador(moradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMorador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoradorDTO> updateMorador(@PathVariable Long id, @Validated @RequestBody MoradorDTO moradorDetails) {
        try {
            MoradorDTO updatedMorador = moradorService.updateMorador(id, moradorDetails);
            return ResponseEntity.ok(updatedMorador);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMorador(@PathVariable Long id) {
        try {
            moradorService.deleteMorador(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
