package br.com.sce.empresa;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sce.service.IService;

/**
 * @author João Padovan 
 */

@ManagedBean
@ViewScoped
public class EmpresaController {

	@Autowired
	IService<Empresa> empresaService;
	
	private Empresa empresa;
	
	public EmpresaController() {
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
	
	public void cadastrar() {
		try {
			empresaService.salvarDados(empresa);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MENSAGEM: \n" + e.getMessage());
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
	
	public List<Empresa> selecionarTodos() {
		try {
			return empresaService.selecionarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MENSAGEM: \n" + e.getMessage());
			return null;
		}
	}
	
	
}
