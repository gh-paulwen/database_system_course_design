<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        
    <title>定期存单列表</title>
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
  				<th>存单号</th>
  				<th>账户号</th>
  				<th>金额</th>
  				<th>开始日期</th>
  				<th>期限(月)</th>
  				<th>利率</th>
  				<th>状态</th>
  			</tr>
  		</thead>
  		<tbody>
    		<c:forEach items="${listDeposit }" var="deposit" varStatus="vs">
    			<tr>
    				<td>${vs.index }</td>
    				<td>${deposit.id }</td>
    				<td>${deposit.account_id }</td>
    				<td>${deposit.money }</td>
    				<td><fmt:formatDate value="${deposit.begindate}" pattern="yyyy年MM月dd日HH点mm分ss秒" /> </td>
    				<td>${deposit.months }</td>
    				<td>${deposit.bonusrate }</td>
    				<td>${deposit.status_name }</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    </div>
  </body>
</html>
