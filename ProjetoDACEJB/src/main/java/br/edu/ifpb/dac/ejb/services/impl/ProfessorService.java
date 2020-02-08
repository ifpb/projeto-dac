package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProfessorService {

    @Inject
    private ProfessorDao professorDao;

    public void cadastrarProfessor(Professor professor) {
        professorDao.salvar(professor);
    }

    public void atualizarProfessor(Professor professor){
        professorDao.atualizar(professor);
    }

    public Professor buscarProfessor(Long id) {
        return professorDao.buscar(id);
    }

    public void removerProfessor(Professor professor) {
        professorDao.remover(professor);
    }

    public List<Professor> listarProfessores() {
        return professorDao.buscarTodos();
    }

    public Optional<Professor> buscarPorMatricula (String matricula){
        return professorDao.buscarPorMatricula(matricula);
    }

}
