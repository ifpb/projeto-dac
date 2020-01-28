package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.services.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.AutenticacaoServiceAluno;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginAlunoBean implements Serializable {

    @EJB
    AutenticacaoServiceAluno autenticacaoServiceAluno;

    private String matricula;

    private String senha;

    private Aluno alunoLogado;

    public String efetuarLogin() {
        try {
            alunoLogado = autenticacaoServiceAluno.login(matricula, senha);
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

    public Aluno getAlunoLogado() {
        return alunoLogado;
    }


}
