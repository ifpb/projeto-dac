package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Tema;

import java.util.List;

public interface TemaDao {
    void salvar(Tema t);

    void atualizar(Tema t);

    Tema buscar(Long id);

    void remover(Tema t);

    List<Tema> buscarTodos();

    List<Tema> buscarTemasDisponiveis();

    List<Tema> buscaTemaPorProfessor(Long id);

}
