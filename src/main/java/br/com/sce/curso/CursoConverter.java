package br.com.sce.curso;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.sce.dao.DaoException;
import br.com.sce.dao.GenericDao;
import br.com.sce.dao.IDao;


@Component("cursoConverter")
public class CursoConverter implements Converter {

	@Autowired
	private IDao<Curso> genericDao;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		Curso curso = null;
		try {
			curso = genericDao.buscarPorId(Curso.class, Long.parseLong(value));
		} catch (NumberFormatException | DaoException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage());	         
	        RequestContext.getCurrentInstance().showMessageInDialog(message);
		}
		return curso;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {		
		return obj.toString();
	}

}
