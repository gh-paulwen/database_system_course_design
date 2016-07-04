package paul.bank.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paul.bank.entity.User;

public class AdminFilter implements Filter {

	
	private ServletContext application;
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session =((HttpServletRequest) request).getSession();
		
		User currentuser = (User) session.getAttribute("currentuser");
		if(currentuser == null){
			((HttpServletResponse) response).sendRedirect(application.getContextPath() + "/index.jsp");
			return;
		}
		if(currentuser.getPowerid() != 1){
			request.setAttribute("result", "操作权限不足");
			request.getRequestDispatcher("/user/message.jsp").forward(request, response);
		}else if(currentuser.getPowerid() == 1){
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		application = filterConfig.getServletContext();
	}

}
