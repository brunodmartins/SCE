/**
 * 
 */
package br.com.sce.empresa;

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

/**
 * Classe: CursoDaoTest <br>
 * @author João Padovan <br>
 * 
 * Propï¿½sito:  <br>
 * Data de criaï¿½ï¿½o: 24/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class EmpresaDaoTest {
	

	@Autowired
	private IDao<Empresa> genericDao;
	
	@Autowired
	private DataSource dataSource;

	@Test
	public void gravarEmpresaComSucesso() throws Exception{
		Empresa e = new Empresa();
		genericDao.salvar(e);
	}
	
	
	@Test
	public void deletarEmpresa() throws Exception{
		Empresa r = new Empresa();
		r.setNome("Teste");
		genericDao.salvar(r);
		genericDao.deletar(r);
	}

	@Test(expected = DaoException.class)
	public void deletarEmpresaNaoEncontrada() throws Exception{
		Empresa e = null;
		try{
			genericDao.deletar(e);
		}catch(Exception e1){
			throw new DaoException(e1);
		}
		
	}
	
	@After
	public void after(){
		System.out.println("Deletando ");
		new JdbcTemplate(dataSource).execute("delete from Empresa");
	}	

}