$(function() {
	//请求参数

	//
	
	
	getData();
	
	
	
})


function getData() {

	$.ajax({
				type : "POST",
				url : "http://localhost:8080/Library/getAllType.action",
				success : function(result) {
					 $("#bookType").empty();
					 $("#bookType").append("<tr>"
						+"<td>编号</td>"
						+"<td>书籍类型</td>"
						
						+"<td>操作</td>"
					+"</tr>")
					$.each(result,function(index, obj) {
										var b = index + 1;
										$("#bookType")
												.append(
														"<tr><td>"
																+ b
																+ "</td><td><a href='javascript:;' onclick='getBookTypeById("
																+obj.id
																+")'>"
																+ obj.name
																+ "</a>"
																
																
																+ "</td><td><button type='button' onclick='delbookType("
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
function AddType(){
	var userid=$("#sessionuserid").val();
if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp"
			return ;
	}else{
	window.location.href="http://localhost:8080/Library/AddType.jsp";
	}
}
function getBookTypeById(id){
	var userid=$("#sessionuserid").val();
if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp"
			return ;
	}else{
	window.location.href="http://localhost:8080/Library/getBookTypeById.action?id="+id;
	}
}
function delbookType(id){
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
		url : "http://localhost:8080/Library/delBookType.action",

		success : function(result) {
			if(result.result==1){
				alert("类型删除成功");
				window.location.href="http://localhost:8080/Library/booktype.jsp";
			}else if(result.result==2){
				alert("该类型下有书，不可删除");
				window.location.href="http://localhost:8080/Library/booktype.jsp";
			}else{
				alert("该类型有对应的书架，不可删除")
			}
		},

		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	}
}
