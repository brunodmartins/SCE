package br.com.sce.orientador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import br.com.sce.curso.Curso;
import br.com.sce.login.User;

@Entity
@DiscriminatorValue("2")
public class Orientador  extends User{
	
	@Column
	private String nome;
	
	@Column
	private String telefone;
	
	@OneToMany
	@JoinTable(
		  name="CursoCoordenador",
	      joinColumns={ @JoinColumn(name="CursoID", referencedColumnName="id") },
	      inverseJoinColumns={@JoinColumn(name="OrientadorID", referencedColumnName="id", unique=true) }
	  )
	private List<Curso> curso = new ArrayList<Curso>();
		
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	
}
