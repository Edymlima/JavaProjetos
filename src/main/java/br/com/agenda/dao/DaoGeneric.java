package br.com.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.agenda.util.JPAUtil;

public class DaoGeneric<E> {

	public void salvar(E entidades) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransacion = entityManager.getTransaction();
		entityTransacion.begin();
		entityManager.persist(entidades);
		entityTransacion.commit();
		entityManager.close();
	}
	
	public E editarSalvar (E entidades) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransacion = entityManager.getTransaction();
		entityTransacion.begin();
		
		E retorno = entityManager.merge(entidades);
		
		entityTransacion.commit();
		entityManager.close();
		
		return retorno;
	}
	
	public  void  delete2(E entidades) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransacion = entityManager.getTransaction();
		entityTransacion.begin();
		
		entityManager.remove(entidades);
		
		entityTransacion.commit();		
		entityManager.close();
	}
	
	public  void  delete(E entidades) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransacion = entityManager.getTransaction();
		entityTransacion.begin();
		Object id = JPAUtil.getID(entidades);
		entityManager.createQuery("delete from " + entidades.getClass().getCanonicalName() + " where id = " + id ).executeUpdate();
		
		entityTransacion.commit();		
		entityManager.close();
	}
	
	public List<E> lista(Class<E> entidades){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<E> resultado = entityManager.createQuery("from " + entidades.getName()).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
				
		return resultado;
		
	}
}
