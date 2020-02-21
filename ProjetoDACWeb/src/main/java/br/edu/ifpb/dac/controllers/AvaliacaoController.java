package br.edu.ifpb.dac.controllers;


import br.edu.ifpb.dac.ejb.dao.interfaces.AvaliacaoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.CriterioAvaliacao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.services.impl.AvaliacaoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class AvaliacaoController implements Serializable {

    @Inject
    private AvaliacaoService avaliacaoService;

    private Avaliacao avaliacao;

    private Inscricao inscricao;

    private Professor avaliador;

    private List<CriterioAvaliacao> criterioAvaliacao;

    private CriterioAvaliacao criterio;

    private Float notaGeral;

    public List<Avaliacao> buscarTodosAsAvaliacoes(){
        return avaliacaoService.buscarTodos();
    }

    public String salvar(){
        this.avaliacao = new Avaliacao();
        avaliacao.setAvaliador(avaliador);
        avaliacao.setInscricao(inscricao);
        avaliacao.setCriteriosAvaliacao(criterioAvaliacao);
        avaliacao.setNotaGeral(notaGeral);

        avaliacaoService.salvar(avaliacao);
        return null;
    }

    /*
    public String remover(Avaliacao avaliacao){
        this.avaliacaoDAO.remover(avaliacao);
        return null;
    }
     */

    public String atualizar(Avaliacao avaliacao){
        this.avaliacaoService.atualizar(avaliacao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarAvaliacao(Long id){
        this.avaliacaoService.buscarId(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
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

    public List<CriterioAvaliacao> getCriterioAvaliacao() {
        return criterioAvaliacao;
    }

    public void setCriterioAvaliacao(List<CriterioAvaliacao> criterioAvaliacao) {
        this.criterioAvaliacao = criterioAvaliacao;
    }

    public CriterioAvaliacao getCriterio() {
        return criterio;
    }

    public void setCriterio(CriterioAvaliacao criterio) {
        this.criterio = criterio;
    }

    public Float getNotaGeral() {
        return notaGeral;
    }

    public void setNotaGeral(Float notaGeral) {
        this.notaGeral = notaGeral;
    }
}
