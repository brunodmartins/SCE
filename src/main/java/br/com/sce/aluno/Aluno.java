package br.com.sce.aluno;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sce.curso.Curso;

@Table
@Entity
public class Aluno {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getRa() {
		return ra;
	}
	public void setRa(long ra) {
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
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", ra=" + ra + ", email="
				+ email + ", dtNascimento=" + dtNascimento
				+ ", senha=" + senha + "]";
	}	
	
	
}
