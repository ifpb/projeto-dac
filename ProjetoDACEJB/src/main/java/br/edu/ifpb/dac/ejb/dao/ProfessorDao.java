package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
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
}
