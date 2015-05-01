/**
 * 
 */
package br.com.sce.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
	
	private String email;
	private String password;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
