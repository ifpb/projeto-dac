package br.edu.ifpb.dac.web;

import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.entidades.Usuario;
import br.edu.ifpb.dac.ejb.services.Excecao.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.inteface.AutenticacaoService;
import br.edu.ifpb.dac.ejb.services.inteface.AutenticacaoServiceAluno;
import br.edu.ifpb.dac.ejb.services.inteface.AutenticacaoServiceProfessor;


import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    @EJB
    AutenticacaoService autenticacaoServiceAdmin;

    private String matricula;

    private String senha;

    private String nomeAluno;

    private String nomeProfessor;

    private String nomeAdmin;

    private Aluno alunoLogado;

    private Professor professorLogado;

    private Usuario adminLogado;

    public String efetuarLogin(String matricula) {
            try {
               if (matricula.length()==12){
                   alunoLogado = autenticacaoServiceAluno.login(matricula, senha);
                   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                   session.setAttribute("matricula",matricula);
                   return "/restricted/indexaluno?faces-redirect=true";
               } else if (matricula.length()==8){
                   professorLogado = autenticacaoServiceProfessor.login(matricula, senha);
                   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                   session.setAttribute("matricula",matricula);
                   return "/restricted/indexprofessor?faces-redirect=true";
               }else {
                   adminLogado = autenticacaoServiceAdmin.login(matricula,senha);
                   HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                   session.setAttribute("matricula",matricula);
                   return "/restricted/indexadmin?faces-redirect=true";
               }
            } catch (AutenticacaoExcecao e) {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matrícula ou senha do usuário inválidos!", "Detalhe");
                FacesContext.getCurrentInstance().addMessage("msg", facesMsg);
                return null;
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

    public String getNomeAdmin(){
        nomeAdmin = adminLogado.getNome();
        return nomeAdmin;
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

	public Professor getProfessorLogado() {
		return professorLogado;
	}

	public Usuario getAdminLogado(){
        return adminLogado;
    }

}
