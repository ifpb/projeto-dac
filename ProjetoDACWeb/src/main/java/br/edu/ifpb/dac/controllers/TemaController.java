package br.edu.ifpb.dac.controllers;


import br.edu.ifpb.dac.ejb.dao.interfaces.TemaDao;
import br.edu.ifpb.dac.ejb.entidades.Tema;
import br.edu.ifpb.dac.web.AcaoMB;
import br.edu.ifpb.dac.web.LoginUsuarioBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SessionScoped
@Named
public class TemaController implements Serializable {

    private Tema tema;

    private List<Tema> temas = new ArrayList<>();

    @EJB
    private TemaDao temaDao;
    
    @Inject
    private AcaoMB acao;
    
    @Inject
    private LoginUsuarioBean loginService;    

    @PostConstruct
    public void init(){
        carregarTemas();
        tema = new Tema();
    }
    
    public String editarTema(Tema tema){
    	this.tema = tema;
    	this.acao.setAcao("EDITAR");
    	return "null";
    }
    
    public String confirmarEdicao(){
    	this.tema.setDisponivel(true);
    	this.temaDao.atualizar(this.tema);
    	this.tema = new Tema();
    	this.acao.setAcao("CADASTRO");
    	return "null";
    }
    public String cancelarEdicao(){
    	this.tema= new Tema();
    	this.acao.setAcao("CADASTRO");
    	return "null";
    }

    public void carregarTemas(){
        this.temas = temaDao.buscarTodos();
    }
    
    public String cadastrarTema() {
    	this.tema.setProfessor(loginService.getProfessorLogado());
    	this.tema.setDisponivel(true);
    	this.temaDao.salvar(this.tema);
    	this.tema=new Tema();
    	carregarTemas();
    	return "null";
    }    

    
    public void remover(Tema tema){ 
    	this.temaDao.atualizar(tema);
    	this.temaDao.remover(tema);
        carregarTemas();
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
