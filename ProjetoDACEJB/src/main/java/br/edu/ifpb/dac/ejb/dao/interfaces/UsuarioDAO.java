package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDAO {
    void salvar(Usuario u);

    void atualizar(Usuario p);

    Usuario buscar(Long id);

    Optional<Usuario> buscarPorLogin(String login);

    List<Usuario> buscarTodos();
}
