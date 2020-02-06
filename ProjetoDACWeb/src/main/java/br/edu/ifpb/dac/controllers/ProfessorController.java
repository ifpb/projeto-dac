package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.dao.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class ProfessorController implements Serializable {

    private Professor professor = new Professor();

    @Inject
    private ProfessorDao professorDao;

    public List<Professor> buscarTodosOsProfessores(){
        return professorDao.buscarTodos();
    }

    public String CadastrarProfessor(){
        try {
            professorDao.salvar(professor);
            return "login.xhtml";
        }catch (Exception e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário existente", "Detalhe");
            FacesContext.getCurrentInstance().addMessage("msg", facesMsg);
            return null;
        }
    }

    /*                                              Criar esse método no DAO de professor
    public String remover(Professor professor){
        this.professorDAO.remover(professor);
        return null;
    }
     */

    public String atualizar(Professor professor){
        this.professorDao.atualizar(professor);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarProfessor(Long id){
        this.professorDao.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
