package br.edu.ifpb.dac.ejb.dao;


import br.edu.ifpb.dac.ejb.entidades.PreProjeto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PreProjetoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(PreProjeto p) {
        em.persist(p);
    }

    public void atualizar(PreProjeto p){
        em.merge(p);
    }

    public PreProjeto buscar(Long id) {
        return em.find(PreProjeto.class, id);
    }

    public void remover (PreProjeto p){
        em.remove(p);
    }

    public List<PreProjeto> buscarTodos() {
        return em.createQuery("SELECT p FROM PreProjeto p", PreProjeto.class).getResultList();
    }


}
