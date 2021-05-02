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
<script src="http://localhost:8080/Library/style/js/myInfo.js"type="text/javascript" charset="utf-8"></script> 
<style type="text/css">

.form-group{
   clear:both;
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
					<li class="nav-item "><a class="nav-link" href="javascript:;" onclick="jumptoIndex()">首页</a></li>
					<li class="nav-item " ><a class="nav-link" href="javascript:;" onclick="jumptoMyBook()">我的借阅</a></li>
					<li class="nav-item active"><a class="nav-link" href="javascript:;" onclick="jumpToMyInfo()">个人信息</a></li>
				</ul>
			</nav>

		</div>
		<div class="m-right" >
			
			<div class="view">
			  
				<form id="myForm" name="myForm">
			<input type="hidden" name="id" value="${user.id}" id="id">
				<div class="form-group">
					<label for="exampleInputEmail1">姓名</label> <input style="width:30%;"
						type="text" class="form-control"  id="username" name="username"
						value="${user.userName }" onblur="update(id)" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">性别</label> 
						
						<c:if test="${user.sex==1 }">
						<input  name="sex"  type="radio" id="sex" value="1" checked="checked" />男
						<input  name="sex"  type="radio" id="sex" value="0"  />女
						</c:if>
						<c:if test="${user.sex==0 }">
						<input   name="sex"  type="radio" id="sex" value="1"  />男
                        <input  name="sex"  type="radio" id="sex" value="0" checked="checked" />女
                        </c:if>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">电话</label> <input style="width:30%"
						type="text" class="form-control" id="mobile" name="mobile"
						value="${user.mobile }" onblur="update()">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">email</label> <input style="width:30%"
						type="text" class="form-control" id="email" name="email"
						value="${user.email }"  onblur="update()">
				</div>
				
				
				
			</form>
		</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"/>
		
			
</body>
</html>
