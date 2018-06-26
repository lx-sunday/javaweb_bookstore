<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>栏目导航栏</title>
<style type="text/css">
   ul > li{
   margin-bottom: 20px;
  }
  ul > li > div{
    margin-left:20px;
    display: none;
  }
</style>
<script type="text/javascript">
   function showOrHide(e){
	  var target= document.getElementById(e);
	  target.style.display=target.style.display=='block'?'none':'block';
   }
</script>
</head>
<body>
  <ul>
    <li>
       <a href="#" onclick="showOrHide('category')">分类管理</a>
        <div id="category" >
         <a href="${pageContext.request.contextPath}/manager/add_cate.jsp" target="right">添加分类</a><br/>
         <a href="${pageContext.request.contextPath}/CategoryServlet?method=list" target="right">查看分类</a>
      </div>
    </li>
     
    <li>
      <a href="#" onclick="showOrHide('library')">图书管理</a>
       <div id="library" >
         <a href="${pageContext.request.contextPath}/BookServlet?method=add" target="right">添加图书</a><br>
         <a href="${pageContext.request.contextPath}/BookServlet?method=list" target="right">查看图书</a>
      </div>
    </li>
     
  </ul>
</body>
</html>