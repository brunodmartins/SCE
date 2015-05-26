package br.com.sce.aluno;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.sce.curso.Curso;
import br.com.sce.login.User;

@Entity
@DiscriminatorValue("1")
public class Aluno extends User{

	@Column
	private String nome;
	
	@Column
	private Long ra;
	@Column
	private Date dtNascimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCurso", nullable = false, referencedColumnName = "id")
	private Curso curso;

		public Long getRa() {
		return ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}