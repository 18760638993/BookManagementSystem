
function addType(){
	var data=$("#myForm").serialize();
	console.log(checkForm());
	if(checkForm()){
   $.ajax({
	   type:"POST",
	   url:"http://localhost:8080/Library/addType.action",
	   data:data,
	   dataType:"json",
	   success : function(result){
		   if(result.result==1){
		   alert("类型添加成功");
		   window.location.href="http://localhost:8080/Library/booktype.jsp";
		   }else{
			   alert("类型添加失败");
		   }
	   },
	   error :function(e){
		   alert("类型添加失败");
		   console.log(e.status);
			console.log(e.responseText);
	   }
   });
	}
}


