package br.com.sce.empresa;

import java.util.ArrayList;
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
	private List<Empresa> empresas;
	
	public EmpresaController() {
		empresa = new Empresa();
		try {
			empresas = empresaService.selecionarTodos(Empresa.class);
		} catch (Exception e) {
			empresas = new ArrayList<Empresa>();
		}
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

	public void setEmpresaService(IService<Empresa> empresaService) {
		this.empresaService = empresaService;
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	public void salvarEmpresa(){
		try{
			if(empresa.getId() == null){				
				empresaService.salvarDados(empresa);
				empresas.add(empresa);				
			}else{
				empresaService.atualizar(empresa);
			}
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
