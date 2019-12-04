<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resource/mystyles.css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript">
 
 
 //
   /*  function add(){
	 

     $.post("/add",$("#form1").serialize(),function(flag){
    	 if(flag){
    		 alert("保存成功");
    		 location.href="/selects"
    	 }else{
    		 alert("保存失败")
    	 }
    	 
     })
	 } */

 
 
 
</script>

</head>
<body>
	<form id="form1" method="post" action="/add">
		店面名称: <input type="text" name="name"> <br> 创建日期:<input
			type="date" name="created"> <br> 商品:
		<c:forEach items="${goods }" var="g">
			<input type="checkbox" name="gids" value="${g.id }">${g.name }
     </c:forEach>
		<br> <input type="submit" value="增加" onclick="add()">
	</form>

</body>
</html>