package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Aluno aluno;

    @OneToOne
    private Professor professor;

    @OneToOne
    private Tema tema;

    @Temporal(TemporalType.DATE)
    private Date dataInscricao;

    @OneToOne
    private Periodo periodo;

    @OneToOne
    private PreProjeto preProjeto;

    private float notaFinal;

    @OneToMany
    private List<Avaliacao> avaliacoes;

    public enum Status  { AGUARDANDO, CONTEMPLADO, NEGADO }

    @Enumerated(EnumType.STRING)
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public PreProjeto getPreProjeto() {
        return preProjeto;
    }

    public void setPreProjeto(PreProjeto preProjeto) {
        this.preProjeto = preProjeto;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
