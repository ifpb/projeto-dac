package br.edu.ifpb.dac.ejb.services;

import java.util.Optional;

import javax.ejb.Local;
import javax.ejb.Remote;

import br.edu.ifpb.dac.ejb.entidades.Usuario;

@Local
@Remote
public interface AutenticacaoService {

	public Usuario login(String login, String senha) throws AutenticacaoExcecao;
	
	public void logout() throws AutenticacaoExcecao;
	
	public Optional<Usuario> getUsuarioLogado();
	
}
