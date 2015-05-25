/**
 * 
 */
package br.com.sce.service;

import java.util.List;

import br.com.sce.dao.DaoException;

/**
 * @author bruno.martins
 *
 */
public interface IService<T> {
	
	public void salvarDados(T e) throws Exception;
	
	public void deletarDados(T e) throws Exception;
	
	public T buscarPorId(Long id)  throws Exception;

	void atualizar(T t) throws DaoException;

	List<T> selecionarTodos() throws DaoException;
}
