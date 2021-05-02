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
<script src="http://localhost:8080/Library/style/js/jquery-1.9.1.js" type="text/javascript" ></script>
<script src="http://localhost:8080/Library/style/js/blt.js" type="text/javascript" ></script>
<script type="text/javascript" src="http://localhost:8080/Library/style/js/myBook.js"></script>
</head>
<body>
<!--头部开始-->
		
		<jsp:include page="header.jsp"/>
		
		<!--main开始-->
	<div class="main">
		<div class="m-left">
			<nav class="navbar  navbar-dark" style="padding:0;">
				<ul class="navbar-nav">
					<li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumptoIndex()">首页</a></li>
					<li class="nav-item active" ><a class="nav-link" href="javascript:;" onclick="jumptoMyBook()">我的借阅</a></li>
					<li class="nav-item"><a class="nav-link" href="javascript:;" onclick="jumpToMyInfo()">个人信息</a></li>
				</ul>
			</nav>

		</div>
		<div class="m-right">
			<div class="text-left">
			<input type="hidden" value="${bookstate }" id="bookstate">
				
				<label for="exampleInputPassword1">是否归还：</label> <select class="form-control" id="state">
                  <option value="2">选择性选择</option>
                  <option value="1">在借</option>
                  <option value="0">已还</option>            
				</select>
				<table id="bookList" class="table table-bordered">

					<tr>
						<td>编号</td>
						<td>书名</td>
						
						<td>作者</td>
						<td>类型</td>
						<td>借书时间</td>
						<td>还书时间</td>
						<td>操作</td>
					</tr>
					<c:forEach var="userbook" items="${pageBean.list}" varStatus="s">
					<tr>
						<td>${s.index+1 }</td>
						<td>${userbook.book.bookname }</td>
						<td>${userbook.book.author }</td>
						<td>${userbook.book.bookType }</td>
						<td>${userbook.borrowTime }</td>
						<td>${userbook.recieveTime }</td>
						<c:if test="${userbook.state==1 }">
						<td><button class="btn btn-success" onclick="recieveBook(${userbook.id},${userbook.book.bid })">还书</button></td>
					    </c:if>
					    <c:if test="${userbook.state==0 }">
						<td><button class="btn btn-danger" >已还书</button></td>
					    </c:if>
					</tr>
					</c:forEach>
				</table>
				
 
			</div>
			<nav aria-label="..." class="text-center">
					<input type="hidden" id="pageIndex" value="${pageBean.page }"> 
					<input type="hidden" id="pageTotal" value="${pageBean.totalPage }">
					<ul class="pager">
                        
					<c:if test="${pageBean.page!=1 }">	<li id="up"><a href="javascript:;" onclick="up()">上一页</a></li></c:if>
					<c:if test="${pageBean.totalPage!=pageBean.page }">	<li id="down"><a href="javascript:;" onclick="down()">下一页</a></li></c:if>
					</ul>
				</nav>
		</div>

	</div>
	

	<jsp:include page="footer.jsp"/>
			
	
</body>
</html>
