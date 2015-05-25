package br.com.sce.orientador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sce.curso.Curso;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

public class OrientadorService implements IService<Orientador> {

	@Autowired
	private IDao<Orientador> genericDao;

	@Override
	public void salvarDados(Orientador orientador) throws Exception {

		if (orientador.getNome() == null || orientador.getNome().isEmpty())
			throw new BusinessException("O orientador precisa ter um nome!");

		if (orientador.getTelefone() == null
				|| orientador.getTelefone().isEmpty())
			throw new BusinessException("O orientador precisa ter um telefone!");

		if (orientador.getCurso() == null || orientador.getCurso().isEmpty())
			throw new BusinessException(
					"O orientador precisa estar em um orientador!");

		genericDao.salvar(orientador);

	}

	@Override
	public void deletarDados(Orientador orientador) throws Exception {
		if (orientador.getId() == null)
			throw new DaoException("O orientador " + orientador.getNome()
					+ " n�o possui ID");
		genericDao.deletar(orientador);

	}

	@Override
	public List<Orientador> selecionarTodos() throws DaoException {
		return genericDao.selecionarTodos(Orientador.class);
	}

	@Override
	public Orientador buscarPorId(Long id) throws Exception {
		return genericDao.buscarPorId(Curso.class, id);
	}

	@Override
	public void atualizar(Orientador t) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
