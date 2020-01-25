package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PeriodoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Periodo p) {
        em.persist(p);
    }

    public void atualizar(Periodo p){
        em.merge(p);
    }

    public Periodo buscar(Long id) {
        return em.find(Periodo.class, id);
    }

    public void remover (Periodo p){
        em.remove(p);
    }

    public List<Periodo> buscarTodos() {
        return em.createQuery("SELECT p FROM Periodo p", Periodo.class).getResultList();
    }
}
