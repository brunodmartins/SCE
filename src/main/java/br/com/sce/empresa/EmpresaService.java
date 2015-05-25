package br.com.sce.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

@Service
public class EmpresaService implements IService<Empresa> {

	@Autowired
	private IDao<Empresa> genericDao;
	
	@Override
	public void salvarDados(Empresa empresa) throws Exception {
		if(empresa.getNome() == null || empresa.getNome().isEmpty())
			throw new BusinessException("A empresa precisa ter um nome!");
		genericDao.salvar(empresa);		
	}
	
	@Override
	public void deletarDados(Empresa empresa) throws Exception {
		if(empresa.getId() == null)
			throw new DaoException("A empresa " + empresa.getNome() + " n�o possui ID");
		genericDao.deletar(empresa);
	}

	@Override
	public List<Empresa> selecionarTodos() throws DaoException {
		return genericDao.selecionarTodos(Empresa.class);
	}

	@Override
	public Empresa buscarPorId(Long id) throws Exception {
		return genericDao.buscarPorId(Empresa.class, id);
	}

	@Override
	public void atualizar(Empresa t) throws DaoException {
		genericDao.atualizar(t);
	}
}
