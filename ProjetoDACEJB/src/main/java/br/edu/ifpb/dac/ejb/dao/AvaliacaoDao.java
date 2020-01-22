package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.Professor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AvaliacaoDao {

    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Avaliacao a) {
        em.persist(a);
    }

    public void atualizar(Avaliacao a){
        em.merge(a);
    }

    public Avaliacao buscar(Long id) {
        return em.find(Avaliacao.class, id);
    }

    public List<Avaliacao> buscarTodos() {
        return em.createQuery("SELECT a FROM Avaliacao a", Avaliacao.class).getResultList();
    }
}
