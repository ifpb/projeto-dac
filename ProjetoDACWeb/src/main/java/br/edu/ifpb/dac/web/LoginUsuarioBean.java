package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.services.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.AutenticacaoServiceAluno;
import br.edu.ifpb.dac.ejb.services.AutenticacaoServiceProfessor;


import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named
@ManagedBean
@SessionScoped
public class LoginUsuarioBean implements Serializable {

    @EJB
    AutenticacaoServiceAluno autenticacaoServiceAluno;

    @EJB
    AutenticacaoServiceProfessor autenticacaoServiceProfessor;


    private String matricula;

    private String senha;

    private String nomeAluno;

    private String nomeProfessor;

    private Aluno alunoLogado;

    private Professor professorLogado;

    public String efetuarLogin(String matricula) {
        if (matricula.length()==12){
            try {
                alunoLogado = autenticacaoServiceAluno.login(matricula, senha);
            } catch (AutenticacaoExcecao e) {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Matrícula ou senha do usuário inválidos!", "Detalhe");
                FacesContext.getCurrentInstance().addMessage("msg", facesMsg);
                return null;
            }
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("matricula",matricula);
            return "/restricted/indexaluno?faces-redirect=true";
        }else {
            try {
                professorLogado = autenticacaoServiceProfessor.login(matricula, senha);
            } catch (AutenticacaoExcecao e) {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matrícula ou senha do usuário inválidos!", "Detalhe");
                FacesContext.getCurrentInstance().addMessage("msg", facesMsg);
                return null;
            }
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("matricula",matricula);
            return "/restricted/indexprofessor?faces-redirect=true";
        }
    }

    public String getNomeALuno(){
       nomeAluno = alunoLogado.getNome();
       return nomeAluno;
    }

    public String getNomeProfessor(){
        nomeProfessor = professorLogado.getNome();
        return nomeProfessor;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Aluno getAlunoLogado() {
        return alunoLogado;
    }



}
