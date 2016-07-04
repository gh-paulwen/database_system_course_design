package paul.bank.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paul.bank.entity.User;

public class UserFilter implements Filter {

	
	private ServletContext application;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		User currentuser = (User) session.getAttribute("currentuser");
		if(currentuser == null){
			((HttpServletResponse) resp).sendRedirect(application.getContextPath() + "/index.jsp");
		}else{
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { 
		application = filterConfig.getServletContext();		
	}

}
