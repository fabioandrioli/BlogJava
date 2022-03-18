package br.com.fabio.blog.dao;

import javax.persistence.EntityManager;

import br.com.fabio.blog.modelo.Categoria;
import br.com.fabio.blog.modelo.Product;

public class CategoriaDao {
private EntityManager entityManager;
	
	public CategoriaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void create(Categoria categoria) {
		this.entityManager.persist(categoria);
	}
}
