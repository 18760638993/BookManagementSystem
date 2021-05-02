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
<script src="http://localhost:8080/Library/style/js/updateBook.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<!--头部开始-->
		
		<jsp:include page="header.jsp"/>
		
		<!--main开始-->
	<div class="main">
		<div class="m-left">
			<nav class="navbar  navbar-dark" style="padding: 0;">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="javascript:;" onclick="jumptoBehindIndex()">图书管理</a></li>
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptoUserList()">读者管理</a></li>
					
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobookcase()">书架管理</a></li>
				    <li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobooktype()">类型管理</a></li>
				    <li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumpTomyInfo()">个人信息</a></li>
				</ul>
			</nav>
		</div>
		<div class="m-right">
             <input type="hidden" value="${book.url }" id="imgurl">
			<form id="myForm" name="myForm">
			<input type="hidden" name="id" value="${book.bid}" id="id">
				<div class="form-group">
					<label for="exampleInputEmail1">书名</label> <input
						type="text" class="form-control" id="name" name="name"
						value="${book.bookname }">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">图像</label> 
					<input type="file" class="form-control" id="img" >
					<img id="imgbase64" src="${book.url }" style="width:300px;height:auto;margin-top:10px">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">作者</label> <input
						type="text" class="form-control" id="author" name="author"
						value="${book.author }">
				</div>
				<input type="hidden" value="${book.bookTypeId }" id="bookTypeId">
				<input type="hidden" value="${book.bookCaseId }" id="bookCaseId">
				<div class="form-group">
					<label for="exampleInputPassword1">类型</label> <select class="form-control" id="bookType" name="bookType">
					</select>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">所在书架</label> <select class="form-control" id="bookCase" name="bookCase">
					</select>
				</div>
				
				
			</form>
			<div style="margin-left:200px">
<button type="button" onclick="updateBook()" class="btn btn-primary ">修改图书</button></div>
		</div>
	</div>

	

	<jsp:include page="footer.jsp"/>
			
			
</body>
</html>
