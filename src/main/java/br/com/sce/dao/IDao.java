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

	void salvar(T e) throws DaoException;

	void deletar(T e) throws DaoException;

	T buscarPorId(Class<?> t, Long id) throws DaoException;

	List<T> selecionarTodos() throws DaoException;

}
