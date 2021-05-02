<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>主页</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/index.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/AddBook.css" />
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/lbt.css" />
<script src="http://localhost:8080/Library/style/js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
<script src="http://localhost:8080/Library/style/js/blt.js" type="text/javascript" charset="utf-8"></script>
<script src="http://localhost:8080/Library/style/js/addType.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!--头部开始-->
		
		<jsp:include page="header.jsp"/>
		
		<!--main开始-->
	<div class="main">
		<div class="m-left">
			<nav class="navbar  navbar-dark" style="padding: 0;">
				<ul class="navbar-nav">
					<li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumptoBehindIndex()">图书管理</a></li>
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptoUserList()">读者管理</a></li>
					
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobookcase()">书架管理</a></li>
				    <li class="nav-item active" ><a class="nav-link" href="javascript:;" onclick="jumptobooktype()">类型管理</a></li>
				    <li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumpTomyInfo()">个人信息</a></li>
				</ul>
			</nav>
		</div>
		<div class="m-right">

			<form id="myForm" name="myForm">
			
				<div class="form-group">
					<label for="exampleInputEmail1">类型名</label> <input
						type="text" class="form-control" id="name" name="name"
						placeholder="请输入类型">
				</div>
				
				
				
				
				
			</form>
     <button class="btn btn-primary" onclick="addType()">添加类型</button>
		</div>
	</div>

	

	<jsp:include page="footer.jsp"/>
			
			
</body>
</html>
