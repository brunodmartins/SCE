/**
 * 
 */
package com.sce.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

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
@SessionScoped
public class LoginController {
	
	public void efetuarLogin(User user) {
		System.out.println(user);
	}

}
