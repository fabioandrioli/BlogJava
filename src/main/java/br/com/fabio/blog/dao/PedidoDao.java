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
	
	public int valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return entityManager.createQuery(jpql, int.class).getSingleResult();
	}
}
