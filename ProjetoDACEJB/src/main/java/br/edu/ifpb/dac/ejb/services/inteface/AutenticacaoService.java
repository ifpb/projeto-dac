package br.edu.ifpb.dac.ejb.services.inteface;

import java.util.Optional;

import javax.ejb.Local;
import javax.ejb.Remote;

import br.edu.ifpb.dac.ejb.entidades.Usuario;
import br.edu.ifpb.dac.ejb.services.Excecao.AutenticacaoExcecao;

@Local
@Remote
public interface AutenticacaoService {

	public Usuario login(String login, String senha) throws AutenticacaoExcecao;
	
	public void logout() throws AutenticacaoExcecao;
	
	public Optional<Usuario> getUsuarioLogado();
	
}
