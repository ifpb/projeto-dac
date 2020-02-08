package br.edu.ifpb.dac.controllers;


import br.edu.ifpb.dac.ejb.dao.interfaces.AvaliacaoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class AvaliacaoController implements Serializable {

    private Avaliacao avaliacao;

    @Inject
    private AvaliacaoDao avaliacaoDAO;

    public List<Avaliacao> buscarTodosAsAvaliacoes(){
        return avaliacaoDAO.buscarTodos();
    }

    public String salvar(Avaliacao avaliacao){
        avaliacaoDAO.salvar(avaliacao);
        return null;
    }

    /*
    public String remover(Avaliacao avaliacao){
        this.avaliacaoDAO.remover(avaliacao);
        return null;
    }
     */

    public String atualizar(Avaliacao avaliacao){
        this.avaliacaoDAO.atualizar(avaliacao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarAvaliacao(Long id){
        this.avaliacaoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
}
