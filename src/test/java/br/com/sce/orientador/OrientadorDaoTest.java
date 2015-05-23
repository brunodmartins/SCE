package br.com.sce.orientador;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.TestConfig;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
	
@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class OrientadorDaoTest {
	
	@Autowired
	private IDao<Orientador> genericDao;
	
	@Autowired
	private DataSource dataSource;	
	
	@Test
	public void gravarOrientadorComSucesso() throws Exception{
		Orientador c = new Orientador();
		genericDao.salvar(c);
	}
	
	@Test
	public void deletarOrientador() throws Exception{
		Orientador c = new Orientador();
		c.setNome("Teste");
		genericDao.salvar(c);
		genericDao.deletar(c);
	}

	@Test(expected = DaoException.class)
	public void deletarOrientadorNaoEncontrado() throws Exception{
		Orientador c = null;
		try{
			genericDao.deletar(c);
		}catch(Exception e){
			throw new DaoException(e);
		}		 
	}
	
	@After
	public void after(){
		System.out.println("Deletando ");
		new JdbcTemplate(dataSource).execute("delete from Orientador");
	}	

}
