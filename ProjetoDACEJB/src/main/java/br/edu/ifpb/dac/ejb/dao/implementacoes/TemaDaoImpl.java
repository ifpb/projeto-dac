package br.edu.ifpb.dac.ejb.dao.implementacoes;

import br.edu.ifpb.dac.ejb.dao.interfaces.TemaDao;
import br.edu.ifpb.dac.ejb.entidades.Tema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class TemaDaoImpl implements TemaDao {
    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    @Override
    public void salvar(Tema t) {
        em.persist(t);
    }

    @Override
    public void atualizar(Tema t){
        em.merge(t);
    }

    @Override
    public Tema buscar(Long id) {
        return em.find(Tema.class, id);
    }

    @Override
    public void remover(Tema t){
        if (!em.contains(t)) {
            t = em.merge(t);
        }
        em.remove(t);
    }

    @Override
    public List<Tema> buscarTodos() {
        return em.createQuery("SELECT t FROM Tema t", Tema.class).getResultList();
    }

  /*  @Override
    public List<Tema> buscarTemasDisponiveis(String curso) {
    	String jpql = "SELECT t FROM Tema t, Professor p WHERE p.curso = :curso AND t.disponivel = 'true'";
        return em.createQuery(jpql, Tema.class).setParameter("curso", curso).getResultList();
    
    }*/   
    /*@Override
    public List<Tema> buscarTemasDisponiveis(String curso) {
    	String jpql = "SELECT t FROM Tema t JOIN Professor p WHERE t.disponivel = 'true' AND p.curso = :curso";
        return em.createQuery(jpql, Tema.class).setParameter("curso", curso).getResultList();
    
    }  */
    @Override
    public List<Tema> buscarTemasDisponiveis(String curso) {
    	String jpql = "SELECT t FROM Tema t JOIN t.professor p WHERE p.curso = :curso AND t.disponivel = 'true'";
        return em.createQuery(jpql, Tema.class).setParameter("curso", curso).getResultList();
    
    }     

    public List<Tema> buscaTemaPorProfessor(Long id) {
        Query query = em.createQuery("SELECT t FROM Tema t WHERE t.professor.id = :id",Tema.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
