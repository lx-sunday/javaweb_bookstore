<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加分类</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/CategoryServlet?method=add" method="post">
	  <table>
	    <tr>
	      <td>分类名称:</td>
	      <td><input type="text" name="name" /></td>
	    </tr>
	    <tr>
	      <td> 分类描述:</td>
	      <td><textarea rows="4" cols="40" name="description"></textarea></td>
	    </tr>
	    <tr>
	      <td colspan="2"> <input type="submit" name="submit" value="添加" /></td>
	    </tr>
	  </table>
  </form>
</body>
</html>