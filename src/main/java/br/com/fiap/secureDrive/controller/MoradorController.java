package br.com.fiap.secureDrive.controller;

import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Morador;
import br.com.fiap.secureDrive.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/moradores")
@Validated
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public List<Morador> getAllMoradores() {
        return moradorService.getAllMoradores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> getMoradorById(@PathVariable Long id) {
        Optional<Morador> morador = moradorService.getMoradorById(id);
        return morador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Morador createMorador(@Valid @RequestBody Morador morador) {
        return moradorService.createMorador(morador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Morador> updateMorador(@PathVariable Long id, @RequestBody Morador moradorDetails) {
        try {
            Morador updatedMorador = moradorService.updateMorador(id, moradorDetails);
            return ResponseEntity.ok(updatedMorador);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMorador(@PathVariable Long id) {
        try {
            moradorService.deleteMorador(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
