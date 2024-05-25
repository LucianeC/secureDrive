package br.com.fiap.secureDrive.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class AdministradorDTO {
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministradorDTO that = (AdministradorDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha);
    }
}
