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
import javax.servlet.http.HttpSession;

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
		System.out.println("AAAAA");	
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if(session != null){
			System.out.println(session.getMaxInactiveInterval());
			System.out.println(session.getLastAccessedTime());
		}
		User user = (User) RequestContextHolder.getRequestAttributes().getAttribute("usuario", RequestAttributes.SCOPE_SESSION);
		System.out.println(user);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
