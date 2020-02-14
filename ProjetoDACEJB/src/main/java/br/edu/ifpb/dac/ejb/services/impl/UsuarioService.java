package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class UsuarioService{

    @Inject
    private UsuarioDAO usuarioDAO;

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.salvar(usuario);
    }

    public void atualizarUsuario(Usuario usuario){
        usuarioDAO.atualizar(usuario);
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioDAO.buscar(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.buscarTodos();
    }

    public Optional<Usuario> buscarPorMatricula (String matricula){
        return usuarioDAO.buscarPorMatricula(matricula);
    }


}
