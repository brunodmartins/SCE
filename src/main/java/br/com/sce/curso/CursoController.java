package br.com.sce.curso;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sce.service.IService;

@ManagedBean
@ViewScoped
public class CursoController {
	
	@Autowired
	IService<Curso> service;
	
	public void gravarCurso(Curso curso){
		try {
			service.salvarDados(curso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
