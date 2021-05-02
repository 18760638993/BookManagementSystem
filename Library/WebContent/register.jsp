<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/register.css" />
<script src="http://localhost:8080/Library/style/js/jquery-1.9.1.js" type="text/javascript" ></script>
<script type="text/javascript" src="http://localhost:8080/Library/style/js/register.js"></script>
		<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/bootstrap.min.css">
<style type="text/css">
   .form-control{
   width:70%}
   .btn{
   width:200px;
   
   }
</style>
</head>

<body>
	
	<div class="main">
		<p style="margin-left: 180px;">新用户注册</p>
		<form id="myForm"  >
			
			<div class="form-group">
				<label for="exampleInputEmail1">用户名:</label> <input 
					type="text" class="form-control" id="username" name="username" placeholder="请输入用户名"
					>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">密码:</label> <input 
					type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码"
					>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">确认密码:</label> <input  placeholder="请重新输入密码"
					type="password" class="form-control" id="repwd" name="repwd"
					>
			</div>
			<div class="form-group">
			<label>性别:</label>
                    <input  name="sex" type="radio" value="1" />男
                    <input style="margin-left:20px" name="sex" type="radio" value="0"/>女
            	
            	</div>
			<div class="form-group">
				<label for="exampleInputPassword1">电话:</label> <input placeholder="请输入电话"
					type="text" class="form-control" id="mobile" name="mobile"
					>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">邮箱:</label> <input  placeholder="请输入邮箱"
					type="text" class="form-control" id="email" name="email"
					>
			</div>
		</form>
		<div class="re">
			   <button class="btn btn-success"  onclick="register()">注册</button>
			</div>
	</div>
	
</body>
</html>