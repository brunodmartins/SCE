package com.sce.curso;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

public class DaoCurso implements IDao<Curso> {
	
	private JdbcTemplate jdbcTemplate;
		
	/**
	 * 
	 */
	@Autowired
	public DaoCurso(DataSource dataSource) {
		 jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	@Override
	public void salvarDados(Curso e) throws Exception {
		jdbcTemplate.execute("select * from Curso");		
		
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
