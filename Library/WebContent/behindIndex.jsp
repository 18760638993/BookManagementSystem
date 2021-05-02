<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>主页</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/index.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/lbt.css" />
<script src="http://localhost:8080/Library/style/js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
<script src="http://localhost:8080/Library/style/js/blt.js" type="text/javascript" charset="utf-8"></script>
<script src="http://localhost:8080/Library/style/js/index.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!--头部开始-->
		
		<jsp:include page="header.jsp"/>
		
		<!--main开始-->
	<div class="main">
		<div class="m-left">
			<nav class="navbar  navbar-dark" style="padding:0;">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="javascript:;" onclick="jumptoBehindIndex()">图书管理</a></li>
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptoUserList()">读者管理</a></li>

					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobookcase()">书架管理</a></li>
				    <li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobooktype()">类型管理</a></li>
				    <li class="nav-item"><a class="nav-link" href="javascript:;" onclick="jumpTomyInfo()">个人信息</a></li>
				</ul>
			</nav>

		</div>
		<div class="m-right">
			<div class="text-right">
				<button class="btn btn-primary" onclick="AddBook()">新增图书</button>
			</div>
			<div>
				<label for="exampleInputPassword1">书籍类型：</label> <select class="form-control" id="typeList">

				</select>
				<table id="bookList" class="table table-bordered" >

					<tr>
						<td>编号</td>
						<td>书名</td>
						<td>类型</td>
						<td>作者</td>
						<td>操作</td>
					</tr>
				</table>
				

			</div>
			<div>
			<nav aria-label="..." class="text-center" style="margin-top:50px">
					<input type="hidden" id="pageIndex"> 
					<input type="hidden" id="pageTotal">
					<ul class="pager">

						<li id="up"><a href="javascript:;" onclick="previous()">上一页</a></li>
						<li id="down"><a href="javascript:;" onclick="next()">下一页</a></li>
					</ul>
				</nav>
				</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"/>
			
			
</body>
</html>
