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

import com.sce.curso.DaoCurso;

/**
 * Classe: AOPTeste <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 01/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext.xml")
public class AOPTeste {
	
	@Autowired
	private DaoCurso daoCurso;
	
	@BeforeClass
	public static void before(){
	}
	
	@Test
	public void teste(){
		daoCurso.toString();
	}

}
