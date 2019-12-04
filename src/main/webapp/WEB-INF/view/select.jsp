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

</head>
<body>
	<br>

	<table>
		<tr>
			<td>编号:${shop.id }</td>
		</tr>
		<tr>
			<td>名称:${shop.name }</td>
		</tr>
		<tr>
			<td>日期:${shop.created }</td>
		</tr>
		<tr>
			<td>商品:${shop.gname }</td>
		</tr>
		<tr>
			<td><a href="/selects">返回</a> </td>
		</tr>



	</table>
</body>
</html>