package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.services.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.AutenticacaoServiceProfessor;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginProfessorBean implements Serializable {

    @EJB
    AutenticacaoServiceProfessor autenticacaoServiceProfessor;

    private String matricula;

    private String senha;

    private Professor professorlogado;

    public String efetuarLogin() {
        try {
            professorlogado = autenticacaoServiceProfessor.login(matricula, senha);
        } catch (AutenticacaoExcecao e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matricula ou senha inválidos"));
            return "";
        }
        return "home.xhtml";
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

    public Professor getProfessorlogado() {
        return professorlogado;
    }

}
