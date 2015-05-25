package br.com.sce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.sce.dao.DaoException;

@Repository
public class GenericDao<T> implements IDao<T>{
	
	
	@PersistenceContext
	private EntityManager em;
		
	
	@Override
	@Transactional
	public void salvar(T e){
		if(em.contains(e)){
			em.merge(e);
			
		}else{
			em.persist(e);
		}		
	}
	
	@Override
	@Transactional
	public void atualizar(T e){
		em.merge(e);
	}

	@Override
	public void deletar(T e) throws DaoException {
		if(em.contains(e)){
			em.merge(e);
		}else{
			em.remove(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selecionarTodos(Class<?> clazz) throws DaoException {
		try{
			Query query = em.createQuery("from " + clazz.getName());
			List<T> list = query.getResultList();						
			return list;
		}catch(Exception e){
			em.getTransaction().rollback();
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscarPorId(Class<?> t, Long id) throws DaoException {
		Object find = em.find(t, id);
		return (T) find;
	}

}
