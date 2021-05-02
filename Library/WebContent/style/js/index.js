$(function() {
	//请求参数

	//
	$.ajax({

		type : "POST",

		url : "http://localhost:8080/Library/getAllType.action",

		success : function(result) {
			$("#typeList").empty();
			$("#typeList").append(
					"<option value='0' selected='selected'>选择性选择</option>");
			$.each(result, function(index, obj) {
				$("#typeList").append(
						"<option value='" + obj.id + "'>" + obj.name
								+ "</option>");

			});
		},

		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	var typeid = $("#typeList").val();

	if (typeid == null) {
		typeid = 0;
	}
	var pageIndex=1;
	getData(typeid,pageIndex);
	
	$("#typeList").change(function(){
		  var typeid=$("#typeList").val();
		  var pageIndex=$("#pageIndex").val();
		  if(typeid==null){
			  typeid=0;
		  }
		  getData(typeid, pageIndex);
		});
	
})

function next() {
	var typeid = $("#typeList").val();
	var pageIndex = $("#pageIndex").val();
	var index=parseInt(pageIndex)+1;
	if (typeid == null) {
		typeid = 0;
	}
	getData(typeid, index);
}
function previous() {
	var typeid = $("#typeList").val();
	var pageIndex = $("#pageIndex").val();
	var index=parseInt(pageIndex)-1;
	if (typeid == null) {
		typeid = 0;
	}
	getData(typeid, index);
}
function getData(typeid, pageIndex) {
	$("#up").hide();
	$("#down").hide();
	$
			.ajax({

				type : "POST",

				data : {
					"typeid" : typeid,
					"pageIndex" : pageIndex
				},
				url : "http://localhost:8080/Library/getBook.action",

				success : function(result) {
					$("#pageIndex").val(result.page);
					$("#pageTotal").val(result.totalPage);
					 $("#bookList").empty();
					 $("#bookList").append("<tr>"
								+"<td>编号</td>"
								+"<td>书名</td>"
								+"<td>类型</td>"
								+"<td>作者</td>"
								+"<td>状态</td>"
								+"<td>操作</td>"
							+"</tr>");
					$
							.each(
									result.list,
									function(index, obj) {
										var b = index + 1;
										var bookstate;
                                       if(obj.bookState==1){
                                    	  bookstate="正常";
                                       }else{
                                    	   bookstate="已下架";
                                       }
                                       if(obj.bookState==0){
										$("#bookList")
												.append(
														"<tr><td>"
																+ b
																+ "</td><td><a href='http://localhost:8080/Library/getBookById.action?id="
																+obj.bid+"'>"
																+ obj.bookname
																+ "</a></td><td>"
																+ obj.bookType
																+ "</td><td>"
																+ obj.author
																+"</td><td>"
																+bookstate
																+"</td><td><button class='btn-primary' onclick='delBook("
																+obj.bid
																+",1)'>上架</button></td></tr>");
                                       }else{
                                    	   $("#bookList")
											.append(
													"<tr><td>"
															+ b
															+ "</td><td><a href='http://localhost:8080/Library/getBookById.action?id="
															+obj.bid+"'>"
															+ obj.bookname
															+ "</a></td><td>"
															+ obj.bookType
															+ "</td><td>"
															+ obj.author
															+"</td><td>"
															+bookstate
															+"</td><td><button class='btn-primary' onclick='delBook("
															+obj.bid
															+",0)'>下架</button></td></tr>");
                                       }
                                    	  

									});
									
					var pageIndex = $("#pageIndex").val();
					var totalPage = $("#pageTotal").val();
					console.log(pageIndex);
					console.log(totalPage);
					if (pageIndex > 1) {
                        console.log(pageIndex);
						$("#up").show();

					}
					if (pageIndex!=totalPage) {

						$("#down").show();
					}
				},

				error : function(e) {
					console.log(e.status);
					console.log(e.responseText);
				}
			});
}
function AddBook(){
	var userid=$("#sessionuserid").val();
	
if(userid == undefined||userid==''||userid==null ){
	    
		alert("请登录");
		window.location.href="http://localhost:8080/Library/login.jsp"
			return ;
	}else{
	window.location.href="http://localhost:8080/Library/AddBook.jsp";
	}
}
function delBook(id,bookstate){
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
			"bookstate":bookstate
		},
		url : "http://localhost:8080/Library/delBook.action",
        dataType:"json",
		success : function(result) {
			if(result.result==1){
				if(bookstate==0){
				alert("图书下架成功");
				window.location.href="http://localhost:8080/Library/behindIndex.jsp";
				}else{
					alert("图书上架成功");
					window.location.href="http://localhost:8080/Library/behindIndex.jsp";
				}
			}else{
				if(bookstate==0){
					alert("图书下架失败");
					window.location.href="http://localhost:8080/Library/behindIndex.jsp";
					}else{
						alert("图书上架失败");
						window.location.href="http://localhost:8080/Library/behindIndex.jsp";
					}
			}
		},

		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	}
}
