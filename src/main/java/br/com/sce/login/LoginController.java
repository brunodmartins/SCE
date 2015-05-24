/**
 * 
 */
package br.com.sce.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe: LoginController <br>
 * @author Bruno <br>
 * 
 * Prop�sito:  <br>
 * Data de cria��o: 28/04/2015 <br>
 */
@Controller
@Scope("request")
public class LoginController {
	
	private User user;
	
	@Autowired
	private ILoginService loginService;
	
	public LoginController() {
		user = new User();
	}
	
	public String efetuarLogin() {
		try {
			loginService.executarLogin(user);
			return "/aluno/aluno.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
