/**
 * 
 */
package br.com.sce.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Classe: LoginController <br>
 * @author Bruno <br>
 * 
 * Prop�sito:  <br>
 * Data de cria��o: 28/04/2015 <br>
 */
@Controller
@ManagedBean
@ViewScoped
public class LoginController {
	
	private User user;
	
	@Autowired
	private ILoginService loginService; 
	
	public void efetuarLogin(User user) {
		loginService.executarLogin(user);
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
