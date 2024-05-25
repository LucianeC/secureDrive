package br.com.fiap.secureDrive.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class VeiculoDTO {
    private Long id;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotBlank(message = "Placa é obrigatória")
    private String placa;

    @NotNull(message = "O ID do morador é obrigatório")
    private Long moradorId;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getMoradorId() {
        return moradorId;
    }

    public void setMoradorId(Long moradorId) {
        this.moradorId = moradorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoDTO that = (VeiculoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(modelo, that.modelo) && Objects.equals(placa, that.placa) && Objects.equals(moradorId, that.moradorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo, placa, moradorId);
    }
}
