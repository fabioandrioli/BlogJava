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
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		PostDao produtoDao = new PostDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		entityManager.getTransaction().begin();
		
		
		categoriaDao.create(cateogria);
		produtoDao.create(post);
		//modificando o post depois da criacao, ele ainda se encontra no estado manager.
		entityManager.flush();
		entityManager.clear();
		post = entityManager.merge(post);
		post.setTitle("teste");
		entityManager.remove(post);
		entityManager.flush();
		
		//entityManager.getTransaction().commit();
		entityManager.close();
	}
}
