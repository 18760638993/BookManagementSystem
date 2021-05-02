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
			
			
			$("#bookType").val($("#bookTypeId").val());
			
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	$("#bookType").change(function(){
		var id=$("#id").val();
		updateBookCase(id);
	})

	
})

function updateBookCase(id){
	var data=$("#myForm").serialize();
	
  if(checkForm()){
    	 $.ajax({
    		   type:"POST",
    		   url:"http://localhost:8080/Library/updateBookCase.action",
    		   data:data,
    		   dataType:"json",
    		   success : function(result){
    			   console.log(result);
    			   if(result.result==1){
    				   
    				   alert("书架修改成功");
    				   window.location.href="http://localhost:8080/Library/bookCase.jsp";
    			   }else{
    				   alert("书架修改失败");
    			   }
    			 
    		   },
    		   error :function(e){
    			   alert("图书修改失败");
    			   console.log(result)
    			   console.log(e.status);
    				console.log(e.responseText);
    		   }
    	   });
     
  }
    
  
}
