<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
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
  	<div class="row">
  	<div class="col-xs-6">
  	<form action="${pageContext.request.contextPath }/CustomerServlet" method="post">
  	<input type="hidden" name="method" value="alter">
  	<input type="hidden" name="customer_id" value="${customer.id }">  		
  		<table class="table">
	  		<tr>
	  			<td>用户身份证号：</td>
	  			<td>${customer.id }</td>	  			
	  		</tr>
	  		<tr>
	  			<td>用户姓名：</td>
	  			<td><input class="form-control" type="text" name="name" placeholder="${customer.name }"></td>
	  			<td>${errors.name }</td>
	  		</tr>   
	  		
	  		<tr>
	  			<td>用户地址：</td>
	  			<td><input class="form-control" type="text" name="address" placeholder="${customer.address }"></td>
	  			<td>${errors.address }</td>
	  		</tr>
	  		<tr>
	  			<td>用户电话号码：</td>
	  			<td><input class="form-control" type="text" name="phonenumber" placeholder="${customer.phonenumber} "></td>
	  			<td>${errors.phonenumber }</td>
	  		</tr>
	  		
	  	<tr>
	  		<td></td>
	  		<td><input class="btn btn-primary" type="submit" value="确认修改"></td>
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
