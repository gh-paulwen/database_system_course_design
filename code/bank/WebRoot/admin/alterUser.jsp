<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
        
    <title>修改用户</title>
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
  	<form action="${pageContext.request.contextPath }/UserServlet" method="post">
  	<input type="hidden" name="method" value="alter">
  	<input type="hidden" name="userid" value="${user.id }">  		
  		<table class="table">
	  		<tr>
	  			<td>用户id</td>
	  			<td>${user.id }</td>	  			
	  		</tr>
	  		<tr>
	  			<td>用户密码：</td>
	  			<td><input class="form-control" type="text" name="password"></td>
	  			<td>${errors.password }</td>
	  		</tr>
	  		<tr>
	  			<td>权限：</td>
	  			<td>
	  				<select name="power" class="col-xs-6 form-control">
			  			<option value="0">普通用户</option>
			  			<option value="1">管理员</option>		  			
		  			</select>
	  			</td>
	  			<td>${errors.power}</td>
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
