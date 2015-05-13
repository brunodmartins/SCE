package br.com.sce.aluno;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.TestConfig;
import br.com.sce.curso.Curso;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;
import br.com.sce.service.BusinessException;
import br.com.sce.service.IService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class AlunoServiceTest {
	
	@Autowired
	private IDao<Curso> genericDaoCurso;
	
	@Autowired
	private IService<Aluno> service;
	
	@Test
	public void gravarAluno() throws Exception{
		Aluno aluno = new Aluno();
		aluno.setNome("Bruno Damascneo Martins");
		aluno.setRa((long) 1410776);
		aluno.setSenha("senha");
		aluno.setEmail("bdm2943@mail.com");
		aluno.setDtNascimento(new Date());
		Curso c = new Curso();
		c.setNome("ADS");
		genericDaoCurso.salvar(c);
		aluno.setCurso(c);
		service.salvarDados(aluno);
	}
	
	@Test(expected=BusinessException.class)
	public void gravarAlunoSemNome() throws Exception{
		Aluno aluno = new Aluno();	
		service.salvarDados(aluno);
	}
	
	@Test
	public void deletarAluno() throws Exception{
		Aluno aluno = new Aluno();
		aluno.setNome("Bruno Damascneo Martins");
		aluno.setRa((long) 1410776);
		aluno.setSenha("senha");
		aluno.setEmail("bdm2943@mail.com");
		aluno.setDtNascimento(new Date());
		Curso c = new Curso();
		c.setNome("ADS");
		genericDaoCurso.salvar(c);
		aluno.setCurso(c);
		service.salvarDados(aluno);
		service.deletarDados(aluno);
	}
	
	@Test(expected=DaoException.class)
	public void deletarAlunoSemID() throws Exception{
		Aluno aluno = new Aluno();
		aluno.setNome("Bruno Damascneo Martins");
		aluno.setRa((long) 1410776);
		aluno.setSenha("senha");
		aluno.setEmail("bdm2943@mail.com");
		aluno.setDtNascimento(new Date());
		Curso c = new Curso();
		c.setNome("ADS");
		genericDaoCurso.salvar(c);
		aluno.setCurso(c);
		service.deletarDados(aluno);
	}

}
