package br.edu.ifpb.dac.ejb.sessionbeans;

import br.edu.ifpb.dac.ejb.dao.AlunoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class AlunoController implements Serializable {

    private Aluno aluno;

    @Inject
    private AlunoDao alunoDAO;

    public List<Aluno> buscarTodosOsAlunos(){
        return alunoDAO.buscarTodos();
    }

    public String salvar(){
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
}
