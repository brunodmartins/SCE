package br.com.sce.curso;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.TestConfig;
import br.com.sce.dao.DaoException;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
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
	
	@Test
	public void deletarCurso() throws Exception{
		Curso curso = new Curso();
		curso.setNome("ADS");
		service.salvarDados(curso);
		Curso curso2 = new Curso();
		curso2.setNome("ADS2");
		service.salvarDados(curso2);
		service.deletarDados(curso2);
	}
	
	@Test(expected=DaoException.class)
	public void deletarCursoSemID() throws Exception{
		Curso curso = new Curso();
		curso.setNome("ADS");
		service.deletarDados(curso);
	}

}
