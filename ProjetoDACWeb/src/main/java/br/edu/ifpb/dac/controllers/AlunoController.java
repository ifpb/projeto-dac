package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.dao.AlunoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.web.LoginUsuarioBean;
import br.edu.ifpb.dac.controllers.InscricaoController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@RequestScoped
@Named
public class AlunoController implements Serializable {

    private Aluno aluno;
	private Inscricao inscricao;    
    
    @Inject
    private InscricaoController inscricaoService;

    @Inject
    private AlunoDao alunoDAO;
    
    
    
    @Inject 
    private LoginUsuarioBean loginService;
    
    
    public void inscrever(){
    	this.inscricao = new Inscricao();
    	this.inscricao.setAluno(loginService.getAlunoLogado());
    	this.inscricao.setDataInscricao(new Date());
        //falta setar os demais atributos de inscricao

    	inscricaoService.salvar(this.inscricao);
    }    
 
    
    public void fazerInscricao(Inscricao inscricao){
    	inscricaoService.salvar(inscricao);
    }

    public List<Aluno> buscarTodosOsAlunos(){
        return alunoDAO.buscarTodos();
    }

    public String salvar(Aluno aluno){
        alunoDAO.salvar(aluno);
        return null;
    }

    /*                                              Criar esse método no DAO de aluno
    public String remover(Aluno aluno){
        this.alunoDAO.remover(aluno);
        return null;
    }
     */

    public String atualizar(Aluno aluno){
        this.alunoDAO.atualizar(aluno);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarAluno(Long id){
        this.alunoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


	public Inscricao getInscricao() {
		return inscricao;
	}


	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
    
    
}
