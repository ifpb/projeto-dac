package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.dao.interfaces.PreProjetoDao;
import br.edu.ifpb.dac.ejb.entidades.PreProjeto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class PreProjetoController implements Serializable {

    private PreProjeto preProjeto;

    @Inject
    private PreProjetoDao preProjetoDAO;

    public List<PreProjeto> buscarTodosOsPreProjetos(){
        return preProjetoDAO.buscarTodos();
    }

    public String salvar(PreProjeto preProjeto){
        preProjetoDAO.salvar(preProjeto);
        return null;
    }

    /*                                              Criar esse método no DAO de aluno
    public String remover((PreProjeto preProjeto){
        this.preProjetoDAO.remover(preProjeto);
        return null;
    }
     */

    public String atualizar(PreProjeto preProjeto){
        this.preProjetoDAO.atualizar(preProjeto);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarPreProjeto(Long id){
        this.preProjetoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public PreProjeto getPreProjeto() {
        return preProjeto;
    }

    public void setPreProjeto(PreProjeto preProjeto) {
        this.preProjeto = preProjeto;
    }
}
