package br.com.sce.aluno;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.curso.Curso;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
@ActiveProfiles("test")
public class AlunoSalvarTest {		

	private AlunoService alunoService;
	private Aluno aluno;
	private DaoAluno daoAluno;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		
	}
	
	@Test
	public void salvarTest() throws DaoException {
		daoAluno=Mockito.mock(DaoAluno.class);
		aluno=Mockito.mock(Aluno.class);	
		daoAluno.salvarDados(aluno);
	}

	

}
