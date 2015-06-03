package br.com.sce.curso;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.sce.service.IService;

@Controller
@Scope("request")
public class CursoController {
	
	@Autowired
	IService<Curso> service;
	
	private Curso curso;
	
	private List<Curso> cursos;
	
	
	public CursoController() {
		curso = new Curso();
	}
	
	public void salvarCurso(){
		try {
			service.salvarDados(curso);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Curso cadastrado com sucesso!");	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage());	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		try {
			return cursos = service.selecionarTodos();
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage());	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	
	
}
