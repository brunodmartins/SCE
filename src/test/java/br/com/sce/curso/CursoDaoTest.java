/**
 * 
 */
package br.com.sce.curso;

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
 * @author Bruno <br>
 * 
 * Prop�sito:  <br>
 * Data de cria��o: 01/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class CursoDaoTest {
	

	@Autowired
	private IDao<Curso> genericDao;
	
	@Autowired
	private DataSource dataSource;

	@Test
	public void gravarCursoComSucesso() throws Exception{
		Curso c = new Curso();
		genericDao.salvar(c);
	}
	
	
	@Test
	public void deletarCurso() throws Exception{
		Curso c = new Curso();
		c.setNome("Teste");
		genericDao.salvar(c);
		genericDao.deletar(c);
	}

	@Test(expected = DaoException.class)
	public void deletarCursoNaoEncontrado() throws Exception{
		Curso c = null;
		try{
			genericDao.deletar(c);
		}catch(Exception e){
			throw new DaoException(e);
		}
		
	}
	
	@After
	public void after(){
		System.out.println("Deletando ");
		new JdbcTemplate(dataSource).execute("delete from Curso");
	}	

}
