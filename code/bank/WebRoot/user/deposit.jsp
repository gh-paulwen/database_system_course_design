<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        
    <title>存款</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%@ include file="../top.jsp" %>
    <div class="container">
    	<div class="col-xs-6">
    		<h3>定期存款</h3>    		
    		<form action="${pageContext.request.contextPath }/FixeddepositServlet" method="POST">
    			<input type="hidden" name="method" value="add">
    			<table class="table">
    				<tr>
    					<td>账号</td>
    					<td><input class="form-control" type="text" name="account_id"></td>
    					<td>${errors.account_id }</td>
    				</tr>
    				<tr>
    					<td>金额</td>
    					<td><input class="form-control" type="text" name="money"></td>
    					<td>${errors.money }</td>
    				</tr>
    				<tr>
    					<td>限期(月)</td>
    					<td><select name="months">
    					<c:forEach items="${monthss }" var="month" >
    						<option value="${month.value }">${month.key }</option>
    					</c:forEach>
    					</select></td>
    					<td>${errors.months }</td>
    				</tr>    				
    				<tr>
    					<td></td>
    					<td colspan="2"><input class="btn btn-primary" type="submit" value="存款"></td>
    				</tr>
    			</table>
    		</form>
    	</div>
    	<div class="col-xs-6">
    		<h3>活期存款</h3>
    		<form action="${pageContext.request.contextPath }/AccountServlet" method="POST">
    			<input type="hidden" name="method" value="depositfree">
    			<table class="table">    				
    				<tr>
    					<td>账号</td>
    					<td><input class="form-control" type="text" name="account_id"></td>
    					<td>${errors.account_id }</td>
    				</tr>
    				<tr>
    					<td>金额</td>
    					<td><input class="form-control" type="text" name="money"></td>
    					<td>${errors.money }</td>
    				</tr>    				
    				<tr>
    					<td></td>
    					<td colspan="2"><input class="btn btn-primary" type="submit" value="存款"></td>
    				</tr>
    			</table>
    		</form>
    	</div>
    	
    	</div>
    
    
  </body>
</html>
