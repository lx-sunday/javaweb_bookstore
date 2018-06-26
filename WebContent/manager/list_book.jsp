<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看图书信息</title>
</head>
<body style="text-align: center;">
	<h1>图书信息</h1>
	<table width="50%" border="1px" align="center">
	  <tbody>
	    <tr style="text-align: center;">
	      <td>图书名称</td>
	      <td>作者</td>
	      <td>价格</td>
	      <td>图片</td>
	      <td>描述</td>
	      <td>操作</td>
	    </tr>
	    <c:forEach items="${page.list}" var="book">
	      <tr>
		      <td>${book.name}</td>
		      <td>${book.author }</td>
		      <td>${book.price}</td>
		      <td><a href="${book.image}">查看图片</a></td>
		      <td>${book.description}</td>
		      <td><a href="${pageContext.request.contextPath}/BookServlet?method=del?id=${book.id}">删除</a></td>
	      </tr>
	    </c:forEach>
	  </tbody>
	</table>
	<br>
	<div>当前第[${page.pagenum}]页 &nbsp;&nbsp;
	 <c:forEach begin="${page.startpage}"  end="${page.endpage}" var="pageNum">
	    [<a href="${pageContext.request.contextPath}/BookServlet?method=list&pagenum=${pageNum}">${pageNum }</a>]
	 </c:forEach>
	 ,共[${page.totalrecord}]
	</div>
</body>
</html>