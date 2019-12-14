package br.edu.ifpb.dac.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.edu.ifpb.dac.ejb.entidades.Usuario;
import br.edu.ifpb.dac.ejb.services.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.AutenticacaoService;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	@EJB
	private AutenticacaoService autenticacaoService;
	
	private String login;
	
	private String senha;
	
	private Usuario usuarioLogado;
	
	public String efetuarLogin() {
		try {
			usuarioLogado = autenticacaoService.login(login, senha);
		} catch (AutenticacaoExcecao e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login ou senha inválidos"));
			return "";
		}
		return "home.xhtml";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
}
