package br.com.sce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.curso.Curso;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@ActiveProfiles("test")
public class CursoServiceTest {
	
	@Autowired
	private IService<Curso> service;
	
	@Test
	public void gravarCurso() throws Exception{
		Curso curso = new Curso();
		curso.setNome("ADS");
		service.salvarDados(curso);
	}
	
	@Test(expected=BusinessException.class)
	public void gravarCursoSemNome() throws Exception{
		Curso curso = new Curso();	
		service.salvarDados(curso);
	}
		

}
