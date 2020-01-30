package br.edu.ifpb.dac.ejb.sessionbeans;

import br.edu.ifpb.dac.ejb.dao.AlunoDao;
import br.edu.ifpb.dac.ejb.dao.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Pessoa;
import br.edu.ifpb.dac.ejb.entidades.Professor;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class CadastroController {

    private Aluno aluno = new Aluno();
    private Professor professor = new Professor();


    @Inject
    AlunoDao alunoDao;

    @Inject
    ProfessorDao professorDao;


    public String CadastrarUsuario(){
        alunoDao.salvar(aluno);
        return "login.xhmtl";
    }
    public String CadastrarProfessor(){
        professorDao.salvar(professor);
        return "login.xhmtl";
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}
