package br.edu.ifpb.dac.ejb.dao.implementacoes;


import br.edu.ifpb.dac.ejb.dao.interfaces.AvaliacaoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AvaliacaoDaoImpl implements AvaliacaoDao {

    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(Avaliacao a) {
        em.persist(a);
    }

    @Override
    public void remover(Avaliacao a){
        if (!em.contains(a)) {
            a = em.merge(a);
        }
        em.remove(a);
    }

    @Override
    public void atualizar(Avaliacao a){
        em.merge(a);
    }

    @Override
    public Avaliacao buscar(Long id) {
        return em.find(Avaliacao.class, id);
    }

    @Override
    public List<Avaliacao> buscarTodos() {
        return em.createQuery("SELECT a FROM Avaliacao a", Avaliacao.class).getResultList();
    }
}
