<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
   <body style="text-align: center;">
      <h1>登录</h1>
      <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
      <div><font style="color: red"><c:if test="${message!=null}">${message}</c:if></font></div>
         <table align="center">
             <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" /></td>
             </tr>
             <tr>
               <td>密码：</td>
               <td><input type="password" name="password" /></td>
             </tr>
             <tr>
                <td colspan="2">
                  <input type="submit" value="登录" />
                  <span style="margin-left: 10px;"><a href="${pageContext.request.contextPath}/register.jsp">注册</a></span>
                </td>
             </tr>
         </table>
      </form>
   </body>
</html>