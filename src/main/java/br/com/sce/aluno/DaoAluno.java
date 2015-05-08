package br.com.sce.aluno;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

public class DaoAluno implements IDao<Aluno>{	
	
	private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	public DaoAluno(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override	
	public void salvarDados(Aluno e) throws DaoException {		
		entityManager.persist(e);		
	
	}

	@Override
	public void deletarDados(Aluno e) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarDados(Long id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> selecionarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno buscarPorId(Long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
