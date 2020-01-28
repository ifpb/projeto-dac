package br.edu.ifpb.dac.ejb.services;

import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.ejb.Remove;
import java.util.Optional;

public interface AutenticacaoServiceProfessor {

    Professor login(String matricula, String senha) throws AutenticacaoExcecao;

    @Remove
    void logout() throws AutenticacaoExcecao;

    Optional<Professor> getProfessorLogado();
}
