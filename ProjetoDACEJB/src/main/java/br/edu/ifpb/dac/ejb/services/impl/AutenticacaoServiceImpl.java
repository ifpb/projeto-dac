package br.edu.ifpb.dac.ejb.services.impl;

import java.util.Optional;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import br.edu.ifpb.dac.ejb.dao.implementacoes.UsuarioDAOImpl;
import br.edu.ifpb.dac.ejb.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.dac.ejb.entidades.Usuario;
import br.edu.ifpb.dac.ejb.services.Excecao.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.inteface.AutenticacaoService;

@Stateful
public class AutenticacaoServiceImpl implements AutenticacaoService {
	
	@EJB
	private UsuarioDAO usuarioDAO;

	private Usuario usuarioLogado;
	
	private static final Logger log = Logger.getLogger(Logger.class.getName());
	
	public Usuario login(String login, String senha) throws AutenticacaoExcecao {
		log.info("Autenticando usuário "+login);
		Usuario usuario = usuarioDAO.buscarPorMatricula(login).orElseThrow( () -> new AutenticacaoExcecao("Login não existe"));
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
