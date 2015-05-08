package br.com.sce.aluno;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AlunoController {
	
	private AlunoService alunoService;
	
	private Aluno aluno;	
	
	public AlunoController() {
		this.aluno=new Aluno();
		this.alunoService=new AlunoService();
	}
	
	public void cadastrar(){
		alunoService.salvarDados(aluno);			
	}
	
	public AlunoService getAlunoService() {
		return alunoService;
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
