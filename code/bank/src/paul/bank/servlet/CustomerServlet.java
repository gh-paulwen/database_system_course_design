package paul.bank.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paul.bank.dao.CustomerDao;
import paul.bank.entity.Customer;
import paul.bank.tools.CommonUtils;

public class CustomerServlet extends BaseServlet {
	
	
	private final CustomerDao customerDao = CustomerDao.getInstance(); 
	
	//TODO
	public String find(HttpServletRequest req, HttpServletResponse resp){
		String customer_id = req.getParameter("customer_id");
		Customer customer = customerDao.find(customer_id);
		req.setAttribute("customer", customer);		
		return "f:user/alterCustomer.jsp";
	}
	
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp){
		
		List<Customer> listCustomer = customerDao.findAll();
		req.setAttribute("listCustomer", listCustomer);
		return "f:user/customerlist.jsp";
	}
	
	public String alter(HttpServletRequest req, HttpServletResponse resp){
		String[] keys = "customer_id,name,address,phonenumber".split(",");
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:user/alterCustomer.jsp";
		}
		Customer customer = new Customer();
		customer.setId(params.get("customer_id"));
		customer.setAddress(params.get("address"));
		customer.setName(params.get("name"));
		customer.setPhonenumber(params.get("phonenumber"));
		String res = customerDao.alter(customer);
		req.setAttribute("result", res);
		return "f:user/message.jsp";
	}	
	
	
	public String vaguefind(HttpServletRequest req, HttpServletResponse resp){
	
		String[] keys = "way,searchContent".split(",");
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:/user/customerlist.jsp";
		}
		
		List<Customer> listCustomer = customerDao.vaguefind(params.get("way"),params.get("searchContent"));
		
		req.setAttribute("listCustomer", listCustomer);
		return "f:/user/customerlist.jsp";
	}
}
