/**
 * 
 */
package br.com.sce.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

/**
 * @author bruno.martins
 *
 */
@Service
public class CursoService implements IService<Curso> {

	@Autowired
	private IDao<Curso> genericDao;
	
	@Override
	public void salvarDados(Curso curso) throws Exception {
		if(curso.getNome() == null || curso.getNome().isEmpty())
			throw new BusinessException("O curso precisa ter um nome!");
		genericDao.salvar(curso);		
	}

	@Override
	public void deletarDados(Curso curso) throws Exception {
		if(curso.getId() == null)
			throw new DaoException("O curso " + curso.getNome() + " n�o possui ID");
		genericDao.deletar(curso);
	}


	@Override
	public Curso buscarPorId(Long id) throws Exception {
		return genericDao.buscarPorId(Curso.class, id);
	}

	@Override
	public void atualizar(Curso t) throws DaoException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Curso> selecionarTodos() throws DaoException {
		return genericDao.selecionarTodos(Curso.class);
	}

	
}
