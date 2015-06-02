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

import org.joda.time.DateTime;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD,
		DispatcherType.ASYNC, DispatcherType.INCLUDE, DispatcherType.ERROR, }, asyncSupported = true, urlPatterns = { "/" })
public class SecuritySessionTimeFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SecuritySessionTimeFilter() {
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
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session != null) {
			DateTime now = new DateTime();
			DateTime lastAcess = new DateTime(session.getLastAccessedTime());

			lastAcess = lastAcess.plusSeconds(session.getMaxInactiveInterval());
			if (lastAcess.isBefore(now)) {
				RequestContextHolder.getRequestAttributes().removeAttribute(
						"usuario", RequestAttributes.SCOPE_SESSION);
				((HttpServletResponse) response)
						.sendRedirect("../login.xhtml?faces-redirect=true");
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
