package br.edu.ifpb.dac.ejb.dao.implementacoes;

import br.edu.ifpb.dac.ejb.dao.interfaces.CriterioAvaliacaoDao;
import br.edu.ifpb.dac.ejb.entidades.CriterioAvaliacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CriterioAvaliacaoDaoImpl implements CriterioAvaliacaoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(CriterioAvaliacao c) {
        em.persist(c);
    }

    @Override
    public void atualizar(CriterioAvaliacao c){
        em.merge(c);
    }

    @Override
    public void remover(CriterioAvaliacao c){
        em.remove(c);
    }

    @Override
    public CriterioAvaliacao buscar(Long id) {
        return em.find(CriterioAvaliacao.class, id);
    }

    @Override
    public List<CriterioAvaliacao> buscarTodos() {
        return em.createQuery("SELECT c FROM CriterioAvaliacao c", CriterioAvaliacao.class).getResultList();
    }
}
