package br.edu.ifpb.dac.ejb.dao;


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
public class ProfessorDao {

    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Professor p) {
        em.persist(p);
    }

    public void atualizar(Professor p) {
        em.merge(p);
    }

    public Professor buscar(Long id) {
        return em.find(Professor.class, id);
    }

    public void remover (Professor p){
        em.remove(p);
    }

    public List<Professor> buscarTodos() {
        return em.createQuery("SELECT p FROM Professor p", Professor.class).getResultList();
    }

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
