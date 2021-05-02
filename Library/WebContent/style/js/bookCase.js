$(function() {
	//请求参数

	//
	$.ajax({

		type : "POST",

		url : "http://localhost:8080/Library/getAllType.action",

		success : function(result) {
			$("#bookType").empty();
			$("#bookType").append(
					"<option value='0' selected='selected'>选择性选择</option>");
			$.each(result, function(index, obj) {
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
	var typeid = $("#bookType").val();

	if (typeid == null) {
		typeid = 0;
	}
	
	getData(typeid);
	
	$("#bookType").change(function(){
		  var typeid=$("#bookType").val();
		 
		  if(typeid==null){
			  typeid=0;
		  }
		  getData(typeid);
		});
	
})


function getData(typeid) {
	
	$
			.ajax({

				type : "POST",

				data : {
					"typeid" : typeid,
					
				},
				url : "http://localhost:8080/Library/getBookCase.action",

				success : function(result) {
					
					 $("#bookCase").empty();
					 $("#bookCase").append("<tr>"
						+"<td>编号</td>"
						+"<td>书架</td>"
						+"<td>所属类型</td>"
						+"<td>操作</td>"
					+"</tr>")
					$
							.each(
									result,
									function(index, obj) {
										var b = index + 1;
                                       
										$("#bookCase")
												.append(
														"<tr><td>"
																+ b
																+ "</td><td><a href='javascript:;' onclick='getBookCaseById("
																+obj.id
																+")'>"
																+ obj.bookcase
																+ "</a></td><td>"
																+ obj.bookType
																
																+ "</td><td><button type='button' onclick='delBookCase("
																+ obj.id
																+ ")' class='btn btn-primary'>删除</button></td></tr>")

									});
				
				},

				error : function(e) {
					console.log(e.status);
					console.log(e.responseText);
				}
			});
}
function AddBookCase(){
	var userid=$("#sessionuserid").val();
if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp"
			return ;
	}else{
	window.location.href="http://localhost:8080/Library/addCase.jsp";
	}
}
function getBookCaseById(id){
	var userid=$("#sessionuserid").val();
if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp"
			return ;
	}else{
	window.location.href="http://localhost:8080/Library/getBookCaseById.action?id="+id;
	}
}
function delBookCase(id){
	var userid=$("#sessionuserid").val();
if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp"
			return ;
	}else{
	$
	.ajax({

		type : "POST",

		data : {
			"id" : id,
			
		},
		url : "http://localhost:8080/Library/delBookCase.action",

		success : function(result) {
			if(result.result==1){
				alert("书架删除成功");
				window.location.href="http://localhost:8080/Library/index.jsp";
			}else if(result.result==2){
				alert("该书架上有书，不可删除");
				window.location.href="http://localhost:8080/Library/bookCase.jsp";
			}else{
				
			}
		},

		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	}
}
