/**
 * 
 */
package br.com.sce.dao;

import java.util.List;

/**
 * @author bruno.martins
 *
 */
public interface IDao<T> {

	public void salvarDados(T e) throws Exception;

	public void deletarDados(T e) throws DaoException;

	public List<T> selecionarTodos() throws DaoException;

	public T buscarPorId(Long id) throws DaoException;

}
