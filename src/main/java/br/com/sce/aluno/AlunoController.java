
package br.com.sce.aluno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.sce.curso.Curso;
import br.com.sce.curso.CursoController;
import br.com.sce.curso.CursoService;
import br.com.sce.service.IService;

/**
 * @author bruno
 *
 */
@Controller
@Scope("request")
public class AlunoController {

	private IService<Aluno> alunoService;	
	
	private CursoService cursoService;

	private List<Curso> itensCurso = new ArrayList<Curso>();

	private Aluno aluno;

	private String confirmaSenha;

	public AlunoController() {
		this.aluno = new Aluno();
		this.alunoService = new AlunoService();		
		this.cursoService=new CursoService();
	}

	public List<Curso> selecionarCurso() {
		try {
			this.setItensCurso(cursoService.selecionarTodos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.getItensCurso();
	}

	public void cadastrar() {
		if (aluno.getPassword().equals(this.getConfirmaSenha())) {
			System.out.println("Senhas iguais!");
		} else {
			System.out.println("Senha não são iguais!");
		}
	}

	public IService<Aluno> getAlunoService() {
		return alunoService;
	}

	public void setAlunoService(IService<Aluno> alunoService) {
		this.alunoService = alunoService;
	}

	public List<Curso> getItensCurso() {
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

}