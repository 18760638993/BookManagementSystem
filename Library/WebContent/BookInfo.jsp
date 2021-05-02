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
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/myindex.css" />
<script src="http://localhost:8080/Library/style/js/jquery-1.9.1.js" type="text/javascript" ></script>
<script src="http://localhost:8080/Library/style/js/blt.js" type="text/javascript" ></script>
<script src="http://localhost:8080/Library/style/js/indexShow.js" type="text/javascript" ></script> 
<style type="text/css">
.bookname{
  
  margin-top:20px;
  text-align:left;
  
}
</style>
</head>
<body>
<!--头部开始-->
		
		<jsp:include page="header.jsp"/>
		
		<!--main开始-->
	<div class="main">
		<div class="m-left">
			<nav class="navbar  navbar-dark" style="padding:0;">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="javascript:;" onclick="jumptoIndex()">首页</a></li>
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptoMyBook()">我的借阅</a></li>
					<li class="nav-item"><a class="nav-link" href="javascript:;" onclick="jumpToMyInfo()">个人信息</a></li>
				</ul>
			</nav>

		</div>
		<div class="m-right">
			
			<div class="text-right"><a href="javascript:;" onclick="back()">返回上一页</a></div>
				
		    <div class="bookItem">
				<div class="bookimg"> 
					<img src="${book.url}">
				</div> 
				
				
				</div>  
		  
		  <div class="bookInfo">
		  <div class="bookname "> 
					<span>书名:《<span class="bookname-value" >${book.bookname}</span>》</span> 
				</div> 
		  <div class="bookname"> 
					<span class="bookname-value">所属类型:${book.bookType }</span>
				</div> 
				<div class="bookname"> 
			<span class="bookname-value">所在书架:${book.bookCase }</span>
				</div> 
				<div class="bookname"> 
				<span class="bookname-value">作者:${book.author }</span>
				</div>
					
				<div  onclick="borrowBook(${book.bid})" class="borrow"> 
					<span>借阅</span> 
				

			</div>
			
		</div>
		</div>
		</div>

	
	<jsp:include page="footer.jsp"/>
			
			
</body>
</html>
