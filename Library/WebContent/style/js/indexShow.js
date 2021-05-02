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
				url : "http://localhost:8080/Library/getAllBook.action",

				success: function (result) {
					$("#pageIndex").val(result.page);
					$("#pageTotal").val(result.totalPage);
					$("#bookList").empty();
					
					$.each(result.list,function (index, obj) {
						// obj.bid
						$("#bookList").append( '<div class="bookItem"> \
								<div class="bookimg"> '
								+'<a href="http://localhost:8080/Library/getBookByBId.action?id='+obj.bid+'"><img src="'+obj.url+'"></a>\
							</div> \
							<div class="bookname"> \
								<span>《<span class="bookname-value">'+obj.bookname+'</span>》</span> \
							</div> \
							<div onclick="borrowBook('+obj.bid+')" class="borrow"> \
								<span>借阅</span> \
							</div>  \
						</div> ');
						
						
					});
					
					var pageIndex = $("#pageIndex").val();
					var totalPage = $("#pageTotal").val();
					console.log(pageIndex);
					console.log(totalPage);
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
function borrowBook(id){
	console.log(id);
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
			"userid" : userid
		},
		url : "http://localhost:8080/Library/borrowBook.action",
        dataType:"json",
		success : function(result) {
			if(result.code==1){
				alert("图书借阅成功");
				window.location.href="http://localhost:8080/Library/index.jsp";
			}else{
				alert("图书失败");
			}
		},

		error : function(e) {
			
			console.log(e.status);
			console.log(e.responseText);
		}
	});
	}
}
