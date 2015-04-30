/**
 * 
 */
package br.com.sce.service;

import java.util.List;

/**
 * @author bruno.martins
 *
 */
public interface IService<T> {
	
	public void salvarDados(T e);
	
	public void deletarDados(T e);
	
	public void deletarDados(Long id);
	
	public List<T> selecionarTodos();
	
	public T buscarPorId(Long id);

}
