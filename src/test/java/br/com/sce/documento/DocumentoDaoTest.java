package br.com.sce.documento;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.TestConfig;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class DocumentoDaoTest {
	
	@Autowired
	private IDao<Documento> dao;
	
	@Test
	public void salvarDocumento() throws DaoException{
		Documento documento = new Documento();
		dao = Mockito.mock(IDao.class);
		File file = Mockito.mock(File.class);
		documento.setNome("Arq1");
		documento.setArq(file);
		dao.salvar(documento);
		Mockito.verify(dao).salvar(documento);
	}
	

}
