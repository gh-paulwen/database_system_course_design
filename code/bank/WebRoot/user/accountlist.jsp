<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        
    <title>账户列表</title>
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
  				<th>账户号</th>
  				<th>身份证号</th>
  				<th>活期余额</th>
  				<th>定期余额</th>
  				<th>账户类型</th>
  				<th>开户日期</th>
  			</tr>
  		</thead>
  		<tbody>
    		<c:forEach items="${listAccount }" var="acc" varStatus="vs">
    			<tr>
    				<td>${vs.index }</td>
    				<td>${acc.id }</td>
    				<td>${acc.cust_id }</td>
    				<td>${acc.free }</td>
    				<td>${acc.fixed }</td>
    				<td>${acc.typename }</td>
    				<td><fmt:formatDate value="${acc.createdate}" pattern="yyyy年MM月dd日HH点mm分ss秒" /> </td>    			
    			</tr>
    		</c:forEach>    		
    	</tbody>    	
    </table>
    </div>
  </body>
</html>
