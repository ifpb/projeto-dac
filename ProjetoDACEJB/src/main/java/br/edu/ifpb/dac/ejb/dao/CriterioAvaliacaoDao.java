package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.CriterioAvaliacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CriterioAvaliacaoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(CriterioAvaliacao c) {
        em.persist(c);
    }

    public void atualizar(CriterioAvaliacao c){
        em.merge(c);
    }

    public CriterioAvaliacao buscar(Long id) {
        return em.find(CriterioAvaliacao.class, id);
    }

    public List<CriterioAvaliacao> buscarTodos() {
        return em.createQuery("SELECT c FROM CriterioAvaliacao c", CriterioAvaliacao.class).getResultList();
    }
}
