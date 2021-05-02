<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!-- 当前页面 -->
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>登录页面</title>
<!-- 引入外部样式 -->
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/style.css">
		<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/bootstrap.min.css">

<!-- 引入jquery库 -->
<script type="text/javascript" src="http://localhost:8080/Library/style/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#loginBtn").click(function(){
		var userId=$("#userId").val();//获取value值
		var pwdId = $("#pwdId").val();
		if(userId==""||userId==null){
			   alert("用户名不允许为空");
			   return;
		}
		if(pwdId==""||pwdId==null){
			   alert("密码不允许为空");
			   return;
		}
		document.forms[0].submit();//手动提交
	});
});
</script>
<style type="text/css">

 body{
 	background-color:#fff;
 }
</style>
</head>
<body>
	<!-- TOP层 -->
	<div class="top">
		<!-- 中间容器 -->
		<div class="container">
			<!-- top左 -->
			<div class="fl">
				<img src="style/image/logo.png" />
			</div>
			<!-- top右 -->
			<div class="fr">
				<span>如果您是新用户，请注册：</span> 
				<a href='register.jsp'>立即注册</a> 
				
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<!-- middle层 -->
	<div class="middle">
		<!-- 中间容器 -->
		<div class="container">
		<!-- action:要提交的控制器 -->
		<form action="LoginServlet" method="post">
			<div class="login" >
				<div class="loginContent">
				    <span style="font-size:900;color:red;">${msg}</span>
					<h3>登录</h3>
					<!-- 用户名 -->
					<div class="it">
						<i style="margin-left:8px;" ></i>
						<input id="userId" type="text" name="username" placeholder="用户名" class="txt">
					</div>
					<!-- 密码  -->
					<div class="it">
						<i style="background-position: 0 -28px;margin-left:8px;"></i> 
						<input id="pwdId" type="password" name="userpwd" placeholder="密码" class="txt">
					</div>
					
					<!-- 登录按钮 -->
					<div class="text-center" style="margin-top:30px">
					   <!-- <input type="button" value="登录" class="btn" onclick="checkLogin()"> -->
					   <button class="btn btn-primary "style="padding:0;width:200px;border-radius:0px;"  id="loginBtn" >登录</button>
					</div>
				</div>
			</div>
		</form>
		</div>
	</div>

</body>