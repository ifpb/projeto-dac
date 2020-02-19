package br.edu.ifpb.dac.ejb.dao.implementacoes;

import br.edu.ifpb.dac.ejb.dao.interfaces.PeriodoDao;
import br.edu.ifpb.dac.ejb.entidades.Periodo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PeriodoDaoImpl implements PeriodoDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(Periodo p) {
        em.persist(p);
    }

    @Override
    public void atualizar(Periodo p){
        em.merge(p);
    }

    @Override
    public Periodo buscar(Long id) {
        return em.find(Periodo.class, id);
    }

    @Override
    public void remover(Periodo p){
        if (!em.contains(p)) {
            p = em.merge(p);
        }
        em.remove(p);
    }

    @Override
    public List<Periodo> buscarTodos() {
        return em.createQuery("SELECT p FROM Periodo p", Periodo.class).getResultList();
    }

    @Override
    public Periodo buscarPorData(Date d){


        return em.createQuery(
                "SELECT p FROM Periodo p WHERE :data BETWEEN p.dataInicio AND p.dataFim", Periodo.class).
                setParameter("data", d, TemporalType.DATE).getSingleResult();
    }
}
