package br.com.sce.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

@Service
public class AlunoService implements IService<Aluno> {

	@Autowired
	private IDao<Aluno> dao;
	
	@Override
	public void salvarDados(Aluno aluno) throws Exception {
		if("".equals(aluno.getNome()) || aluno.getNome() == null){
			throw new BusinessException("Erro");
		}
		dao.salvar(aluno);
	}
	

	@Override
	public void deletarDados(Aluno aluno) throws DaoException {
		if(aluno.getId() == null)
			throw new DaoException("O aluno " + aluno.getNome() + " n�o possui ID");
		dao.deletar(aluno);
		
	}

	@Override
	public Aluno buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void atualizar(Aluno t) throws DaoException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Aluno> selecionarTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
