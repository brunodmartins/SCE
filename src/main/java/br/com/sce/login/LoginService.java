package br.com.sce.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sce.dao.IDao;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private LoginDao dao; 
	
	@Override
	public void executarLogin(User user) {
		
	}

}
