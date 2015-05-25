package br.com.sce.curso;

import java.util.List;

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	
}
