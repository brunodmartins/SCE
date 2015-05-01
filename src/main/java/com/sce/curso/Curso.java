package com.sce.curso;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table
public class Curso {
	//
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
