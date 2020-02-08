package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorDao {
    void salvar(Professor p);

    void atualizar(Professor p);

    Professor buscar(Long id);

    void remover(Professor p);

    List<Professor> buscarTodos();

    Optional<Professor> buscarPorMatricula(String matricula);
}
