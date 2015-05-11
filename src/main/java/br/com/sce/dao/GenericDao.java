package br.com.sce.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T> {
	
	
	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public void salvar(T e){
		getEntityManager().persist(e);
	}
	

}
