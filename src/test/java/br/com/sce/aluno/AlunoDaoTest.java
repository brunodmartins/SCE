/**
 * 
 */
package br.com.sce.aluno;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.TestConfig;
import br.com.sce.curso.Curso;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

/**
 * Classe: AlunoDaoTest <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 01/05/2015 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class AlunoDaoTest {
	

	@Autowired
	private IDao<Aluno> genericDao;
	
	@Autowired
	private IDao<Curso> genericDaoCurso;
	
	@Autowired
	private DataSource dataSource;

	@Test
	public void gravarAlunoComSucesso() throws Exception{
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
		genericDao.salvar(aluno);
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
		genericDao.deletar(aluno);
	}

	@Test(expected = DaoException.class)
	public void deletarAlunoNaoEncontrado() throws Exception{
		Aluno c = null;
		try{
			genericDao.deletar(c);
		}catch(Exception e){
			throw new DaoException(e);
		}
		
	}
	
	@After
	public void after(){
		System.out.println("Deletando ");
		new JdbcTemplate(dataSource).execute("delete from Aluno");
	}	

}
