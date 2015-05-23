package br.com.sce.login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sce.TestConfig;
import br.com.sce.dao.DaoException;
import br.com.sce.dao.IDao;

/**
 * Teste para a DAO de Login
 * 
 * @author bruno
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestConfig
public class LoginDaoTest {
	
	@Autowired
	private LoginDao dao;
	
	@Autowired
	private IDao<User> genericDao;
	
	private static User usuarioCadastrado;
	
	private static User usuarioNaoCadastrado;
	
	@Before
	public void before() throws DaoException{
		usuarioCadastrado = new User();
		usuarioCadastrado.setEmail("bdm2943@gmail.com");
		usuarioCadastrado.setNome("Bruno Damasceno Martins");
		usuarioCadastrado.setPassword("61417181@ab");
		genericDao.salvar(usuarioCadastrado);
		
		usuarioNaoCadastrado = new User();
		usuarioNaoCadastrado.setEmail("aa");
		usuarioNaoCadastrado.setPassword("bb");
	}
	
	@Test
	public void validaUsuarioExistente(){		
		assertTrue(dao.validaUsuario(usuarioCadastrado));
	}
	
	@Test
	public void validaUsuarioNaoExistente(){
		assertFalse(dao.validaUsuario(usuarioNaoCadastrado));
	}
	
	@Test
	public void validarParametrizacaoADM(){
		dao.carregarParametrizacao(usuarioCadastrado);
	}
	

}
