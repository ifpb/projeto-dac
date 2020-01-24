package br.edu.ifpb.dac.ejb.sessionbeans;


import br.edu.ifpb.dac.ejb.dao.UsuarioDAO;
import br.edu.ifpb.dac.ejb.entidades.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class UsuarioController implements Serializable {

    private Usuario usuario;

    @Inject
    private UsuarioDAO usuarioDAO;

    public List<Usuario> buscarTodosOsUsuarios(){
        return usuarioDAO.buscarTodos();
    }

    public String salvar(){
        usuarioDAO.salvar(usuario);
        return null;
    }

    /*                                              Criar esse método no DAO de aluno
    public String remover(Usuario usuario){
        this.usuarioDAO.remover(usuario);
        return null;
    }
     */

    public String atualizar(Usuario usuario){
        this.usuarioDAO.atualizar(usuario);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarUsuario(Long id){
        this.usuarioDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
