package br.edu.ifpb.dac.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.ifpb.dac.ejb.entidades.Usuario;

@Stateless
public class UsuarioDAO {
	
	@PersistenceContext(unitName = "dac")
	EntityManager em;

	public void salvar(Usuario u) {
		em.persist(u);
	}

	public void atualizar(Usuario p) {
		em.merge(p);
	}

	public Usuario buscar(Long id) {
		return em.find(Usuario.class, id);
	}

	public List<Usuario> buscarTodos() {
		return em.createQuery("SELECT u FROM Usuario u ORDER BY u.id", Usuario.class).getResultList();
	}

}
