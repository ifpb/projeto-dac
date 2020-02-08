package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Periodo;

import java.util.List;

public interface PeriodoDao {
    void salvar(Periodo p);

    void atualizar(Periodo p);

    Periodo buscar(Long id);

    void remover(Periodo p);

    List<Periodo> buscarTodos();
}
