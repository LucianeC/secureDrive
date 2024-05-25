package br.com.fiap.secureDrive.controller;

import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.Administrador;
import br.com.fiap.secureDrive.service.AdministradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.secureDrive.dto.AdministradorDTO;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administradores")
@Validated
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public List<AdministradorDTO> getAllAdministradores() {
        return administradorService.getAllAdministradores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> getAdministradorById(@PathVariable Long id) {
        Optional<AdministradorDTO> administrador = administradorService.getAdministradorById(id);
        return administrador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdministradorDTO createAdministrador(@RequestBody AdministradorDTO administradorDTO) {
        return administradorService.createAdministrador(administradorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDTO> updateAdministrador(@PathVariable Long id, @Valid @RequestBody AdministradorDTO administradorDetails) {
        try {
            AdministradorDTO updatedAdministrador = administradorService.updateAdministrador(id, administradorDetails);
            return ResponseEntity.ok(updatedAdministrador);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrador(@PathVariable Long id) {
        try {
            administradorService.deleteAdministrador(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
