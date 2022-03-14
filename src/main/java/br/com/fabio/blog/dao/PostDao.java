package br.com.fabio.blog.dao;

import javax.persistence.EntityManager;

import br.com.fabio.blog.modelo.Post;

public class PostDao {
	private EntityManager entityManager;
	
	public PostDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void create(Post post) {
		this.entityManager.persist(post);
	}
}
