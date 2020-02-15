package br.edu.ifpb.dac.ejb.dao.implementacoes;


import br.edu.ifpb.dac.ejb.dao.interfaces.ProfessorDao;
import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ProfessorDaoImpl implements ProfessorDao {

    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(Professor p) {
        em.persist(p);
    }

    @Override
    public void atualizar(Professor p) {
        em.merge(p);
    }

    @Override
    public Professor buscar(Long id) {
        return em.find(Professor.class, id);
    }

    @Override
    public void remover(Professor p){
        if (!em.contains(p)) {
            p = em.merge(p);
        }
        em.remove(p);
    }

    @Override
    public List<Professor> buscarTodos() {
        return em.createQuery("SELECT p FROM Professor p", Professor.class).getResultList();
    }

    @Override
    public Optional<Professor> buscarPorMatricula(String matricula) {
        Optional<Professor> professor = Optional.empty();
        try {
            professor = Optional.ofNullable((Professor) em.createQuery("SELECT p FROM Professor p WHERE p.matricula = :matricula").setParameter("matricula", matricula).setMaxResults(1).getSingleResult());
        } catch(NoResultException e) {
            log.log(Level.WARNING, "Nenhum resultado encontrado para este login");
        }
        return professor;
    }
}
