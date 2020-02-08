package br.edu.ifpb.dac.ejb.dao.implementacoes;

import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class InscricaoDaoImpl implements InscricaoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(Inscricao i) {
        em.persist(i);
    }

    @Override
    public void atualizar(Inscricao i){
        em.merge(i);
    }

    @Override
    public Inscricao buscar(Long id) {
        return em.find(Inscricao.class, id);
    }

    @Override
    public void remover(Inscricao i){
        em.remove(i);
    }

    @Override
    public List<Inscricao> buscarTodos() {
        return em.createQuery("SELECT i FROM Inscricao i", Inscricao.class).getResultList();
    }

}
