package br.com.sce.empresa;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sce.service.IService;

@ManagedBean
@ViewScoped
public class EmpresaController {

	@Autowired
	IService<Empresa> service;
	
	private Empresa empresa;
	
	@PostConstruct
	public void init() {
		empresa = new Empresa();
		service = new EmpresaService();
	}
	
	public void gravarEmpresa(Empresa empresa) {
		try {
			service.salvarDados(empresa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarEmpresa(Empresa empresa) {
		try {
			service.deletarDados(empresa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Empresa> selecionarTodasEmpresa() {
		try {
			return service.selecionarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Empresa buscarEmpresaPorId(Long id) {
		try {
			return service.buscarPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
		
	}
	
}
