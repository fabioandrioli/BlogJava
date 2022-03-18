package br.com.fabio.blog.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabio.blog.dao.CategoriaDao;
import br.com.fabio.blog.dao.ClienteDao;
import br.com.fabio.blog.dao.PedidoDao;
import br.com.fabio.blog.dao.ProductDao;
import br.com.fabio.blog.modelo.Categoria;
import br.com.fabio.blog.modelo.Cliente;
import br.com.fabio.blog.modelo.ItemPedido;
import br.com.fabio.blog.modelo.Pedido;
import br.com.fabio.blog.modelo.Product;
import br.com.fabio.blog.utils.JPAUtil;

public class Main {
	EntityManager entityManager = JPAUtil.getEntityManager();
	public static void main(String[] args) {
		
		Main ps = new Main();
		ps.popularBancoDeDados();
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductDao productDao = new ProductDao(entityManager);
		
		Product product =  productDao.buscaPostId(1l);
		
		ClienteDao clienteDao = new ClienteDao(entityManager);
		Cliente cliente = clienteDao.buscaPostId(1l);
		
		entityManager.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido("25.50",pedido,product));
		
		PedidoDao pedidoDao = new PedidoDao(entityManager);
		pedidoDao.create(pedido);
		
		entityManager.getTransaction().commit();
		
	}
	
	public void popularBancoDeDados() {
		Categoria cateogria = new Categoria("Filmes");
		Product product = new Product("nenhum","Titulo","descricao",cateogria);
		Cliente cliente = new Cliente("Fabio");
		
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		ProductDao productDao = new ProductDao(entityManager);
		CategoriaDao categoriaDao = new CategoriaDao(entityManager);
		ClienteDao clienteDao = new ClienteDao(entityManager);
		entityManager.getTransaction().begin();
		
		clienteDao.create(cliente);
	
		
		categoriaDao.create(cateogria);
		//Criacao de post
		productDao.create(product);
		//modificando o post depois da criacao, ele ainda se encontra no estado manager.
//		entityManager.flush();
//		entityManager.clear();
//		//recuperacao do estado do post
//		product = entityManager.merge(product);
//		//update do post
//		product.setTitle("teste");
//		//entityManager.remove(post);
//		entityManager.flush();
//		//entityManager.getTransaction().commit();
		
		
		//buscar post
//		Product p = productDao.buscaPostId(1L);
//		System.out.println(p.getTitle());
		
//		 List<Product> todosPosts = productDao.buscarTodosPosts();
//		 todosPosts.forEach(pos -> System.out.println(pos.getTitle()));
		
//		List<Product> postPorTitulo = productDao.buscarPorTitulo("teste");
//		postPorTitulo.forEach(posTitle -> System.out.println(posTitle.getTitle()));
		
//		List<Product> postPorCategoria = productDao.buscarPorCategoria("Filmes");
//		postPorCategoria .forEach(posCat -> System.out.println(posCat .getTitle()));
		
//		String buscarPorNomeUsandoOAtributo  = productDao.buscarPorNomeUsandoOAtributo("Filmes");
//		System.out.println(buscarPorNomeUsandoOAtributo);
//		
		entityManager.getTransaction().commit();
		entityManager.close();
		
	
	}

}
