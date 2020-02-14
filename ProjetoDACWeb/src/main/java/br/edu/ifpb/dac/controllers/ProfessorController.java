package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.entidades.Tema;
import br.edu.ifpb.dac.ejb.services.impl.ProfessorService;
import br.edu.ifpb.dac.web.LoginUsuarioBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@SessionScoped
@Named
public class ProfessorController implements Serializable {

    private Professor professor;

    @Inject
    private ProfessorService professorService;
    
    
    @Inject
    private TemaController temaService;

    @PostConstruct
    public void init(){
        professor = new Professor();
    }

    public String CadastrarProfessor(){
        try {
            professorService.cadastrarProfessor(professor);
            return "/login?faces-redirect=true";
        }catch (Exception e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário existente", "Detalhe");
            FacesContext.getCurrentInstance().addMessage("msg", facesMsg);
            return null;
        }
    }
    

    
    
    public String excluirTema(Tema tema) {
    	this.temaService.remover(tema);
    	return null;
    }

    public List<Professor> buscarTodosOsProfessores(){
        return professorService.listarProfessores();
    }

    public String remover(Professor professor){
        this.professorService.removerProfessor(professor);
        return null;
    }

    public String atualizar(Professor professor){
        this.professorService.atualizarProfessor(professor);
        return null;
    }
    public String buscarProfessor(Long id){
        this.professorService.buscarProfessor(id);
        return null;
    }

    public Optional<Professor> buscarProfessorPorMatricula(String matricula){
        return this.professorService.buscarPorMatricula(matricula);
    }

    //getters e setters

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String goToTemas(){
        return "/restricted/temas.xhtml?faces-redirect=true";
    }


}
