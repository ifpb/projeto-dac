package br.edu.ifpb.dac.ejb.dao.interfaces;

import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;

import java.util.List;

public interface InscricaoDao {
    void salvar(Inscricao i);

    void atualizar(Inscricao i);

    Inscricao buscar(Long id);

    void remover(Inscricao i);

    List<Inscricao> buscarTodos();

    List<Avaliacao> listarAvaliacao(Inscricao i);

    List<Inscricao> listarInscritosProfessor(Long id);


}
