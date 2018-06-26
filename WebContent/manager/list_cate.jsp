<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看分类</title>
</head>
<body style="text-align: center;">
<h1>分类信息</h1>
<table width="50%" border="1px" align="center">
  <tbody>
    <tr style="text-align: center;">
      <td>分类名称</td>
      <td>分类描述</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${list }" var="cate">
      <tr>
	      <td>${cate.name}</td>
	      <td>${cate.description }</td>
	      <td><a href="${pageContext.request.contextPath}/CategoryServlet?method=del?id=${cate.id}">删除</a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>