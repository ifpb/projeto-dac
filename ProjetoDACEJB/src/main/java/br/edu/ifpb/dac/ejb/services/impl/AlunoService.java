package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.AlunoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;



import javax.ejb.Stateless;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@Stateless
public class AlunoService {

    @Inject
    private AlunoDao alunoDao;

    public void cadastrarAluno(Aluno aluno) {
            alunoDao.salvar(aluno);
    }

    public void atualizarAluno(Aluno aluno){
        alunoDao.atualizar(aluno);
    }

    public Aluno buscarAluno(Long id) {
        return alunoDao.buscar(id);
    }

    public void removerAluno(Aluno aluno) {
        alunoDao.remover(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoDao.buscarTodos();
    }

    public Optional<Aluno> buscarPorMatricula (String matricula){
        return alunoDao.buscarPorMatricula(matricula);
    }






}
