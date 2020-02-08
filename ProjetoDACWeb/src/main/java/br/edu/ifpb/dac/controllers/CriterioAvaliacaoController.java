package br.edu.ifpb.dac.controllers;


import br.edu.ifpb.dac.ejb.dao.interfaces.CriterioAvaliacaoDao;
import br.edu.ifpb.dac.ejb.entidades.CriterioAvaliacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class CriterioAvaliacaoController implements Serializable {

    private CriterioAvaliacao criterioAvaliacao;

    @Inject
    private CriterioAvaliacaoDao criterioAvaliacaoDAO;

    public List<CriterioAvaliacao> buscarTodosOsCriteriosDeAvaliacao(){
        return criterioAvaliacaoDAO.buscarTodos();
    }

    public String salvar(CriterioAvaliacao criterioAvaliacao){
        criterioAvaliacaoDAO.salvar(criterioAvaliacao);
        return null;
    }

    /*
    public String remover(CriterioAvaliacao criterioAvaliacao){
        criterioAvaliacaoDAO.remover(criterioAvaliacao);
        return null;
    }
     */

    public String atualizar(CriterioAvaliacao criterioAvaliacao){
        this.criterioAvaliacaoDAO.atualizar(criterioAvaliacao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarAluno(Long id){
        this.criterioAvaliacaoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public CriterioAvaliacao getCriterioAvaliacao() {
        return criterioAvaliacao;
    }

    public void setCriterioAvaliacao(CriterioAvaliacao criterioAvaliacao) {
        this.criterioAvaliacao = criterioAvaliacao;
    }
}
