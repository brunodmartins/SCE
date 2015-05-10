/**
 * 
 */
package br.com.sce;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.curso.Curso;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

/**
 * Classe: AOPTeste <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criaçãoo: 01/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@ActiveProfiles("test")
public class DaoCursoTest {
	
	@Autowired
	private IDao<Curso> daoCurso;
	
	@Autowired
	private DataSource dataSource;

	@Test
	public void gravarCursoComSucesso() throws Exception{
		Curso c = new Curso();
		c.setNome("ADS");
		daoCurso.salvarDados(c);
	}
	
	@Test(expected=DaoException.class)
	public void gravarCursoDuplicado() throws Exception{
		Curso c = new Curso();
		c.setNome("C1");
		daoCurso.salvarDados(c);
		daoCurso.salvarDados(c);
	}
	
	@Test
	public void deletarCurso() throws Exception{
		Curso c = new Curso();
		c.setNome("Teste");
		daoCurso.salvarDados(c);		
		daoCurso.deletarDados(c);
	}

	@Test(expected = DaoException.class)
	public void deletarCursoNaoEncontrado() throws Exception{
		Curso c = new Curso();
		daoCurso.deletarDados(c);
	}
	
	@After
	public void after(){
		System.out.println("Deletando dados");
		new JdbcTemplate(dataSource).execute("delete from Curso");
	}	

}
