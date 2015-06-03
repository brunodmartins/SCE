package br.com.sce.aluno;

import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.sce.curso.Curso;
import br.com.sce.dao.DaoException;
import br.com.sce.service.IService;

/**
 * @author bruno
 *
 */
@Controller
@Scope("request")
public class AlunoController {

	@Autowired
	private IService<Aluno> alunoService;

	@Autowired
	private IService<Curso> cursoService;

	private List<Curso> cursos;

	private Aluno aluno;
	
	private Curso cursoSelected;

	public AlunoController() {
		aluno = new Aluno();
	}

	public void cadastrar() {
		try {
			alunoService.salvarDados(aluno);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Aluno cadastrado com sucesso!");	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage());	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public List<Curso> getCursos() {
		try {
			return cursoService.selecionarTodos();
		} catch (DaoException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage());	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCursoSelected() {
		return cursoSelected;
	}

	public void setCursoSelected(Curso cursoSelected) {
		this.cursoSelected = cursoSelected;
	}

}
