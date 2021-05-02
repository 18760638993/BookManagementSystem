$(function() {
	
	getData(1);
	
	
})

function next() {
	
	var pageIndex = $("#pageIndex").val();
	var index=parseInt(pageIndex)+1;
	console.log(index);
	getData(index);
}
function previous() {
	
	var pageIndex = $("#pageIndex").val();
	var index=parseInt(pageIndex)-1;
	console.log(index);
	getData(index);
}

function getData(pageIndex) {
	$("#up").hide();
	$("#down").hide();
	id=$("#sessionuserid").val();
	$
			.ajax({

				type : "POST",

				data : {
					
					"pageIndex" : pageIndex,
					"id":id
				},
				url : "http://localhost:8080/Library/UserServlet",

				success : function(result) {
					$("#pageIndex").val(result.page);
					$("#pageTotal").val(result.totalPage);
					 $("#userList").empty();
					 $("#userList").append("<tr><td>编号</td><td>用户名</td><td>电话</td><td>email</td><td>用户类型</td><td>用户状态</td><td>操作</td>"
					+"</tr>");
					$
							.each(
									result.list,
									function(index, obj) {
										var b = index + 1;
										var state;
										var userType;
                                        if(obj.sex==1){
                                        	obj.sex="男";
                                        }else{
                                        	obj.sex="女";
                                        }if(obj.userType==1){
                                        	userType="管理员";
                                        }else{
                                        	userType="普通用户"
                                        }if(obj.userState==0){
                                        	state="已冻结";
                                        }else{
                                        	state="正常";
                                        }
                                        	
                                        if($("#sessionusername").val()=="admin"){
                                        	console.log($("#username").val());
                                         if(obj.userState==1){
                                        	 if(obj.userType==0){
                                        	 $("#userList")
												.append(
														"<tr id='"+b+"'><td>"
																+ b
																+ "</td><td><a href='javascript:;' onclick='getBook("
																+obj.id
																+")'>"
																
																
																+ obj.userName
																
																+ "</td><td>"
																+ obj.mobile
																+ "</td><td>"
																+ obj.email
																+ "</td><td>"
																+ userType
																+ "</td><td>"
																+state
																+"</td><td><button type='button' onclick='changeState("
																+ obj.id+","+obj.userState
																+ ")' class='btn btn-danger'>冻结</button>"
																+"<button type='button' onclick='changeUserType("
																	+ obj.id+","
																	+ obj.userType+")' class='btn btn-primary'>设为管理员</button></td></tr>");
                                        	 }else{
                                        		 $("#userList")
 												.append(
 														"<tr id='"+b+"'> <td>"
 																+ b
 																+ "</td><td><a href='javascript:;' onclick='getBook("
 																+obj.id
 																+")'>"
 																
 																
 																+ obj.userName
 																+ "</a></td><td>"
 																
 																+ obj.mobile
 																+ "</td><td>"
 																+ obj.email
 																+ "</td><td>"
 																+ userType
 																+ "</td><td>"
 																+state
 																+"</td><td><button type='button' onclick='changeState("
 																+ obj.id+","+obj.userState
 																+ ")' class='btn btn-danger'>冻结</button>"
                                        		              +"<button type='button' onclick='changeUserType("
													+ obj.id+","
													+ obj.userType+")' class='btn btn-warning'>取消管理员</button></td></tr>");
                                        	 }

									
                                         }else{
                                        	 if(obj.userType==0){
                                        	 $("#userList")
												.append(
														"<tr id='"+b+"'> <td>"
																+ b
																+ "</td><td><a href='javascript:;' onclick='getBook("
																+obj.id
																+")'>"
																
																
																+ obj.userName
																+ "</a></td><td>"
																
																+ obj.mobile
																+ "</td><td>"
																+ obj.email
																+ "</td><td>"
																+ userType
																+ "</td><td>"
																+state
																+"</td><td><button type='button' onclick='changeState("
																+ obj.id+","+obj.userState
																+ ")' class='btn btn-success'>解冻</button>"
																+"<button type='button' onclick='changeUserType("
																+ obj.id+","
																+ obj.userType+")' class='btn btn-primary'>设为管理员</button></td></tr>");
                                     	 }else{
                                     		 $("#userList")
												.append(
														"<tr id='"+b+"'> <td>"
																+ b
																+ "</td><td><a href='javascript:;' onclick='getBook("
																+obj.id
																+")'>"
																
																
																+ obj.userName
																+ "</a></td><td>"
																
																+ obj.mobile
																+ "</td><td>"
																+ obj.email
																+ "</td><td>"
																+ userType
																+ "</td><td>"
																+state
																+"</td><td><button type='button' onclick='changeState("
																+ obj.id+","+obj.userState
																+ ")' class='btn btn-success'>解冻</button>"
																+"<button type='button' onclick='changeUserType("
																	+ obj.id+","
																	+ obj.userType+")' class='btn btn-warning'>取消管理员</button></td></tr>");
                                     	 }
                                         }

                                        }else{
                                        	if(obj.userState==1){
                                           	 if(obj.userType==0){
                                           	 $("#userList")
   												.append(
   														"<tr id='"+b+"'><td>"
   																+ b
   																+ "</td><td><a href='javascript:;' onclick='getBook("
   																+obj.id
   																+")'>"
   																
   																
   																+ obj.userName
   																
   																+ "</td><td>"
   																+ obj.mobile
   																+ "</td><td>"
   																+ obj.email
   																+ "</td><td>"
   																+ userType
   																+ "</td><td>"
   																+state
   																+"</td><td><button type='button' onclick='changeState("
   																+ obj.id+","+obj.userState
   																+ ")' class='btn btn-danger'>冻结</button>"
   																+"</td></tr>");
                                           	 }else{
                                           		 $("#userList")
    												.append(
    														"<tr id='"+b+"'> <td>"
    																+ b
    																+ "</td><td><a href='javascript:;' onclick='getBook("
    																+obj.id
    																+")'>"
    																
    																
    																+ obj.userName
    																+ "</a></td><td>"
    																
    																+ obj.mobile
    																+ "</td><td>"
    																+ obj.email
    																+ "</td><td>"
    																+ userType
    																+ "</td><td>"
    																+state
    																+"</td><td><button type='button' onclick='changeState("
    																+ obj.id+","+obj.userState
    																+ ")' class='btn btn-danger'>冻结</button>"
                                           		              +"</td></tr>");
                                           	 }

   									
                                            }else{
                                           	 if(obj.userType==0){
                                           	 $("#userList")
   												.append(
   														"<tr id='"+b+"'> <td>"
   																+ b
   																+ "</td><td><a href='javascript:;' onclick='getBook("
   																+obj.id
   																+")'>"
   																
   																
   																+ obj.userName
   																+ "</a></td><td>"
   																
   																+ obj.mobile
   																+ "</td><td>"
   																+ obj.email
   																+ "</td><td>"
   																+ userType
   																+ "</td><td>"
   																+state
   																+"</td><td><button type='button' onclick='changeState("
   																+ obj.id+","+obj.userState
   																+ ")' class='btn btn-success'>解冻</button>"
   																+"</td></tr>");
                                        	 }else{
                                        		 $("#userList")
   												.append(
   														"<tr id='"+b+"'> <td>"
   																+ b
   																+ "</td><td><a href='javascript:;' onclick='getBook("
   																+obj.id
   																+")'>"
   																
   																
   																+ obj.userName
   																+ "</a></td><td>"
   																
   																+ obj.mobile
   																+ "</td><td>"
   																+ obj.email
   																+ "</td><td>"
   																+ userType
   																+ "</td><td>"
   																+state
   																+"</td><td><button type='button' onclick='changeState("
   																+ obj.id+","+obj.userState
   																+ ")' class='btn btn-success'>解冻</button>"
   																+"</td></tr>");
                                        	 }
                                            }
                                        }
                                        
									});
					
					var pageIndex = $("#pageIndex").val();
					var totalPage = $("#pageTotal").val();
					console.log(pageIndex);
					if (pageIndex > 1) {

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
function changeState(id,userState){
	$
	.ajax({ 

		type : "POST",

		data : {
			"id":id,
			"userState":userState
		},
		url : "http://localhost:8080/Library/freezeUser.action",
        dataType:"json",
		success : function(result) {
			if(result.result==1){
			if(userState==1){
				alert("冻结成功");
				window.location.href="http://localhost:8080/Library/userList.jsp";
			}else{
				alert("解冻成功");
				window.location.href="http://localhost:8080/Library/userList.jsp";
			}
		}},

		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
function changeUserType(id,userType){
	if(userType==1){
		userType=0;
	}else{
		userType=1;
	}
		
	$
	.ajax({ 

		type : "POST",

		data : {
			"id":id,
			"userType":userType
		},
		url : "http://localhost:8080/Library/changeUserType.action",
        dataType:"json",
		success : function(result) {
			if(result.result==1){
			if(userType==1){
				alert("设置管理员成功");
				window.location.href="http://localhost:8080/Library/userList.jsp";
			}else{
				alert("取消管理员成功");
				window.location.href="http://localhost:8080/Library/userList.jsp";
			}
		}},

		error : function(e) {
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
function getBook(id){
	window.location.href="http://localhost:8080/Library/getbookbyuser.action?userid="+id;
	}