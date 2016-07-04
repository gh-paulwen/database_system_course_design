package paul.bank.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/**
	 * 处理中文乱码，处理重定向和转发 
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 处理参数乱码问题
		 * */
		req = new EncodingRequestWrapper(req);
		
		
				
		
		
		

		
		
		/**
		 * 得到method,利用反射调用对应方法
		 * */		
		String methodName = req.getParameter("method");
		Class<? extends BaseServlet> clazz = this.getClass();		
		try {
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			Object obj = method.invoke(this, req,resp);
			if(obj == null)
				return ;
			String command = (String)obj;
			boolean match = command.matches(".:.*");
			if(match){
				// f:page r:page			
				String[] components = command.split(":");
				String howto = components[0];
				String page = components[1];
				if("f".equals(howto)){
					req.getRequestDispatcher("/"+ page).forward(req, resp);
				}else if("r".equals(howto)){
					resp.sendRedirect(page);
				}
			}else{
				throw new RuntimeException("Wrong Pattern");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}
}
