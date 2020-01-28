package br.edu.ifpb.dac.ejb.services;

import br.edu.ifpb.dac.ejb.entidades.Aluno;

import javax.ejb.Remove;
import java.util.Optional;

public interface AutenticacaoServiceAluno {

    Aluno login(String matricula, String senha) throws AutenticacaoExcecao;

    @Remove
    void logout() throws AutenticacaoExcecao;

    Optional<Aluno> getAlunoLogado();
}
