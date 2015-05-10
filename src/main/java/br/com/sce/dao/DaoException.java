/**
 * 
 */
package br.com.sce.dao;

/**
 * @author bruno.martins
 *
 */
public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DaoException(String msg) {
		super(msg);
	}

	public DaoException(Throwable exception) {
		super(exception);
	}

}
