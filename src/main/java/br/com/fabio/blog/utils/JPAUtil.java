package br.com.fabio.blog.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
		private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("blog");

		//O nome passo no perssistence create entity manager é o nome dado ao jpa no arquivo persistence
		//<persistence-unit name="blog" transaction-type="RESOURCE_LOCAL">
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("blog");
		//EntityManager em = factory.createEntityManager();
		
		public static EntityManager getEntityManager() {
			return FACTORY.createEntityManager();
		}
}
