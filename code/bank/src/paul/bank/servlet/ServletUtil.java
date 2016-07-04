package paul.bank.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ServletUtil {
	public static Map<String,String> getParameters(HttpServletRequest req,String[] keys){
		Map<String,String> params = new	HashMap<String,String>();		
		for(String key:keys){
			params.put(key, req.getParameter(key));
		}
		return params;
	}
}
