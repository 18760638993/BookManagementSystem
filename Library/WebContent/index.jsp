<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setAttribute("path",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+request.getServletContext().getContextPath()); %>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<title>主页</title>
<link rel="stylesheet" type="text/css" href="${path }/style/css/index.css" />
<link rel="stylesheet" type="text/css" href="${path }/style/css/lbt.css" />
<link rel="stylesheet" type="text/css" href="${path }/style/css/myindex.css" />
<script src="${path }/style/js/jquery-1.9.1.js" type="text/javascript" ></script>
<script src="${path }/style/js/blt.js" type="text/javascript" ></script>
<script src="${path }/style/js/indexShow.js" type="text/javascript" ></script> 

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
			
			<div >
				<label for="exampleInputPassword1">书籍类型：</label> <select class="form-control" id="typeList">

				</select>
				<table id="bookList" class="bookList">

					
				</table>
				

			</div>
			<nav aria-label="..." class="text-center">
					<input type="hidden" id="pageIndex"> 
					<input type="hidden" id="pageTotal">
					<ul class="pager">

						<li id="up"><a href="javascript:;" onclick="previous()">上一页</a></li>
						<li id="down"><a href="javascript:;" onclick="next()">下一页</a></li>
					</ul>
				</nav>
		</div>

	</div>

	<jsp:include page="footer.jsp"/>
			
			
</body>
</html>
