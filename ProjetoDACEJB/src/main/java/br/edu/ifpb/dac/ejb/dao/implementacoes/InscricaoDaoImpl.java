package br.edu.ifpb.dac.ejb.dao.implementacoes;

import br.edu.ifpb.dac.ejb.dao.interfaces.InscricaoDao;
import br.edu.ifpb.dac.ejb.entidades.Avaliacao;
import br.edu.ifpb.dac.ejb.entidades.Inscricao;
import br.edu.ifpb.dac.ejb.entidades.Tema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        if (!em.contains(i)) {
            i = em.merge(i);
        }
        em.remove(i);
    }

    @Override
    public List<Inscricao> buscarTodos() {
        return em.createQuery("SELECT i FROM Inscricao i", Inscricao.class).getResultList();
    }

    @Override
    public List<Avaliacao> listarAvaliacao(Inscricao i) {
//        return em.createQuery("SELECT i. FROM Inscricao i")
        return null;
    }

    @Override
    public List<Inscricao> listarInscritosProfessor(Long id) {
        Query query = em.createQuery("SELECT i FROM Inscricao i WHERE i.professor.id = :id", Inscricao.class);
        query.setParameter("id",id);
        return query.getResultList();
    }

}
