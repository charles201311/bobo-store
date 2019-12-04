<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>

<link rel="stylesheet" href="/resource/mystyles.css">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$.get("/selectGoods", function(list) {
			for ( var i in list) {
				$("#mdiv").append(
						"<input type='checkbox' name='gids' value='"+list[i].id+"' >"
								+ list[i].name + "")
			}

			//让复选框选中
			//条件
			var params = '${str}';//

			var str = params.split(",");

			for ( var j in str) {
				$("[name='gids'][value='" + str[j] + "']")
						.prop("checked", true)
			}

		})

	})
	//去增加
	function add() {
		location.href = "/add";
	}

	function chkAll(flag) {
		if (flag == 0) {//全选

			$("[name='ck']").each(function() {
				$(this).prop("checked", true)
			})
		} else if (flag == 1) {//反向选
			$("[name='ck']").each(function() {
				$(this).prop("checked", !$(this).prop("checked"))
			})

		} else {
			$("[name='ck']").each(function() {
				$(this).prop("checked", false)
			})
		}

	}
	function deleteBatch() {
		var ids = new Array();
		$("[name='ck']:checked").each(function(i) {
			ids[i] = $(this).val();
		})
		if (ids.length == 0) {
			alert("至少选中一个")
			return;
		}
		var ret = confirm("确定删除吗?")
		if (ret) {

			$.post("/deleteBatch", {
				ids : ids
			}, function(flag) {
				if (flag) {
					alert("删除成功")
				} else {
					alert("删除失败")
				}
			})

		}
	}
</script>
</head>
<body>
	<form action="/selects" method="post">
		<div id="mdiv"></div>
		商品名称:<input name="sname" type="text" value="${sname }">
		<button type="submit">查询</button>
		<button type="button" onclick="add()">增加</button>

		<button type="button" onclick="deleteBatch()">批量删除</button>
	</form>
	<table>
		<tr>

			<td><input type="checkbox" onclick="chkAll(0)">全选 <input
				type="checkbox" onclick="chkAll(1)">反选 <input
				type="checkbox" onclick="chkAll(-1)">全不选</td>

			<td>序号</td>
			<td>名称</td>
			<td>创建日期</td>
			<td>商品名称</td>
			<td>操作</td>

		</tr>

		<c:forEach items="${info.list}" var="s" varStatus="i">
			<tr>
				<td><input type="checkbox" name="ck" value="${s.id}"></td>
				<td>${i.index+1 }</td>
				<td>${s.name }</td>
				<td>${s.created }</td>
				<td>${s.gname }</td>
				<td><a href="/select?sid=${s.id}" target="_blank">详情</td>
			</tr>


		</c:forEach>



		<tr>
			<td colspan="5"><button type="button" class="btn btn-primary"
					name="pageNum" value="1">首页</button>
				<button type="button" class="btn btn-primary" name="pageNum"
					value="${info.prePage==0?1:info.prePage}">上一页</button>
				<button type="button" class="btn btn-primary" name="pageNum"
					value="${info.nextPage==0?info.pages:info.nextPage}">下一页</button>
				<button type="button" class="btn btn-primary" name="pageNum"
					value="${info.pages}">尾页</button></td>
		</tr>

	</table>


</body>
</html>