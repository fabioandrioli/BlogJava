package br.com.fabio.blog.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabio.blog.dao.CategoriaDao;
import br.com.fabio.blog.dao.PostDao;
import br.com.fabio.blog.modelo.Categoria;
import br.com.fabio.blog.modelo.Post;
import br.com.fabio.blog.utils.JPAUtil;

public class PostCreate {
	public static void main(String[] args) {
		Categoria cateogria = new Categoria("Filmes");
		Post post = new Post("nenhum","Titulo","descricao",cateogria);
		post.setTitle("Primeiro post feito em java");
		post.setDescription("Primeira descricao de um post em java");
		post.setImage("Nenhuma imagem ainda");
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		PostDao produtoDao = new PostDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		entityManager.getTransaction().begin();
		
		categoriaDao.create(cateogria);
		produtoDao.create(post);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
