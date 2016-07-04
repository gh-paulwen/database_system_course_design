package paul.bank.servlet.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import paul.bank.dao.DailyDao;

public class DailyFilter implements Filter {

	private ServletContext application;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {		
		/**每日自动更新*/		
		String inipath = application.getRealPath("/WEB-INF/ini.properties");
		File inifile = new File(inipath);
		String lastupdatetime = null;
		Properties ini = new Properties();
		boolean flag = false;
		if(inifile.exists()){			
			ini.load(new FileInputStream(inifile));
			lastupdatetime = ini.getProperty("lastupdatetime");			
		}else{
			flag = true;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {			
			String currentStr = sdf.format(new Date());
			if(flag || lastupdatetime==null || lastupdatetime.isEmpty()){
				lastupdatetime = currentStr;
				ini.setProperty("lastupdatetime", currentStr);
				ini.store(new FileOutputStream(inipath), "最近更新日期");
			}
			Date current = sdf.parse(currentStr);
			Date lastupdate = sdf.parse(lastupdatetime);
			int compare = current.compareTo(lastupdate);
			if(compare > 0){
				String result = DailyDao.getInstance().daily(lastupdatetime);
				req.setAttribute("update", "自动操作已完成 : " + result);
				ini.setProperty("lastupdatetime", currentStr);
				ini.store(new FileOutputStream(inipath), "最近更新日期");
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		chain.doFilter(req, resp);		
	}	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		application = filterConfig.getServletContext();
	}

	@Override
	public void destroy() {
	
	}

}
