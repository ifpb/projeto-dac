package br.edu.ifpb.dac.ejb.sessionbeans;

import br.edu.ifpb.dac.ejb.dao.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@RequestScoped
@Named
public class ProfessorController implements Serializable {

    private Professor professor;

    @Inject
    private ProfessorDao professorDao;

    public List<Professor> buscarTodosOsProfessores(){
        return professorDao.buscarTodos();
    }

    public String salvar(Professor professor){
        professorDao.salvar(professor);
        return null;
    }

    /*                                              Criar esse método no DAO de professor
    public String remover(Professor professor){
        this.professorDAO.remover(professor);
        return null;
    }
     */

    public String atualizar(Professor professor){
        this.professorDao.atualizar(professor);
        return "??????"; // Definir para onde será redirecionado
    }
    public String buscarProfessor(Long id){
        this.professorDao.buscar(id);
        return "?????w"; // Definir para onde será redirecionado
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
