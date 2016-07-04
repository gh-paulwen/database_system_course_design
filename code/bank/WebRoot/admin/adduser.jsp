<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
    
    <title>添加用户</title>
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
  	<h2>添加用户</h2>
  	<form action="${pageContext.request.contextPath }/UserServlet" method="post">
  		<div style="width:30%;text-align:center;margin:auto">  	
  			<div class="row">
  				<input class="form-control col-xs-6" placeholder="用户名" type="text" name="userid">
  				<h4 class="text-danger col-xs-6">${errors.userid }</h4>
  			</div>
  			<div class="row">
  				<input class="form-control col-xs-6" type="password" name="password" placeholder="密码">
  				<h4 class="text-danger col-xs-6">${errors.password} </h4>
  			</div>
  			<div>
		  		<select name="power" class="col-xs-6 form-control">
		  			<option value="0">普通用户</option>
		  			<option value="1">管理员</option>		  			
		  		</select>
		  		<h4>${errors.power }</h4>
  			</div>
  		<input class="btn btn-primary form-control" style="margin-top : 10px;" type="submit" value="添加" ><br>
  		<input type="hidden" name="method" value="add">
  		</div>
  	</form>
    </div>
  </body>
</html>
