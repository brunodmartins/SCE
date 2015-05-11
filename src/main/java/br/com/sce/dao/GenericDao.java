package br.com.sce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T> implements IDao<T>{
	
	
	private EntityManagerFactory emf;
		
	private Class<T> typeParameterClass;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	private EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	@Override
	public void salvar(T e){
		getEntityManager().persist(e);
	}

	@Override
	public void deletar(T e) throws DaoException {
		EntityManager em = getEntityManager();
		T merge = em.merge(e);
		System.out.println(merge);
		em.remove(em.contains(e) ? e : em.merge(e));
	}

	@Override
	public List<T> selecionarTodos(Class<?> clazz) throws DaoException {
//		getEntityManager().		
		return null;
	}

	@Override
	public T buscarPorId(Class<?> clazz, Long id) throws DaoException {
		T find = (T) getEntityManager().find(clazz, id);
		return find;
	}
	

}
