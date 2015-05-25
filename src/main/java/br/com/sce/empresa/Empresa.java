package br.com.sce.empresa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empresa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String cnpj;
	
	@Column(unique=true)
	private String nome;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date inicioConvenio;
	
	@Column
	private String endereco;
	
	@Column(unique=true)
	private String telefone;

	public Long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public Date getInicioConvenio() {
		return inicioConvenio;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setInicioConvenio(Date inicioConvenio) {
		this.inicioConvenio = inicioConvenio;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Empresa [ID: " + id + " | Nome: " + nome + " | CNPJ: " + cnpj + "]";
	}
}
