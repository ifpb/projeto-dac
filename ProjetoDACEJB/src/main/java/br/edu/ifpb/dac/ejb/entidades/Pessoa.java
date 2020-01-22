package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 60)
    private String nome;

    @Column(length = 30)
    private String email;

    @Column(length = 12)
    private String matricula;

    @Column(length = 20)
    private String senha;

    public enum Curso {ADS, ENGENHARIA_CIVIL, ENGENHARIA_AUTOMACAO}

    @Enumerated(EnumType.STRING)
    private Curso curso;


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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
