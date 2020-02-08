package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Professor;
import br.edu.ifpb.dac.ejb.services.Excecao.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.inteface.AutenticacaoServiceProfessor;

import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.Optional;
import java.util.logging.Logger;

@Stateful
public class AutenticacaoServiceProfessorImpl implements AutenticacaoServiceProfessor {

    @EJB
    private ProfessorDao professorDao;

    private Professor professorLogado;

    private static final Logger log = Logger.getLogger(Logger.class.getName());


    public Professor login(String matricula, String senha) throws AutenticacaoExcecao {
        log.info("Autenticando usuário "+matricula);
        Professor professor = professorDao.buscarPorMatricula(matricula).orElseThrow( () -> new AutenticacaoExcecao("Login não existe"));
        if (!professor.getSenha().equals(senha)) {
            throw new AutenticacaoExcecao("Senha inválida");
        }
        professorLogado = professor;
        return professorLogado;
    }


    @Remove
    public void logout() throws AutenticacaoExcecao {
        log.info("Fazendo logout para usuário "+professorLogado);
        if (professorLogado == null) {
            throw new AutenticacaoExcecao("Usuário não logado");
        }
    }

    public Optional<Professor> getProfessorLogado() {
        return Optional.ofNullable(professorLogado);
    }

}
