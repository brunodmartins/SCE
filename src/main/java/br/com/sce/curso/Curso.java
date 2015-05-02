package br.com.sce.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Curso {
		
	@Id
	private Long id;
	
	@Column
	private String nome;

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
