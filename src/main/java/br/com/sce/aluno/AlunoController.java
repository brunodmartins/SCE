package br.com.sce.aluno;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@ManagedBean
@ViewScoped
@Controller
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	private Aluno aluno;	
	
	public AlunoController() {
		this.aluno=new Aluno();
	}
	
	public void cadastrar(){
		try{
			alunoService.salvarDados(aluno);			
		}catch(Exception e){
			//TODO
		}
	}
	
	
}
