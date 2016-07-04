<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
        
    <title>首页</title>
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
    <%@include file="top.jsp" %>
    <div class="container" style="margin-top : 20px">
    	<div class="row">
    	<div class="col-xs-6">
    		<img class="img-responsive" src="${pageContext.request.contextPath }/img/bank.jpg">
    	</div>
    	<div class="col-xs-6">    	
    	<%if(session.getAttribute("currentuser")==null){ %>
    	    <div class="row">
    	    	<div class="col-xs-4"></div>
    	    	<div class="col-xs-8">
	    			<form action="${pageContext.request.contextPath }/UserServlet" method="POST">
	    		<input type="hidden" name="method" value="login">
	    		
	    		<table width="50%" id="table" class="table">
	    			<thead>
	    				<tr>
	    					<th colspan="3"><h2 class="text-center">用户登录</h2></th>
	    				</tr>
	    			</thead>
	    			<tbody>
	    				<tr>
	    					<td><p class="text-center">用户id</p></td>
	    					<td><input class="form-control" type="text" name="userid"></td>
	    					<td>${errors.userid }</td>
	    				</tr>
	    				<tr>
	    					<td>密码</td>
	    					<td><input class="form-control" type="password" name="password"></td>
	    					<td>${errors.password }</td>
	    				</tr>
	    				<tr>
	    					<td colspan="3"><input class="form-control btn btn-primary" type="submit" name="登录"></td>    					
	    				</tr>
	    			</tbody>
	    		</table>
	    	</form>  
	    	</div>  			
    		</div>
    		
    		<%} %>
    			
    		
    	</div>
    	</div>
    
    </div>
    
  </body>
</html>
