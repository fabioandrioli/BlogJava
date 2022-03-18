package br.com.fabio.blog.dao;

import javax.persistence.EntityManager;

import br.com.fabio.blog.modelo.Cliente;
import br.com.fabio.blog.modelo.Product;

public class ClienteDao {
	private EntityManager entityManager;

	public ClienteDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void create(Cliente cliente) {
		this.entityManager.persist(cliente);
	}
	
	public Cliente buscaPostId(Long id) {
		return this.entityManager.find(Cliente.class, id);
	}
}
