function checkMyForm(){
	
	
	var t = $("myForm").serializeArray();
	var flag=true;
    $.each(t, function() {
     if(this.value==null||this.value==undefined||this.value==' '){
    	 alert("表单中未填的选项");
    	 flag=false;
     }
    });
   
	var pwd=$("#pwd").val();
	var repwd=$("#repwd").val();
	if(repwd!=pwd){
		alert("两次输入的密码不同");
		flag=false;
	}
	return flag;
	
}
function register(){
	if(checkMyForm()){
		var data=$("#myForm").serialize();
		$.ajax({
	    	   url:"http://localhost:8080/Library/register.action",
	    	   type:"POST",
	    	   data:data,
	    	   dataType:"json",
	    	   success: function(result){
	    		   if(result.result==1){
	    			   alert("恭喜您注册成功！");
	    			   window.location.href="http://localhost:8080/Library/login.jsp";
	    		   }
	    		   else if(result.result==2){
	    			   alert("该用户已存在");
	    		   }else{
	    			   window.location.href="http://localhost:8080/Library/register.jsp";
	    		   }
	    	   },
	    	   error:function(e){
	    		   console.log(e.status);
	   			console.log(e.responseText);
	    		   },
	       });
	}
}
