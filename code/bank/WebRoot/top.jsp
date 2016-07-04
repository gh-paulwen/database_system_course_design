
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
	
  
  <head><link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.css"></head>

  	<div class="container">
  		<div class="row">
  		<% if(session.getAttribute("currentuser")!=null) {%>  		  			
  			<h3 class="col-xs-6">当前用户:${sessionScope.currentuser.id },<a href="${pageContext.request.contextPath }/UserServlet?method=logout">注销</a></h3>
  		<%}else{ %>
  			<div class="col-xs-6"></div>
  		<%} %>
  			<div class="col-xs-6">
  				<h1 class="text-danger text-right">仲恺农业银行(ABK)</h1>
  				<h3 class="text-right" style="font-style:italic;align:right;">Agricultural Bank of Kai</h3>
  			</div>
  		</div>    
    	
    	<ul class="nav nav-tabs">
    		<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
    		<li><a href="${pageContext.request.contextPath }/CustomerServlet?method=findAll">客户信息</a></li>
    		<li><a href="${pageContext.request.contextPath }/AccountServlet?method=findAll">账户管理</a></li>
    		<li><a href="${pageContext.request.contextPath }/user/addAccount.jsp">开户</a></li>
    		<li><a href="${pageContext.request.contextPath }/FixeddepositServlet?method=findAll">存单管理</a></li>
    		<li><a href="${pageContext.request.contextPath }/FixeddepositServlet?method=getMonths">存款</a></li>
    		<li><a href="${pageContext.request.contextPath }/user/withdraw.jsp">取款</a></li>
    		<li><a href="${pageContext.request.contextPath }/HistoryServlet?method=findAll">历史记录</a></li>
    		<li><a href="${pageContext.request.contextPath }/UserServlet?method=findAll">用户管理</a></li>
    		<li><a href="${pageContext.request.contextPath }/admin/adduser.jsp">添加用户</a></li>
    	</ul>    
    </div>
