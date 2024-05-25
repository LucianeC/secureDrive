package br.com.fiap.secureDrive.controller;

import br.com.fiap.secureDrive.exception.ResourceNotFoundException;
import br.com.fiap.secureDrive.model.HorarioRestricao;
import br.com.fiap.secureDrive.service.HorarioRestricaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios-restricao")
@Validated
public class HorarioRestricaoController {

    @Autowired
    private HorarioRestricaoService horarioRestricaoService;

    @GetMapping
    public List<HorarioRestricao> getAllHorariosRestricao() {
        return horarioRestricaoService.getAllHorariosRestricao();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioRestricao> getHorarioRestricaoById(@PathVariable Long id) {
        Optional<HorarioRestricao> horarioRestricao = horarioRestricaoService.getHorarioRestricaoById(id);
        return horarioRestricao.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HorarioRestricao createHorarioRestricao(@Valid @RequestBody HorarioRestricao horarioRestricao) {
        return horarioRestricaoService.createHorarioRestricao(horarioRestricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioRestricao> updateHorarioRestricao(@PathVariable Long id, @RequestBody HorarioRestricao horarioRestricaoDetails) {
        try {
            HorarioRestricao updatedHorarioRestricao = horarioRestricaoService.updateHorarioRestricao(id, horarioRestricaoDetails);
            return ResponseEntity.ok(updatedHorarioRestricao);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorarioRestricao(@PathVariable Long id) {
        try {
            horarioRestricaoService.deleteHorarioRestricao(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
