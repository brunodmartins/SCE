/**
 * 
 */
package br.com.sce.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author DAMASCENO
 *
 */
@Component
public interface ILoginService {

	void executarLogin(User user);

}
