package br.com.sce.aluno;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AlunoController {
	
	private AlunoService alunoService;
	
	private Aluno aluno;	
	
	public AlunoController() {
		this.aluno=new Aluno();
		this.alunoService=new AlunoService();
	}
	
	public String cadastrar(){
		alunoService.salvarDados(aluno);	
		return "";
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
