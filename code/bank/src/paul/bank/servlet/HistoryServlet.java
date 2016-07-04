package paul.bank.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paul.bank.dao.HistoryDao;
import paul.bank.entity.History;

public class HistoryServlet extends BaseServlet {

	private HistoryDao dao = HistoryDao.getInstance();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response){
		List<History> listHistory = dao.findAll();		
		request.setAttribute("listHistory", listHistory);		
		return "f:user/historylist.jsp";
	}

}
