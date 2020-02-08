package br.edu.ifpb.dac.ejb.services.impl;

import br.edu.ifpb.dac.ejb.dao.interfaces.AlunoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.services.Excecao.AutenticacaoExcecao;
import br.edu.ifpb.dac.ejb.services.inteface.AutenticacaoServiceAluno;


import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.Optional;
import java.util.logging.Logger;

@Stateful
public class AutenticacaoServiceAlunoImpl implements AutenticacaoServiceAluno {

    @EJB
    private AlunoDao alunoDao;

    private Aluno alunoLogado;

    private static final Logger log = Logger.getLogger(Logger.class.getName());


    public Aluno login(String matricula, String senha) throws AutenticacaoExcecao {
        log.info("Autenticando usuário "+matricula);
        Aluno aluno = alunoDao.buscarPorMatricula(matricula).orElseThrow( () -> new AutenticacaoExcecao("Login não existe"));
        if (!aluno.getSenha().equals(senha)) {
            throw new AutenticacaoExcecao("Senha inválida");
        }
        alunoLogado = aluno;
        return alunoLogado;
    }

    @Remove
    public void logout() throws AutenticacaoExcecao {
        log.info("Fazendo logout para usuário "+alunoLogado);
        if (alunoLogado == null) {
            throw new AutenticacaoExcecao("Usuário não logado");
        }
    }

    public Optional<Aluno> getAlunoLogado() {
        return Optional.ofNullable(alunoLogado);
    }
}
