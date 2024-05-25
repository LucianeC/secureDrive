package br.com.fiap.secureDrive.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "tbl_veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "VEICULOS_SEQ"
    )

    @SequenceGenerator(
            name = "VEICULOS_SEQ",
            sequenceName = "VEICULOS_SEQ",
            allocationSize = 1
    )
    private Long id;

    @NotEmpty(message = "Placa é obrigatória")
    @Size(min = 7, max = 7, message = "Placa deve ter 7 caracteres")
    private String placa;

    @NotEmpty(message = "Modelo é obrigatório")
    private String modelo;

    @NotEmpty(message = "Cor é obrigatória")
    private String cor;
    private boolean autorizado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return autorizado == veiculo.autorizado && Objects.equals(id, veiculo.id) && Objects.equals(placa, veiculo.placa) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(cor, veiculo.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa, modelo, cor, autorizado);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }


}
