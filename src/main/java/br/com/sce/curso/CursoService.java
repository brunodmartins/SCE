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
			throw new DaoException("O curso " + curso.getNome() + " não possui ID");
		genericDao.deletar(curso);
	}

	@Override
	public List<Curso> selecionarTodos() throws Exception {
		return genericDao.selecionarTodos();
	}

	@Override
	public Curso buscarPorId(Long id) throws Exception {
		return genericDao.buscarPorId(Curso.class, id);
	}

	
}
