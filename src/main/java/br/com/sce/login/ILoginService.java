/**
 * 
 */
package br.com.sce.login;

import org.springframework.stereotype.Component;

/**
 * @author DAMASCENO
 *
 */
@Component
public interface ILoginService {

	void executarLogin(User user) throws Exception;

}
