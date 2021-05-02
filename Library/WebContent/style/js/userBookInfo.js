function recieveBook(id,bookid){
	var userid=$("#sessionuserid").val();
	$.ajax({
		url:"http://localhost:8080/Library/recieveBook.action",
		type:"POST",
		data:{"id":id,"bookid":bookid},
		dataType:"json",
		success : function(result){
			if(result.code==1){
				alert("还书成功");
				window.location.href="http://localhost:8080/Library/getbookbyuserid.action?userid="+userid;
			}else{
				alert("还书失败");
			}
		},
		error : function(e){
			console.log(e.status);
			console.log(e.responseText);
		}
	});
}
function getData(userid, pageIndex) {

	window.location.href="http://localhost:8080/Library/getbookbyuser.action?userid="+useid+"&pageIndex"+pageIndex;
}
function next() {
	var userid = $("#sessionuserid").val();
	var pageIndex = $("#pageIndex").val();
	var index=parseInt(pageIndex)+1;
	
	getData(userid, index);
}
function previous() {
	var userid = $("#sessionuserid").val();
	var pageIndex = $("#pageIndex").val();
	var index=parseInt(pageIndex)-1;
	
	getData(userid, index);
}