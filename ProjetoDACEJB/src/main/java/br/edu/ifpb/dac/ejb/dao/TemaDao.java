package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.PreProjeto;
import br.edu.ifpb.dac.ejb.entidades.Tema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class TemaDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Tema t) {
        em.persist(t);
    }

    public void atualizar(Tema t){
        em.merge(t);
    }

    public Tema buscar(Long id) {
        return em.find(Tema.class, id);
    }

    public void remover (Tema t){
        em.remove(t);
    }

    public List<Tema> buscarTodos() {
        return em.createQuery("SELECT t FROM Tema t", Tema.class).getResultList();
    }
}
