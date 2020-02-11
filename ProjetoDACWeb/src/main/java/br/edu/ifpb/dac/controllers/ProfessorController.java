package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.entidades.Tema;
import br.edu.ifpb.dac.ejb.services.impl.ProfessorService;
import br.edu.ifpb.dac.web.LoginUsuarioBean;

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

    private Professor professor = new Professor();
    
    private Tema tema = new Tema();

    @Inject
    private ProfessorService professorService;
    
    @Inject
    private LoginUsuarioBean loginService;
    
    @Inject
    private TemaController temaService;

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
    
    public String cadastrarTemas() {
    	this.tema.setProfessor(loginService.getProfessorLogado());
    	this.tema.setDisponivel(true);
    	this.temaService.salvar(this.tema);
    	this.tema=new Tema();
    	return "temas.xhtml?faces-redirect=true";
    }
    
    //na página temas o botão editar deve acionar esse método
    //ele salva nesse controlador o tema que vai ser editado.
    //o usuário é então direcionado para uma página com todas as informações sobre o tema, a página tema.xhtml
    //onde ele poderá realizar as edições e depois confirmar acionando o método confirmarEdicao
    public String editarTema(Tema tema){
    	this.tema = tema;
    	return "tema.xhtml?faces-redirect=true";
    }
    
    
    // método que deve ser acionado para confirmar as edições na página tema
    public String confirmarEdicao(){
    	this.temaService.atualizar(this.tema);
    	this.tema = new Tema();
    	return "temas.xhtml?faces-redirect=true";
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


}
