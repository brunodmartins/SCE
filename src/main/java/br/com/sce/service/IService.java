/**
 * 
 */
package br.com.sce.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.sce.dao.DaoException;

/**
 * @author bruno.martins
 *
 */
@Service
public interface IService<T> {
	
	public void salvarDados(T e) throws Exception;
	
	public void deletarDados(T e) throws Exception;
		
	public List<T> selecionarTodos() throws Exception;;
	
	public T buscarPorId(Long id)  throws Exception;;

}
