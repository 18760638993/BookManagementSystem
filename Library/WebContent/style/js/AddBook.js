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
function getCase(typeid){	
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/Library/getBookCase.action",
		data:{"typeid":typeid},
		success : function(result) {
			$("#bookCase").empty();
			$("#bookCase").append(
					"<option value='0' selected='selected'>请选择</option>");
			$.each(result, function(index, obj) {
				$("#bookCase").append(
						"<option value='" + obj.id + "'>" + obj.bookcase
								+ "</option>");
			});
		},
		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
function AddBook(){
	var base64 = $("#imgbase64").attr('src');
	console.log(base64);
	var data=$.param({'url': base64})+'&'+$("#myForm").serialize();
//	data.url = base64
	console.log(data);
	if(checkForm()){
   $.ajax({
	   type:"POST",
	   url:"http://localhost:8080/Library/addBook.action",
	   data:data,
	   dataType:"json",
	   success : function(result){
		   if(result.result==1){
			   alert("图书添加成功");
			   window.location.href="http://localhost:8080/Library/behindIndex.jsp";
		   }else{
			   alert("图书添加失败");
		   }
		   
	   },
	   error :function(e){
		   alert("图书添加失败");
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
