package br.edu.ifpb.dac.controllers;

import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.services.impl.AlunoService;
import br.edu.ifpb.dac.ejb.services.impl.InscricaoService;
import br.edu.ifpb.dac.web.LoginUsuarioBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RequestScoped
@Named
public class AlunoController implements Serializable {

    private Aluno aluno = new Aluno();

	private Inscricao inscricao;  
	
	@Inject
	private TemaController temaService;
    
    @Inject
    private InscricaoService inscricaoService;

    @Inject
    private AlunoService alunoService;

    @Inject
    private LoginUsuarioBean loginService;

    public String CadastrarAluno(){
        try {
            alunoService.cadastrarAluno(aluno);
            return "/login?faces-redirect=true";
        }catch (Exception e){
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário existente", "Detalhe");
            FacesContext.getCurrentInstance().addMessage("msg", facesMsg);
            return null;
        }
    }

    public List<Aluno> buscarTodosOsAlunos(){
        return alunoService.listarAlunos();
    }

    public String remover(Aluno aluno){
        this.alunoService.removerAluno(aluno);
        return null;
    }

    public String atualizar(Aluno aluno){
        this.alunoService.atualizarAluno(aluno);
        return "/login?faces-redirect=true";
    }

    public String buscarAluno(Long id){
        this.alunoService.buscarAluno(id);
        return null;
    }

    public Optional<Aluno> buscarAlunoPorMatricula(String matricula){
        return this.alunoService.buscarPorMatricula(matricula);
    }

    public void inscrever(){
        this.inscricao = new Inscricao();
        this.inscricao.setAluno(loginService.getAlunoLogado());
        this.inscricao.setDataInscricao(new Date());


        inscricaoService.salvar(this.inscricao);
    }

    public String goToTemasAlunos(){
    	String curso = this.loginService.getAlunoLogado().getCurso();
    	this.temaService.buscarTemasDisponiveis(curso);
        return "/restricted/temasalunos.xhtml?faces-redirect=true";
    }

    public String goToEditarPerfil(){
        return "/restricted/editarPerfilAluno.xhtml?faces-redirect=true";
    }

    public String goToIndex(){
        return "/restricted/indexaluno?faces-redirect=true";
    }


//getters e setters


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

    public LoginUsuarioBean getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginUsuarioBean loginService) {
        this.loginService = loginService;
    }
}
