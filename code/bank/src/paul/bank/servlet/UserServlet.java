package paul.bank.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paul.bank.dao.UserDao;
import paul.bank.entity.User;
import paul.bank.tools.CommonUtils;

public class UserServlet extends BaseServlet {
	
	private final UserDao userDao = UserDao.getInstance();
	
	public String add(HttpServletRequest req,HttpServletResponse resp) {
		String command = "f:admin/adduser.jsp";
		String[] keys = new String[]{
			"userid",
			"password",			
			"power"
		};
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = true;		 
		normal = CommonUtils.multinotnull(params, errors);		
		if(!normal){			
			req.setAttribute("errors", errors);
			return command;
		}
		User user = new User();
		user.setId(params.get("userid"));
		user.setPassword(CommonUtils.md5(params.get("password")));
		user.setPowerid(Integer.parseInt(params.get("power")));		
		String result = userDao.add(user);		
		req.setAttribute("result", result);
		return "f:/user/message.jsp";
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse resp){		
		
		String userid = req.getParameter("userid");		
		String result = userDao.delete(userid);
		req.setAttribute("result", result);
		return "f:user/message.jsp";
	}
	
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp){
		
		List<User> listUser = userDao.findAll();
		req.setAttribute("listUser", listUser);
		return "f:admin/userlist.jsp";
	}
	
	
	public String alter(HttpServletRequest req,HttpServletResponse resp){
		
		String[] keys = new String[]{
			"userid","password","power"
		};
		Map<String,String> params = ServletUtil.getParameters(req, keys);		
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = true;
		normal = CommonUtils.multinotnull(params, errors);		
		
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:user/message.jsp";
		}		
		User user = new User();
		user.setPassword(CommonUtils.md5(params.get("password")));
		user.setPowerid(Integer.parseInt(params.get("power")));
		String res = userDao.alter(params.get("userid"),user);
		req.setAttribute("result", res);
		return "f:user/message.jsp";
	}
	
	
	public String login(HttpServletRequest req, HttpServletResponse resp){
		String command = "r:index.jsp";	
		String[] keys = new String[]{
			"userid","password"
		};		
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = true;

		normal = CommonUtils.multinotnull(params, errors);
			
		if(!normal){
			req.setAttribute("errors", errors);
			return command;
		}
		User user = new User();
		user.setId(params.get("userid"));
		user.setPassword(CommonUtils.md5(params.get("password")));
		User fromDB = userDao.login(user);
		if(fromDB != null){
			req.getSession().setAttribute("currentuser", fromDB);
		}else{
			errors.put("loginError", "用户名或密码错误");
			req.setAttribute("errors", errors);
		}
		return command;		
	}
	
	public String find(HttpServletRequest req, HttpServletResponse resp){
		String userid = req.getParameter("userid");
		User user = userDao.find(userid);
		req.setAttribute("user", user);
		return "f:admin/alterUser.jsp";	
	}
	
	public String logout(HttpServletRequest req, HttpServletResponse resp){
		req.getSession().removeAttribute("currentuser");
		return "r:index.jsp";
	}
}
