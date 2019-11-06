package br.com.agenda.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = null;
	
	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("AgendaJpa");
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getID(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
				
	}
}
	