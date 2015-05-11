/**
 * 
 */
package br.com.sce.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
import br.com.sce.service.IService;
import br.com.sce.service.ServiceException;

/**
 * @author bruno.martins
 *
 */
@Service
public class CursoService implements IService<Curso> {

	@Autowired
	private IDao<Curso> genericDao;
	
	@Override
	public void salvarDados(Curso e) throws Exception {
		genericDao.salvar(e);		
	}

	@Override
	public void deletarDados(Curso e) throws Exception {
		genericDao.deletar(e);
	}

	@Override
	public List<Curso> selecionarTodos() throws Exception {
		return genericDao.selecionarTodos(Curso.class);
	}

	@Override
	public Curso buscarPorId(Long id) throws Exception {
		return genericDao.buscarPorId(Curso.class, id);
	}

	
}
