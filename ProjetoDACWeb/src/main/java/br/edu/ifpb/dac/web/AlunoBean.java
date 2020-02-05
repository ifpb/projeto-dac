package br.edu.ifpb.dac.web;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.dac.controllers.InscricaoController;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;


@Named
@SessionScoped
public class AlunoBean implements Serializable{
	
	private Inscricao inscricao;
	
    @Inject
    private AlunoController alunoService;
	
    @Inject 
    private LoginUsuarioBean loginService;
    
    
    public void inscrever(){
    	this.inscricao = new Inscricao();
    	this.inscricao.setAluno(loginService.getAlunoLogado());
    	this.inscricao.setDataInscricao(new Date());
        //falta setar os demais atributos de inscricao

    	alunoService.fazerInscricao(this.inscricao);
    }
	
    public Inscricao getInscricao() {
        return aluno;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }	
	
	

}
