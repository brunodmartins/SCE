/**
 * 
 */
package com.sce.app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

import com.sce.curso.Curso;

/**
 * Classe: AOPTeste <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 01/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class AOPTest {
	
	@Autowired
	private IDao<Curso> daoCurso;
	
	@BeforeClass
	public static void before(){
	}
	
	@Test(expected=DaoException.class)
	public void teste() throws DaoException{
		daoCurso.salvarDados(null);
	}

}
