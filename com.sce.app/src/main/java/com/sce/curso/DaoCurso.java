package com.sce.curso;

import java.util.List;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

public class DaoCurso implements IDao<Curso> {

	@Override
	public void salvarDados(Curso e) throws DaoException {		
		throw new DaoException("Erroo");
		
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
