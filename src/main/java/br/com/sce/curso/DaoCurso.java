package br.com.sce.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

@Repository
public class DaoCurso implements IDao<Curso> {
	
	private JdbcTemplate jdbcTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 */
	@Autowired
	public DaoCurso(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Transactional	
	@Override
	public void salvarDados(Curso e) throws Exception {
		entityManager.persist(e);
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
