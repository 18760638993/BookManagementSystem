function jumptoBehindIndex(){
		window.location.href="http://localhost:8080/Library/behindIndex.jsp";
	}
	function jumptoUserList(){
		var userid=$("#sessionuserid").val();
		console.log(userid);
		if(userid == undefined||userid==''||userid==null ){
		    
			alert("请登录");
			window.location.href="http://localhost:8080/Library/login.jsp";
				return ;
		}else{
		window.location.href="http://localhost:8080/Library/userList.jsp";
		}
	}
function logout(){
	window.location.href="http://localhost:8080/Library/logout.action";
}
function back(){
	history.back();
}
function jumptoIndex(){
	window.location.href="http://localhost:8080/Library/index.jsp";
	
}
function jumptoMyBook(){
	var userid=$("#sessionuserid").val();
	
	if(userid!=null &&userid!=""){
		window.location.href="http://localhost:8080/Library/getbookbyuserid.action?userid="+userid;
		
			return ;
	}else{
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp";
	}
}
function jumpToMyInfo(){
	var userid=$("#sessionuserid").val();
	if(userid!=null &&userid!=""){
	    
		window.location.href="http://localhost:8080/Library/getMyInfo.action?userid="+userid;
		return ;
	}else{
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp";
	}
	
	
}
function jumpTomyInfo(){
	var userid=$("#sessionuserid").val();
     if(userid == undefined||userid==' '||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp";
			return ;
	}else{
	window.location.href="http://localhost:8080/Library/getmyInfo?userid="+userid;
	}
}

function jumptobookcase(){
	var userid=$("#sessionuserid").val();
     if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp";
			return ;
	    }else{
	window.location.href="http://localhost:8080/Library/bookCase.jsp";
	}
}
function jumptobooktype(){
	var userid=$("#sessionuserid").val();
     if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp";
			return ;
	    }else{
	window.location.href="http://localhost:8080/Library/booktype.jsp";
	}
}
function checkForm(){
	
	var t = $("#myForm").serializeArray();
	var flag = true;
    $.each(t, function() {
     if(this.value==null||this.value==''||this.value==undefined){
    	 alert("表单中有未填的选项");
    	 flag = false;
     }
    });
   return flag;
}
function jumptoBehind(){
	window.location.href="http://localhost:8080/Library/behindIndex.jsp";
}
