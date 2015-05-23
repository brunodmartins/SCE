/**
 * 
 */
package br.com.sce.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe: User <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 28/04/2015 <br>
 */
@ManagedBean
@RequestScoped
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String password;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
