/**
 * 
 */
package br.com.sce.login;

import org.springframework.stereotype.Service;

/**
 * @author DAMASCENO
 *
 */
@Service
public interface ILoginService {

	void executarLogin(User user);

}
