package br.edu.ifpb.dac.ejb.services;

import java.util.Optional;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

import br.edu.ifpb.dac.ejb.dao.UsuarioDAO;
import br.edu.ifpb.dac.ejb.entidades.Usuario;

@Stateful
public class AutenticacaoServiceImpl implements AutenticacaoService {
	
	@EJB
	private UsuarioDAO usuarioDAO;

	private Usuario usuarioLogado;
	
	private static final Logger log = Logger.getLogger(Logger.class.getName());
	
	public Usuario login(String login, String senha) throws AutenticacaoExcecao {
		log.info("Autenticando usuário "+login);
		Usuario usuario = usuarioDAO.buscarPorLogin(login).orElseThrow( () -> new AutenticacaoExcecao("Login não existe"));
		if (!usuario.getSenha().equals(senha)) {
			throw new AutenticacaoExcecao("Senha inválida");
		}
		usuarioLogado = usuario;
		return usuarioLogado;
	}
	
	@Remove
	public void logout() throws AutenticacaoExcecao {
		log.info("Fazendo logout para usuário "+usuarioLogado);
		if (usuarioLogado == null) {
			throw new AutenticacaoExcecao("Usuário não logado");
		}
	}
	
	public Optional<Usuario> getUsuarioLogado() {
		return Optional.ofNullable(usuarioLogado);
	}
	
}
