package br.com.sce.curso;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.sce.dao.DaoException;
import br.com.sce.service.IService;

@Controller
@Scope("request")
public class CursoController {
	
	@Autowired
	IService<Curso> service;
	
	private Curso curso;
	
	private List<Curso> cursos;
	
	public CursoController() {
		Curso novoCurso = (Curso) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("curso");
		if(novoCurso != null){
			this.curso = novoCurso;
		}else{
			this.curso = new Curso();
		}
	}
	
	public void salvarCurso(){
		try {
			service.salvarDados(curso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String editarCurso(Curso curso){
		 FacesContext.getCurrentInstance().getExternalContext().getFlash()
         .put("curso", curso);
		 this.curso = curso;
		return "/curso/cursoCadastro?faces-redirect=true";
		
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() throws DaoException {
		return service.selecionarTodos();
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}

 
