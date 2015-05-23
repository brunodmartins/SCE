package br.com.sce.aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.sce.service.IService;

/**
 * @author bruno
 *
 */
@Controller
@Scope("request")
public class AlunoController{

	@Autowired
	private IService<Aluno> alunoService;
	
	private Aluno aluno;
	
	public AlunoController() {
		aluno = new Aluno();
	}
	
	public void cadastrar(){
		System.out.println("AAA");
		try{
			alunoService.salvarDados(aluno);				
		}catch(Exception e){
			//TODO
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
	
	
}
