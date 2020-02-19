package br.edu.ifpb.dac.controllers;



import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Tema;
import br.edu.ifpb.dac.ejb.services.impl.InscricaoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@RequestScoped
@Named
public class InscricaoController implements Serializable {

    private Inscricao inscricao;

    @Inject
    private InscricaoService inscricaoService;

    public List<Inscricao> buscarTodosAsInscricoes(){
        return inscricaoService.buscarTodos();
    }

    public String salvar(Tema tema, Aluno aluno){
//        inscricao.setAluno(aluno);
//        inscricao.setDataInscricao(new Date());
//        inscricao.setProfessor(tema.getProfessor());
//        inscricao.setTema(tema);
//        inscricaoService.salvar(inscricao);
        return null;
    }

    /*                                              Criar esse método no DAO de aluno
    public String remover(Inscricao inscricao){
        this.inscricaoDAO.remover(inscricao);
        return null;
    }
     */

    public String atualizar(Inscricao inscricao){
        this.inscricaoService.atualizar(inscricao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarInscricao(Long id){
        this.inscricaoService.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }
}
