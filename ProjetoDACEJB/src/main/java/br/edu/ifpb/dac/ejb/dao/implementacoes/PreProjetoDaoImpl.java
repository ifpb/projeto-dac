package br.edu.ifpb.dac.ejb.dao.implementacoes;


import br.edu.ifpb.dac.ejb.dao.interfaces.PreProjetoDao;
import br.edu.ifpb.dac.ejb.entidades.PreProjeto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PreProjetoDaoImpl implements PreProjetoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(PreProjeto p) {
        em.persist(p);
    }

    @Override
    public void atualizar(PreProjeto p){
        em.merge(p);
    }

    @Override
    public PreProjeto buscar(Long id) {
        return em.find(PreProjeto.class, id);
    }

    @Override
    public void remover(PreProjeto p){
        if (!em.contains(p)) {
            p = em.merge(p);
        }
        em.remove(p);
    }

    @Override
    public List<PreProjeto> buscarTodos() {
        return em.createQuery("SELECT p FROM PreProjeto p", PreProjeto.class).getResultList();
    }


}
