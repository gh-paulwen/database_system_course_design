package paul.bank.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paul.bank.dao.FixeddepositDao;
import paul.bank.entity.Fixeddeposit;
import paul.bank.tools.CommonUtils;

public class FixeddepositServlet extends BaseServlet {
	
	private FixeddepositDao dao = FixeddepositDao.getInstance();
	
	public String add(HttpServletRequest req, HttpServletResponse resp){
		
		String[] keys = "account_id,money,months".split(",");
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		params.put("deposit_id", dao.generateid());
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:user/addfixeddeposit.jsp";
		}
		Fixeddeposit deposit = new Fixeddeposit();
		deposit.setId(params.get("deposit_id"));
		deposit.setAccount_id(params.get("account_id"));
		deposit.setMoney(Double.parseDouble(params.get("money")));
		deposit.setMonths(Integer.parseInt(params.get("months")));		
		String res = dao.add(deposit);
		req.setAttribute("result", res);
		return "f:user/message.jsp";
	}	
	
	public String withdrawfixed(HttpServletRequest req, HttpServletResponse resp){
		String[] keys = "customer_id,deposit_id,password,money".split(",");		
		Map<String,String> params = ServletUtil.getParameters(req, keys);
		Map<String,String> errors = new HashMap<String,String>();
		boolean normal = CommonUtils.multinotnull(params, errors);
		if(!normal){
			req.setAttribute("errors", errors);
			return "f:user/withdrawfixed.jsp";
		}
		
		String res =dao.withdrowfixed(params.get("customer_id"), 
				params.get("deposit_id"), 
				Double.parseDouble(params.get("money")),
				CommonUtils.md5(params.get("password")));
		req.setAttribute("result", res);
		return "f:user/message.jsp";
	}

	
	//TODO
	public String find(HttpServletRequest req, HttpServletResponse resp){
		return "";
	}
	
	
	public String findAll(HttpServletRequest req, HttpServletResponse resp){
		List<Fixeddeposit> listDeposit = dao.findAll();
		req.setAttribute("listDeposit", listDeposit);
		return "f:user/fixeddepositlist.jsp";
	}
	
	public String getMonths(HttpServletRequest req, HttpServletResponse resp){
		Map<String,Integer> months = dao.getMonths();			
		req.setAttribute("monthss", months);			
		return "f:user/deposit.jsp";
	}
}
