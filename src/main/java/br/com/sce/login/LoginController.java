/**
 * 
 */
package br.com.sce.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Classe: LoginController <br>
 * @author Bruno <br>
 * 
 * Propósito:  <br>
 * Data de criação: 28/04/2015 <br>
 */
@Controller
@ManagedBean
@SessionScoped
public class LoginController {
	
	@Autowired
	private ILoginService loginService; 
	
	public void efetuarLogin(User user) {
		loginService.executarLogin(user);
		
	}

}
