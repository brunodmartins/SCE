package br.com.sce.curso;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.sce.aluno.Aluno;

@Entity
public class Curso {
		
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany
	@JoinColumn(name="Curso.id", referencedColumnName="Aluno.id")
	private List<Aluno> alunos;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + "]";
	}
	
	

}
