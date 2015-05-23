/**
 * 
 */
package br.com.sce.login;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe: User <br>
 * @author Bruno <br>
 * 
 * Prop�sito:  <br>
 * Data de cria��o: 28/04/2015 <br>
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="USER_TYPE")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String email;

	@Column
	private String password;
	
	private Permissao permissao;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
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
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

}
