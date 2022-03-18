package br.com.fabio.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fabio.blog.modelo.Product;

public class ProductDao {
	private EntityManager entityManager;
	
	public ProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void create(Product post) {
		this.entityManager.persist(post);
	}
	
	public Product buscaPostId(Long id) {
		return this.entityManager.find(Product.class, id);
	}
	
	public List<Product> buscarTodosPosts(){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p FROM Product p"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, Product.class).getResultList();
	}
	
	public List<Product> buscarPorTitulo(String title){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p FROM Product p WHERE p.title = :title"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, Product.class)
								 .setParameter("title", title)
								 .getResultList();
	}
	
	public List<Product> buscarPorCategoria(String nome){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p FROM Product p WHERE p.categoria.name = :nome"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, Product.class)
								 .setParameter("nome", nome)
								 .getResultList();
	}
	
	public String buscarPorNomeUsandoOAtributo(String nome){
		//usaremos o jpql que é parecido com sql
		String jpql = "SELECT p.title FROM Product p WHERE p.categoria.name = :nome"; //Algumas coisas mudam, por exemplo passamos o nome da classe ao invés do nome da tabela
		return this.entityManager.createQuery(jpql, String.class)
								 .setParameter("nome", nome)
								 .getSingleResult();
	}
}
