package br.edu.ifpb.dac.ejb.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Inscricao inscricao;

    @OneToOne
    private Professor avaliador;

    private Float notaGeral;

    @OneToMany
    private List<CriterioAvaliacao> criteriosAvaliacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Professor getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Professor avaliador) {
        this.avaliador = avaliador;
    }

    public Float getNotaGeral() {
        return notaGeral;
    }

    public void setNotaGeral(Float notaGeral) {
        this.notaGeral = notaGeral;
    }

    public List<CriterioAvaliacao> getCriteriosAvaliacao() {
        return criteriosAvaliacao;
    }

    public void setCriteriosAvaliacao(List<CriterioAvaliacao> criteriosAvaliacao) {
        this.criteriosAvaliacao = criteriosAvaliacao;
    }
}
