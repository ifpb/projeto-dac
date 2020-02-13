package br.edu.ifpb.dac.controllers;


import br.edu.ifpb.dac.ejb.dao.interfaces.TemaDao;
import br.edu.ifpb.dac.ejb.entidades.Tema;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
@Named
public class TemaController implements Serializable {

    private Tema tema = new Tema();

    private List<Tema> temas = new ArrayList<>();

    @Inject
    private TemaDao temaDao;

    @PostConstruct
    public void init(){
        carregarTemas();
    }

    public void carregarTemas(){
        this.temas = temaDao.buscarTodos();
    }

    public void salvar(){
        this.temaDao.salvar(tema);
        carregarTemas();
    }

    
    public void remover(Tema tema){ this.temaDao.remover(tema);
        carregarTemas();
    }

    public void atualizar(Tema tema){
        this.temaDao.atualizar(tema);
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

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
}
