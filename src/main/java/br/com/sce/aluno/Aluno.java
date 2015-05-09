package br.com.sce.aluno;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sce.curso.Curso;

@Entity
public class Aluno {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idAluno")
	private Long id;
	@Column
	private String nome;
	@Column
	private Long ra;
	@Column
	private String email;
	@Column
	private Date dtNascimento;
	@Column
	private String senha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurso", nullable = false)
	private Curso curso;
	
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
	public Long getRa() {
		return ra;
	}
	public void setRa(Long ra) {
		this.ra = ra;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", ra=" + ra + ", email="
				+ email + ", dtNascimento=" + dtNascimento + ", senha=" + senha
				+ ", curso=" + curso + "]";
	}	
	
	
	

	
}
