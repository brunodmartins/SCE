package br.com.sce.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

public class DaoCurso implements IDao<Curso> {
	
	/**
	 * 
	 */
	public DaoCurso() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void salvarDados(Curso e) throws Exception {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();
	}

	@Override
	public void deletarDados(Curso e) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarDados(Long id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> selecionarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso buscarPorId(Long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
