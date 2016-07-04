package paul.bank.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paul.bank.dao.AccountDao;
import paul.bank.dao.CustomerDao;
import paul.bank.entity.Account;
import paul.bank.entity.Customer;
import paul.bank.tools.CommonUtils;

public class AccountServlet extends BaseServlet {
	
	private AccountDao accountDao = AccountDao.getInstance();
	private CustomerDao customerDao = CustomerDao.getInstance();
	
	public String add(HttpServletRequest req, HttpServletResponse resp){
		
		String[] keys = new String[]{
			"customer_id","customer_name",
			"address","phonenumber","type",
			"password","verifypassword"
		};		
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		params.put("account_id", accountDao.generateid());
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		
		if(!params.get("password").equals(params.get("verifypassword"))){
			normal = false;
			errors.put("verifypassword", "两次密码不相同");
		}
		
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:user/addAccount.jsp";
		}		
		
		Customer cust = new Customer();
		cust.setId(params.get("customer_id"));
		cust.setName(params.get("customer_name"));
		cust.setAddress(params.get("address"));
		cust.setPhonenumber(params.get("phonenumber"));		
		Account account = new Account();
		account.setId(params.get("account_id"));
		account.setType(Integer.parseInt(params.get("type")));
		account.setCust_id(cust.getId());
		account.setPassword(CommonUtils.md5(params.get("password")));
		String result = accountDao.add(cust, account);		
		req.setAttribute("result", result);		
		return "f:user/message.jsp";
	}
	
	
	public String find(HttpServletRequest req, HttpServletResponse resp){			
		String[] keys = new String[]{"account_id"};
		Map<String,String> params = ServletUtil.getParameters(req, keys);		
		Account account = accountDao.find(params.get("account_id"));		
		req.setAttribute("account", account);		
		return "";
	}
	
	
	public String withdrawfree(HttpServletRequest req, HttpServletResponse resp){		
		String[] keys = new String[]{
			"account_id",
			"password",
			"money"
		};		
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:user/message.jsp";
		}		
		String result = accountDao.withdrawFree(params.get("account_id"), CommonUtils.md5(params.get("password")),Double.parseDouble(params.get("money")));		
		req.setAttribute("result", result);		
		return "f:user/message.jsp";
	}
	
	
	public String depositfree(HttpServletRequest req, HttpServletResponse resp){
		
		String[] keys = "account_id,money".split(",");
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:message.jsp";
		}		
		String result = accountDao.depositFree(params.get("account_id"), Double.parseDouble(params.get("money")));		
		req.setAttribute("result", result);
		return "f:user/message.jsp";
	}
	
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp){
		List<Account > listAccount = accountDao.findAll();
		req.setAttribute("listAccount", listAccount);
		return "f:user/accountlist.jsp";
	}

}
