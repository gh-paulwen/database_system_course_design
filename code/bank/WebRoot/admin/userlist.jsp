<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        
    <title>用户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
		.table th {
			text-align : center;
		}
		.table td {
			text-align : center;
		}
	</style>
  </head>
  
  <body>
  	<%@ include file="../top.jsp" %>
  	<div class="container">
  	<table class="table">
  		<thead>
  			<tr>
  				<th>编号</th>
  				<th>用户id</th>
  				<th>密码</th>
  				<th>权限</th>
  				<th>操作</th>
  			</tr>
  		</thead>
  		<tbody>
    		<c:forEach items="${listUser }" var="user" varStatus="status">
    			<tr>
    				<td>${status.index }</td>
    				<td>${user.id }</td>
    				<td>${user.password }</td>
    				<td>${user.powername }</td>
    				<td><div class="row">
    					<div class="col-xs-3"></div>
    					<a class="col-xs-3" href="${pageContext.request.contextPath }/UserServlet?method=find&userid=${user.id}">修改</a>
    					<a class="col-xs-3" href="${pageContext.request.contextPath }/UserServlet?method=delete&userid=${user.id}">删除</a>
    					<div class="col-xs-3"></div>
    				</div></td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    </div>
  </body>
</html>
