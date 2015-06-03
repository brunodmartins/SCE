package br.com.sce.curso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.sce.aluno.Aluno;

@Entity
public class Curso implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 7321792839746522657L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<Aluno>(0);

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
	
	@Override
	public int hashCode() {
		return Long.valueOf(id).intValue();
	}
	@Override
	public boolean equals(Object obj) {	
		return obj.hashCode() == hashCode();
	}
	

}
