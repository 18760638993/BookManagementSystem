<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<script src="http://localhost:8080/Library/style/js/jquery-1.9.1.js" type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/header.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Library/style/css/bootstrap.min.css">
<script type="text/javascript" src="http://localhost:8080/Library/style/js/common.js"></script>
<script language="javascript" type="text/javascript">
	$("document").ready(function(e) {
        
		
		//随滚动条移动的广告窗口
   		$(window).scroll(function(){
		var scrollTop = document.body.scrollTop || document.documentElement.scrollTop || 0;
		$(".right_ad").stop();
		var scrollTop2 = (scrollTop+160) - $(".right_ad").position().top;
		if(scrollTop > 240){
			$(".right_ad:not(:animated)").animate({top:"+="+scrollTop2+"px"},1000);
		}else{
			$(".right_ad").css("top",360+"px");
		}
		$(".right_ad").find("a").click(function(){
        $(".right_ad").hide();
		});
		});	
		
		
    });
</script>
</head>
<body>
	<!--随滚动条滚动可关闭广告<a href="gonggao.jsp"></a>http://images.china.cn/images1/ch/20200925/lantern.gif-->
	<div class="right_ad" style="width:125px; height:220px; position:absolute; top:100px; right:5px;">
	<div class="dd_close" id="dd_close"><a href="javascript:void(0)">关闭</a></div>
	<a href="gonggao.jsp"><img src="style/image/tanchuan2.png"  height="165px" width="150px"/></a>
	</div>
	<!--头部-->
	<div class="header ">
		<div class="fl">
		<img src="style/image/logo.png"/>
		</div>
		<div class="h-right">
		<input type="hidden" id="sessionuserid" value="${sessionuser.id}" readonly="readonly">
		<input type="hidden" id="sessionusername" value="${username }">
			<ul>
				<li><c:if test="${not empty username }">
						<a href="javascript:;">欢迎 : ${username}</a>
					</c:if> <c:if test="${ empty username }">
						<a href="login.jsp">登录/</a>
						<a href="register.jsp">注册</a>
					</c:if></li>
				<li><a href="javascript:;" onclick="logout()">注销</a></li>
			</ul>
		</div>
	</div>
	
</body>
</html>