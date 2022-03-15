package br.com.fabio.blog.dao;

import java.util.List;

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
	
	public Post buscaPostId(Long id) {
		return this.entityManager.find(Post.class, id);
	}
	
	public List<Post> buscarTodosPosts(){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p FROM Post p"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, Post.class).getResultList();
	}
	
	public List<Post> buscarPorTitulo(String title){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p FROM Post p WHERE p.title = :title"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, Post.class)
								 .setParameter("title", title)
								 .getResultList();
	}
	
	public List<Post> buscarPorCategoria(String nome){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p FROM Post p WHERE p.categoria.name = :nome"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, Post.class)
								 .setParameter("nome", nome)
								 .getResultList();
	}
	
	public String buscarPorNomeUsandoOAtributo(String nome){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p.title FROM Post p WHERE p.categoria.name = :nome"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, String.class)
								 .setParameter("nome", nome)
								 .getSingleResult();
	}
}
