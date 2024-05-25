package br.com.fiap.secureDrive.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class HorarioRestricaoDTO {
    private Long id;

    @NotBlank(message = "O campo horário de início é obrigatório")
    private String inicio;

    @NotBlank(message = "O campo horário de término é obrigatório")
    private String fim;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setFim(String fim) {
        this.fim = fim;
    }

    public LocalTime getInicio() {
        return null;
    }

    public LocalTime getFim() {
        return null;
    }

}
