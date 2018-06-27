<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
   <body style="text-align: center;">
      <div>欢迎你，${user.username}~<a href="${pageContext.request.contextPath}/manager/index.jsp">跳转后台</a>~<a href="${pageContext.request.contextPath}/LoginOutServlet">注销</a></div>
   </body>
</html>