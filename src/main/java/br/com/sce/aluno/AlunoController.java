
package br.com.sce.aluno;

import java.util.ArrayList;
import java.util.List;

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

	private List<Curso> itensCurso = new ArrayList<Curso>();

	private Aluno aluno;

	private String confirmaSenha;
	
	private Curso cursoSelected;

	public AlunoController() {
		aluno = new Aluno();
	}

	public void cadastrar() {
//		if (aluno.getPassword().equals(this.getConfirmaSenha())) {
//			System.out.println("Senhas iguais!");
//		} else {
//			System.out.println("Senha não são iguais!");
//		}		
		try {
			alunoService.salvarDados(this.aluno);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Gravado com Sucesso!");
		
	}

	public IService<Aluno> getAlunoService() {
		return alunoService;
	}

	public void setAlunoService(IService<Aluno> alunoService) {
		this.alunoService = alunoService;
	}

	public List<Curso> getItensCurso() {
		try {
			itensCurso = cursoService.selecionarTodos();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itensCurso;
	}

	public void setItensCurso(List<Curso> itensCurso) {
		this.itensCurso = itensCurso;
	}	

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
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

	public Curso getCursoSelected() {
		return cursoSelected;
	}

	public void setCursoSelected(Curso cursoSelected) {
		this.cursoSelected = cursoSelected;
	}

}