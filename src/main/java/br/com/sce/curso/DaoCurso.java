package br.com.sce.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

@Repository
public class DaoCurso implements IDao<Curso> {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * 
	 */
	@Autowired
	public DaoCurso(DataSource dataSource) {
		// jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void salvarDados(Curso c) throws Exception {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		try{
			entityManager.persist(c);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
			throw new DaoException(e);
		}
		
	}

	@Override
	public void deletarDados(Curso c) throws DaoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		if(c.getId() == null){
			throw new DaoException("Erro");
		}
		try{
			em.remove(em.contains(c) ? c : em.merge(c));
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			throw new DaoException(e);
		}
		
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
