package br.com.fiap.secureDrive.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;



@Entity
@Table(name = "tbl_moradores")
public class Morador {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MORADOR_SEQ"
    )

    @SequenceGenerator(
            name = "MORADOR_SEQ",
            sequenceName = "MORADOR_SEQ",
            allocationSize = 1
    )
    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotEmpty(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morador morador = (Morador) o;
        return Objects.equals(id, morador.id) && Objects.equals(nome, morador.nome) && Objects.equals(email, morador.email) && Objects.equals(senha, morador.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha);
    }

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



}
