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
  <script src="http://localhost:8080/Library/style/js/userBookInfo.js" type="text/javascript" charset="utf-8"></script> 
</head>
<body>
<!--头部开始-->
		
		<jsp:include page="header.jsp"/>
		
		<!--main开始-->
	<div class="main">
		<div class="m-left">
			<nav class="navbar  navbar-dark" style="padding:0;">
				<ul class="navbar-nav">
					<li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumptoBehindIndex()">图书管理</a></li>
					<li class="nav-item active" ><a class="nav-link" href="javascript:;" onclick="jumptoUserList()">读者管理</a></li>
					
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobookcase()">书架管理</a></li>
				    <li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptobooktype()">类型管理</a></li>
				    <li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumpTomyInfo()">个人信息</a></li>
				</ul>
			</nav>

		</div>
		<div class="m-right">
			<div class="text-left">
				<div class="text-right"><a href="javascript:;" onclick="back()">返回</a></div>
				<table id="bookList" class="table table-bordered">

					<tr>
						<td>编号</td>
						<td>书名</td>
						
						<td>作者</td>
						<td>类型</td>
						<td>借阅状态</td>
					</tr>
					<c:forEach var="userbook" items="${page.list }" varStatus="s">
					<tr>
						<td>${s.index+1 }</td>
						<td>${userbook.book.bookname }</td>
						<td>${userbook.book.author }</td>
						<td>${userbook.book.bookType }</td>
						<c:if test="${userbook.state==1 }"><td>在借</td></c:if>
						<c:if test="${userbook.state==0 }"><td>已还</td></c:if>
						
					</tr>
					</c:forEach>
				</table>
				<nav aria-label="..." class="text-center">
					<input type="hidden" id="pageIndex" value="${page.page }"> 
					<input type="hidden" id="pageTotal" value="${page.totalPage }">
					<ul class="pager">

				<c:if test="${page.page!=1 }">	<li id="up"><a href="javascript:;" onclick="up()">上一页</a></li></c:if>
					<c:if test="${page.totalPage!=page.page }">	<li id="down"><a href="javascript:;" onclick="down()">下一页</a></li></c:if>
					</ul>
				</nav>

			</div>
			
		</div>

	</div>
	

	<jsp:include page="footer.jsp"/>
			
	
</body>
</html>
