<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>注册表单</title>
  </head>
  
  <body style="text-align:center;">
    <h1>注册</h1>
    <div><font style="color: red"><c:if test="${message!=null}">${message}</c:if></font></div>
  	<form action="${pageContext.request.contextPath}/RegisterServlet" method="post">
    	用户名：<input type="text" name="username"><br/>
    	密码：<input type="password" name="password"><br/>
    	电话：<input type="text" name="phone"><br/>
    	手机：<input type="text" name="cellphone"><br/>
    	邮箱：<input type="text" name="email"><br/>
    	住址：<input type="text" name="address"><br/>
    	<input type="submit" value="注册">
    </form>
  </body>
</html>
