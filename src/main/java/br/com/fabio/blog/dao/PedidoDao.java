package br.com.fabio.blog.dao;

import javax.persistence.EntityManager;

import br.com.fabio.blog.modelo.Pedido;
import br.com.fabio.blog.modelo.Product;

public class PedidoDao {
	
	private EntityManager entityManager;

	public PedidoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void create(Pedido pedido) {
		this.entityManager.persist(pedido);
	}
}
