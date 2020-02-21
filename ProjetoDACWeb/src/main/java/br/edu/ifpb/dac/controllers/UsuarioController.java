package br.edu.ifpb.dac.controllers;


import br.edu.ifpb.dac.ejb.dao.interfaces.UsuarioDAO;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Usuario;
import br.edu.ifpb.dac.ejb.services.impl.UsuarioService;
import br.edu.ifpb.dac.web.LoginUsuarioBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@RequestScoped
@Named
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();

    @Inject
    private UsuarioService usuarioService;

    public List<Usuario> buscarTodosOsUsuarios(){
        return usuarioService.listarUsuarios();
    }

    public String buscarUsuario(Long id){
        this.usuarioService.buscarUsuario(id);
        return null;
    }

    public Optional<Usuario> buscarUsuarioPorMatricula(String matricula){
        return this.usuarioService.buscarPorMatricula(matricula);
    }

    public String goToIndex(){
        return "/restricted/indexadmin?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
