package br.com.sce.security;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import br.com.sce.login.User;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD,
				DispatcherType.ASYNC,
				DispatcherType.INCLUDE,
				DispatcherType.ERROR,
		}
					, 
		asyncSupported = true, 
		urlPatterns = { "/" })
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(!((HttpServletRequest) request).getRequestURI().matches(".*(css|jpg|png|gif|js)")){
				
			HttpSession session = ((HttpServletRequest) request).getSession(false);
			if(session != null){				
				DateTime maxTime = new DateTime();
				DateTime lastAcess = new DateTime(session.getLastAccessedTime());
				
				maxTime.plusSeconds(session.getMaxInactiveInterval());				
				
				if(lastAcess.isAfter(maxTime)){
					session.invalidate();
					FacesContext.getCurrentInstance().addMessage("Sessão inválida", new FacesMessage("Sessão inválida"));
					((HttpServletResponse) response).sendRedirect("./login/login.xhtml?faces-redirect=true?");
				}
				
				User user = (User) RequestContextHolder.getRequestAttributes().getAttribute("usuario", RequestAttributes.SCOPE_SESSION);
				System.out.println("Usuário logado: " + user + " Último acesso: " + lastAcess);
				
			}
			
			
			chain.doFilter(request, response);
		}else{
			System.out.println("css");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
