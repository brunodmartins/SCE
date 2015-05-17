package br.com.sce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDao<T> implements IDao<T>{
	
	
	@PersistenceContext
	private EntityManager em;
		
	@SuppressWarnings("unused")
	private Class<T> typeParameterClass;
	
	private final String SELECT_ALL = "from Curso";
	
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
	public void deletar(T e) throws DaoException {
		em.remove(em.contains(e) ? e : em.merge(e));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selecionarTodos() throws DaoException {		
		return em.createQuery(SELECT_ALL).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscarPorId(Class<?> t, Long id) throws DaoException {
		Object find = em.find(t, id);
		return (T) find;
	}

	
	

}
