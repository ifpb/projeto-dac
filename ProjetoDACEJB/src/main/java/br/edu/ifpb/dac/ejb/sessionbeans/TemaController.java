package br.edu.ifpb.dac.ejb.sessionbeans;


import br.edu.ifpb.dac.ejb.dao.TemaDao;
import br.edu.ifpb.dac.ejb.entidades.Tema;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class TemaController implements Serializable {

    private Tema tema;

    @Inject
    private TemaDao temaDao;

    public List<Tema> buscarTodosOsTemas(){
        return temaDao.buscarTodos();
    }

    public String salvar(Tema tema){
        temaDao.salvar(tema);
        return null;
    }

    /*
    public String remover(Tema tema){
        this.temaDao.remover(tema);
        return null;
    }
     */

    public String atualizar(Tema tema){
        this.temaDao.atualizar(tema);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarTema(Long id){
        this.temaDao.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
