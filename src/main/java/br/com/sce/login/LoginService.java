package br.com.sce.login;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private LoginDao dao; 
	
	@Override
	public void executarLogin(User user) throws Exception {
		if(dao.validaUsuario(user)){
			user = dao.carregarParametrizacao(user);
			RequestContextHolder.getRequestAttributes().setAttribute("usuario", user, RequestAttributes.SCOPE_SESSION);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login inválido", "Email e/ou Senha inválidos.");	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
	        throw new Exception("Login inválido");
		}
			
		
	}

}
