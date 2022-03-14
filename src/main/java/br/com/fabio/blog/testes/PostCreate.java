package br.com.fabio.blog.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabio.blog.modelo.Post;

public class PostCreate {
	public static void main(String[] args) {
		Post post = new Post();
		post.setTitle("Primeiro post feito em java");
		post.setDescription("Primeira descricao de um post em java");
		post.setImage("Nenhuma imagem ainda");
		post.setCategory_id(1);
		
		//O nome passo no perssistence create entity manager é o nome dado ao jpa no arquivo persistence
		//<persistence-unit name="blog" transaction-type="RESOURCE_LOCAL">
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("blog");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(post);
		em.getTransaction().commit();
		em.close();
	}
}
