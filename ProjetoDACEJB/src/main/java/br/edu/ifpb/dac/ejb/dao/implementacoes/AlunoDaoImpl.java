package br.edu.ifpb.dac.ejb.dao.implementacoes;

import br.edu.ifpb.dac.ejb.dao.interfaces.AlunoDao;
import br.edu.ifpb.dac.ejb.entidades.Aluno;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class AlunoDaoImpl implements AlunoDao {

    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(Aluno a) {
        em.persist(a);
    }

    @Override
    public void atualizar(Aluno a) {
        em.merge(a);
    }

    @Override
    public Aluno buscar(Long id) {
        return em.find(Aluno.class, id);
    }

    @Override
    public void remover(Aluno a){
        em.remove(a);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
    }

    @Override
    public Optional<Aluno> buscarPorMatricula(String matricula) {
        Optional<Aluno> aluno = Optional.empty();
        try {
            aluno = Optional.ofNullable((Aluno) em.createQuery("SELECT a FROM Aluno a WHERE a.matricula = :matricula").
                    setParameter("matricula", matricula).setMaxResults(1).getSingleResult());
        } catch(NoResultException e) {
            log.log(Level.WARNING, "Nenhum resultado encontrado para este login");
        }
        return aluno;
    }




}
