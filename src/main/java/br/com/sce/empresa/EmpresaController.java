package br.com.sce.empresa;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.sce.dao.DaoException;
import br.com.sce.service.IService;

/**
 * @author Jo�o Padovan 
 */

@Controller
@Scope("request")
public class EmpresaController {

	
	@Qualifier(value="empresaService")
	@Autowired
	IService<Empresa> empresaService;
	
	private Empresa empresa;
	private List<Empresa> empresas;
	
	public EmpresaController() throws DaoException {
		empresa = new Empresa();
	}

	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
	public IService<Empresa> getEmpresaService() {
		return empresaService;
	}

	public List<Empresa> getEmpresas() throws DaoException {
		return empresaService.selecionarTodos();
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public void salvarEmpresa(){
		try{
			if(empresa.getId() == null){				
				empresaService.salvarDados(empresa);	
			}else{
				empresaService.atualizar(empresa);
			}
			empresas = empresaService.selecionarTodos();
			empresa = new Empresa();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deletar() {
		try {
			empresaService.deletarDados(empresa);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MENSAGEM: \n" + e.getMessage());
		}
	}
	
}
