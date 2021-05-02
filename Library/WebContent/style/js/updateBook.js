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
	getCase(0);
	$("#bookType").change(function(){
		  var typeid=$("#bookType").val();
		 getCase(typeid);
	});
	$("#img").change(function(){
		console.log("mie");
//		alert("mie");
		 var oFReader = new FileReader();
		 var file = document.getElementById('img').files[0];
		 oFReader.readAsDataURL(file);
		 oFReader.onloadend = function(oFRevent){
		 	var src = oFRevent.target.result;	//这里的src是个base64惹
		 	console.log(src);
		 	$("#imgbase64").attr('src',src);
		 }
	});
	
})
function getCase(){	
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/Library/getBookCase.action",
		
		success : function(result) {
			$("#bookCase").empty();
			$("#bookCase").append(
					"<option value='0' selected='selected'>请选择</option>");
			$.each(result, function(index, obj) {
				$("#bookCase").append(
						"<option value='" + obj.id + "'>" + obj.bookcase
								+ "</option>");
			});
			console.log($("#bookCaseId").val());
			$("#bookCase").val($("#bookCaseId").val());
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
function updateBook(){
	var base64 = $("#imgbase64").attr('src');
	if(base64==null){
		base64=$("#imgurl").val;
	}
	var data=$.param({'url': base64})+'&'+$("#myForm").serialize();
	
  if(checkForm()){
    	 $.ajax({
    		   type:"POST",
    		   url:"http://localhost:8080/Library/updateBook.action",
    		   data:data,
    		   success : function(result){
    			   if(result.result==1){
    				   alert("图书修改成功");
    				   window.location.href="http://localhost:8080/Library/behindIndex.jsp";
    			   }else{
    				   alert("图书修改失败");
    			   }
    			 
    		   },
    		   error :function(e){
    			   alert("图书修改失败");
    			   console.log(e.status);
    				console.log(e.responseText);
    		   }
    	   });
     
  }
    
  
}
