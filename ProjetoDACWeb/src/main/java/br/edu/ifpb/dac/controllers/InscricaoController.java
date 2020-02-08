package br.edu.ifpb.dac.controllers;



import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class InscricaoController implements Serializable {

    private Inscricao inscricao;

    @Inject
    private InscricaoDao inscricaoDAO;

    public List<Inscricao> buscarTodosAsInscricoes(){
        return inscricaoDAO.buscarTodos();
    }

    public String salvar(Inscricao inscricao){
        inscricaoDAO.salvar(inscricao);
        return null;
    }

    /*                                              Criar esse método no DAO de aluno
    public String remover(Inscricao inscricao){
        this.inscricaoDAO.remover(inscricao);
        return null;
    }
     */

    public String atualizar(Inscricao inscricao){
        this.inscricaoDAO.atualizar(inscricao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarInscricao(Long id){
        this.inscricaoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
}
