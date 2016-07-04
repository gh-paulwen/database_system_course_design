<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
        
    <title>添加账号</title>
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
  	<h2>${result }</h2>  	
  	<div class="row">
  	<div class="col-xs-6">
  	<form action="${pageContext.request.contextPath }/AccountServlet" method="post">
  	<input type="hidden" name="method" value="add">  		
  		<table class="table">
	  		<tr>
	  			<td>用户身份证号：</td>
	  			<td><input class="form-control" type="text" name="customer_id"></td>
	  			<td>${errors.customer_id }</td>
	  		</tr>
	  		<tr>
	  			<td>用户姓名：</td>
	  			<td><input class="form-control" type="text" name="address"></td>
	  			<td>${errors.address }</td>
	  		</tr>   
	  		
	  		<tr>
	  			<td>用户地址：</td>
	  			<td><input class="form-control" type="text" name="customer_name"></td>
	  			<td>${errors.customer_name }</td>
	  		</tr>
	  		<tr>
	  			<td>用户电话号码：</td>
	  			<td><input class="form-control" type="text" name="phonenumber"></td>
	  			<td>${errors.phonenumber }</td>
	  		</tr>
	  		<tr>
	  			<td>密码：</td>
	  			<td><input class="form-control" type="password" name="password"></td>
	  			<td>${errors.password }</td>
	  		</tr>
	  		<tr>
	  			<td>确认密码：</td>
	  			<td><input class="form-control" type="password" name="verifypassword"></td>
	  			<td>${errors.verifypassword }</td>
	  		</tr>
	  		<tr>
	  			<td>账户类型：</td>
	  			<td>
	  			<select name="type">
  					<option value="1">存折</option>
  					<option value="2">银行卡</option>
  				</select></td>
	  			<td>${errors.type }</td>
	  		</tr>
	  	<tr>
	  		<td></td>
	  		<td><input class="btn btn-primary" type="submit" value="添加"></td>
	  		<td></td>
	  		
	  	</tr>
  		</table>
  		
  	</form>
  	</div>
  	<div class="col-xs-6">
  		<img class="img-responsive" src="${pageContext.request.contextPath }/img/bank.jpg">
  	</div>
    
    
    </div>
    </div>
  </body>
</html>
