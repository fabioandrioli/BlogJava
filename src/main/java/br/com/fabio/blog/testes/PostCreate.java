package br.com.fabio.blog.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabio.blog.dao.CategoriaDao;
import br.com.fabio.blog.dao.PostDao;
import br.com.fabio.blog.modelo.Categoria;
import br.com.fabio.blog.modelo.Post;
import br.com.fabio.blog.utils.JPAUtil;

public class PostCreate {
	EntityManager entityManager = JPAUtil.getEntityManager();
	public static void main(String[] args) {
		Categoria cateogria = new Categoria("Filmes");
		Post post = new Post("nenhum","Titulo","descricao",cateogria);
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		PostDao postDao = new PostDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		entityManager.getTransaction().begin();
		
	
		
		categoriaDao.create(cateogria);
		//Criacao de post
		postDao.create(post);
		//modificando o post depois da criacao, ele ainda se encontra no estado manager.
		entityManager.flush();
		entityManager.clear();
		//recuperacao do estado do post
		post = entityManager.merge(post);
		//update do post
		post.setTitle("teste");
		//entityManager.remove(post);
		entityManager.flush();
		//entityManager.getTransaction().commit();
		
		
		//buscar post
		Post p = postDao.buscaPostId(1L);
		System.out.println(p.getTitle());
		
		List<Post> todosPosts = postDao.buscarTodosPosts();
		todosPosts.forEach(pos -> System.out.println(pos.getTitle()));
		
		List<Post> postPorTitulo = postDao.buscarPorTitulo("teste");
		postPorTitulo.forEach(posTitle -> System.out.println(posTitle.getTitle()));
		
		List<Post> postPorCategoria = postDao.buscarPorCategoria("Filmes");
		postPorCategoria .forEach(posCat -> System.out.println(posCat .getTitle()));
		
		String buscarPorNomeUsandoOAtributo  = postDao.buscarPorNomeUsandoOAtributo("Filmes");
		System.out.println(buscarPorNomeUsandoOAtributo);
		
	
		entityManager.close();
		
	}

}
