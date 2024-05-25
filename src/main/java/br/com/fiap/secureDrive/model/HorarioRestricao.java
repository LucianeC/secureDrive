package br.com.fiap.secureDrive.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class HorarioRestricao {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "HORARIO_RESTRICAO_SEQ"
    )

    @SequenceGenerator(
            name = "HORARIO_RESTRICAO_SEQ",
            sequenceName = "HORARIO_RESTRICAO_SEQ",
            allocationSize = 1
    )

    private Long id;

    private LocalTime inicio;

    private LocalTime fim;

    @NotEmpty(message = "Tipo de veículo é obrigatório")
    private String tipoVeiculo;


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
        this.fim = fim;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioRestricao that = (HorarioRestricao) o;
        return Objects.equals(id, that.id) && Objects.equals(inicio, that.inicio) && Objects.equals(fim, that.fim) && Objects.equals(tipoVeiculo, that.tipoVeiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inicio, fim, tipoVeiculo);
    }


}