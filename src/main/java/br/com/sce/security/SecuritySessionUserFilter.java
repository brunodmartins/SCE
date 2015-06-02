package br.com.sce.security;

import java.io.IOException;

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

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import br.com.sce.login.User;

/**
 * Servlet Filter implementation class SecuritySessionUserFilter
 */
@WebFilter(description = "Filtro para verificar se o usuário esta logado", urlPatterns = { "/*/" }, dispatcherTypes={DispatcherType.REQUEST})
public class SecuritySessionUserFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecuritySessionUserFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {		
		User user = (User) RequestContextHolder.getRequestAttributes()
				.getAttribute("usuario", RequestAttributes.SCOPE_SESSION);
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if(session != null){
			if (user == null){
				HttpServletResponse responseServlet = ((HttpServletResponse) response);						
				responseServlet.sendRedirect("../login.xhtml?faces-redirect=true");
			}
		}
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
