package br.edu.ifpb.dac.ejb.sessionbeans;



import br.edu.ifpb.dac.ejb.dao.InscricaoDao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
@Named
public class InscricaoController implements Serializable {

    @Inject
    private InscricaoDao inscricaoDAO;
    private Inscricao inscricao;
    private List<Inscricao> inscricoes;

    @PostConstruct
    public void init(){
        inscricoes = new ArrayList<>();
    }

    public List<Inscricao> buscarTodosAsInscricoes(){
        return inscricoes = inscricaoDAO.buscarTodos();
    }

    public String salvar(Inscricao inscricao){
        inscricaoDAO.salvar(inscricao);
        return null;
    }

    public String atualizar(Inscricao inscricao){
        this.inscricaoDAO.atualizar(inscricao);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarInscricao(Long id){
        this.inscricaoDAO.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}
