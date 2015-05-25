package br.com.sce.empresa;

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
public class EmpresaServiceTest {

	@Autowired
	private IService<Empresa> service;
	
	@Test
	public void gravarEmpresa() throws Exception{
		Empresa empresa = new Empresa();
		empresa.setNome("Google");
		service.salvarDados(empresa);
	}
	
	@Test(expected=BusinessException.class)
	public void gravarEmpresaSemNome() throws Exception{
		Empresa empresa = new Empresa();	
		service.salvarDados(empresa);
	}
	
	@Test
	public void deletarEmpresa() throws Exception{
		Empresa empresa = new Empresa();
		empresa.setNome("Google");
		service.salvarDados(empresa);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("IBM");
		service.salvarDados(empresa2);
		service.deletarDados(empresa2);
	}
	
	@Test(expected=DaoException.class)
	public void deletarCursoSemID() throws Exception{
		Empresa empresa = new Empresa();
		empresa.setNome("Adobe");
		service.deletarDados(empresa);
	}
	
}
