/**
 * 
 */
package br.com.sce.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author DAMASCENO
 *
 */
@Component
public interface ILoginService {

	void executarLogin(User user) throws Exception;

}
