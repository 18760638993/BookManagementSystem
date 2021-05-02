$(function() {
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/Library/getAllType.action",
		success : function(result) {
			$("#bookType").empty();
			$("#bookType").append(
					"<option value='0' selected='selected'>请选择</option>");
			$.each(result, function(index, obj) {
				console.log(obj.id,obj.name);
				$("#bookType").append(
						"<option value='" + obj.id + "'>" + obj.name
								+ "</option>");
			});
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	
	
})
function addCase(){
	var data=$("#myForm").serialize();
	if(checkForm()){
   $.ajax({
	   type:"POST",
	   url:"http://localhost:8080/Library/addCase.action",
	   data:data,
	   dataType:"json",
	   success : function(result){
		   if(result.result==1){
		   alert("书架添加成功");
		   window.location.href="http://localhost:8080/Library/bookCase.jsp";
		   }else{
			   alert("书架添加失败");
		   }
	   },
	   error :function(e){
		   alert("书架添加失败");
		   console.log(e.status);
			console.log(e.responseText);
	   }
   });
	}
}

function jumptoIndex(){
	window.location.href="http://localhost:8080/Library/index.jsp";
}
function jumptoUserList(){
	window.location.href="http://localhost:8080/Library/userList.jsp";
}
