package br.com.fiap.secureDrive.controller;

import br.com.fiap.secureDrive.dto.HorarioRestricaoDTO;
import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.service.HorarioRestricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios-restricao")
public class HorarioRestricaoController {
    @Autowired
    private HorarioRestricaoService horarioRestricaoService;

    @GetMapping
    public List<HorarioRestricaoDTO> getAllHorariosRestricao() {
        return horarioRestricaoService.getAllHorariosRestricao();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioRestricaoDTO> getHorarioRestricaoById(@PathVariable Long id) {
        Optional<HorarioRestricaoDTO> horarioRestricaoDTO = horarioRestricaoService.getHorarioRestricaoById(id);
        return horarioRestricaoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<HorarioRestricaoDTO> createHorarioRestricao(@Validated @RequestBody HorarioRestricaoDTO horarioRestricaoDTO) {
        HorarioRestricaoDTO createdHorarioRestricao = horarioRestricaoService.createHorarioRestricao(horarioRestricaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHorarioRestricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioRestricaoDTO> updateHorarioRestricao(@PathVariable Long id, @Validated @RequestBody HorarioRestricaoDTO horarioRestricaoDetails) {
        try {
            HorarioRestricaoDTO updatedHorarioRestricao = horarioRestricaoService.updateHorarioRestricao(id, horarioRestricaoDetails);
            return ResponseEntity.ok(updatedHorarioRestricao);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorarioRestricao(@PathVariable Long id) {
        try {
            horarioRestricaoService.deleteHorarioRestricao(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
