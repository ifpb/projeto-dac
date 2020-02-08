package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoDao {
    void salvar(Aluno a);

    void atualizar(Aluno a);

    Aluno buscar(Long id);

    void remover(Aluno a);

    List<Aluno> buscarTodos();

    Optional<Aluno> buscarPorMatricula(String matricula);
}
