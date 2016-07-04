<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
  <head>
        
    <title>顾客列表</title>
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
  		<form action="${pageContext.request.contextPath }/CustomerServlet" method="POST">
  		<input type="hidden" name="method" value="vaguefind">  		
  		<table class="table" style="width:40%;" >
  			<tr>
  			<td><select name="way">
  				<option value="id">身份证</option>
  				<option value="name">姓名</option>
  			</select></td>
  			<td><input type="text" class="" name="searchContent" placeholder="输入查找内容"></td>
  			<td><input type="submit" class="btn btn-primary" value="搜索"></td>
  			
  			</tr>
  		</table>
  		</form>
  		
	 	<table class="table">
	  		<thead>
	  			<tr>
	  				<th>编号</th>
	  				<th>身份证号</th>
	  				<th>姓名</th>
	  				<th>地址</th>
	  				<th>电话</th>
	  				<th>操作</th>
	  			</tr>
	  		</thead>
	  		<tbody>
	    		<c:forEach items="${listCustomer }" var="cust" varStatus="vs">
	    			<tr>
	    				<td>${vs.index }</td>
	    				<td>${cust.id }</td>
	    				<td>${cust.name }</td>
	    				<td>${cust.address }</td>
	    				<td>${cust.phonenumber }</td>
	    				<td><a href="${pageContext.request.contextPath }/CustomerServlet?method=find&customer_id=${cust.id}">编辑</a></td>
	    			</tr>
	    		</c:forEach>
	    	</tbody>
	    </table>
    </div>
  </body>
</html>
