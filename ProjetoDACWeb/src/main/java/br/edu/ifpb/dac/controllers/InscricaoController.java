package br.edu.ifpb.dac.controllers;



import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Tema;
import br.edu.ifpb.dac.ejb.services.impl.InscricaoService;
import br.edu.ifpb.dac.ejb.services.impl.PeriodoService;
import br.edu.ifpb.dac.ejb.util.MailUtil;
import br.edu.ifpb.dac.web.LoginUsuarioBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@RequestScoped
@Named
public class InscricaoController implements Serializable {

    private Inscricao inscricao;

    private Tema tema;

    private Aluno alunoLogado;

    @Inject
    private LoginUsuarioBean usuario;

    @Inject
    private PeriodoService periodoService;

    @Inject
    private InscricaoService inscricaoService;

    public List<Inscricao> buscarTodosAsInscricoes(){
        return inscricaoService.buscarTodos();
    }

    public String salvar(Tema tema){
        this.inscricao = new Inscricao();
//        try{
            inscricao.setTema(tema);
            inscricao.setProfessor(tema.getProfessor());
            inscricao.setAluno(usuario.getAlunoLogado());
            inscricao.setDataInscricao(new Date());
            inscricao.setPeriodo(periodoService.buscarPorData(new Date()));
            inscricaoService.salvar(inscricao);
            MailUtil.enviarEmail(inscricao.getProfessor().getEmail(),inscricao.getProfessor().getNome(),
                    inscricao.getAluno().getNome(), tema.getTitulo());
            return "/restricted/indexaluno?faces-redirect=true";
//        }catch (Exception e){
//            FacesMessage facesMessage = new FacesMessage(
//                    FacesMessage.SEVERITY_ERROR,
//                    "Período de inscrições encerradas!",
//                    "Detalhe");
//            FacesContext.getCurrentInstance().addMessage("msg", facesMessage);
//            return null;
//        }
    }

    public String atualizar(Inscricao inscricao){
        this.inscricaoService.atualizar(inscricao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarInscricao(Long id){
        this.inscricaoService.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

}
