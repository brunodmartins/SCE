package br.com.sce.login;

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
			throw new Exception();
		}
			
		
	}

}
