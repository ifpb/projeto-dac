package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.CriterioAvaliacao;

import java.util.List;

public interface CriterioAvaliacaoDao {
    void salvar(CriterioAvaliacao c);

    void atualizar(CriterioAvaliacao c);

    void remover(CriterioAvaliacao c);

    CriterioAvaliacao buscar(Long id);

    List<CriterioAvaliacao> buscarTodos();
}
