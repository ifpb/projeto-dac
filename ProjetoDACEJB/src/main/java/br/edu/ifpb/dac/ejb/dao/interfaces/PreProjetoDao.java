package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.PreProjeto;

import java.util.List;

public interface PreProjetoDao {
    void salvar(PreProjeto p);

    void atualizar(PreProjeto p);

    PreProjeto buscar(Long id);

    void remover(PreProjeto p);

    List<PreProjeto> buscarTodos();
}
