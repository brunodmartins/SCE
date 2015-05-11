package br.com.sce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T> implements IDao<T>{
	
	
	@PersistenceContext
	private EntityManager em;
		
	private Class<T> typeParameterClass;
	
	@Override
	@Transactional
	public void salvar(T e){
		em.persist(e);
	}

	@Override
	public void deletar(T e) throws DaoException {
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
	public T buscarPorId(Class<?> t, Long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
