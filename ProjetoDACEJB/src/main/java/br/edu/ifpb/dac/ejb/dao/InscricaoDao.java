package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.Inscricao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class InscricaoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Inscricao i) {
        em.persist(i);
    }

    public void atualizar(Inscricao i){
        em.merge(i);
    }

    public Inscricao buscar(Long id) {
        return em.find(Inscricao.class, id);
    }

    public List<Inscricao> buscarTodos() {
        return em.createQuery("SELECT i FROM Inscricao i", Inscricao.class).getResultList();
    }

}
