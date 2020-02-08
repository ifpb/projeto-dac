package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Avaliacao;

import java.util.List;

public interface AvaliacaoDao {
    void salvar(Avaliacao a);

    void remover(Avaliacao a);

    void atualizar(Avaliacao a);

    Avaliacao buscar(Long id);

    List<Avaliacao> buscarTodos();
}
