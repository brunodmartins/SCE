/**
 * 
 */
package br.com.sce;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.curso.Curso;
import br.com.sce.dao.IDao;

/**
 * Classe: AOPTeste <br>
 * @author Bruno <br>
 * 
 * Prop�sito:  <br>
 * Data de cria��o: 01/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@ActiveProfiles("test")
public class AOPTest {
	
	@Autowired
	private IDao<Curso> daoCurso;
	
	@BeforeClass
	public static void before(){
		
	}
	
	@Test
	public void teste() throws Exception{
		Curso c = new Curso();
		c.setNome("ADS");
		daoCurso.salvarDados(c);
	}

}
