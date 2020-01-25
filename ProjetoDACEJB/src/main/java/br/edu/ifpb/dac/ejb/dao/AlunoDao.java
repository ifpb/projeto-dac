package br.edu.ifpb.dac.ejb.dao;

import br.edu.ifpb.dac.ejb.entidades.Aluno;
import br.edu.ifpb.dac.ejb.entidades.Usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class AlunoDao {

    private static final Logger log = Logger.getLogger(Logger.class.getName());

    @PersistenceContext(unitName = "dac")
    EntityManager em;

    public void salvar(Aluno a) {
        em.persist(a);
    }

    public void atualizar(Aluno a) {
        em.merge(a);
    }

    public Aluno buscar(Long id) {
        return em.find(Aluno.class, id);
    }

    public void remover (Aluno a){
        em.remove(a);
    }

    public List<Aluno> buscarTodos() {
        return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
    }






}
