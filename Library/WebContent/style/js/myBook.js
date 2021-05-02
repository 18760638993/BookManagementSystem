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
$(function(){
	$("#state").change(function(){
		var pageIndex = $("#pageIndex").val();
		getData(pageIndex);
		
	});
	$("#state").val($("#bookstate").val());
});
function getData(index) {
      var state=$("#state").val();
      var userid = $("#sessionuserid").val();
  	   console.log(userid);
  	
	window.location.href="http://localhost:8080/Library/getbookbyuserid.action?userid="+userid+"&pageIndex="+index+"&state="+state;
       
}
function next() {
	
	var pageIndex = $("#pageIndex").val();
	var index=pageIndex+1;
	getData(index);
}
function previous() {
	
	var pageIndex = $("#pageIndex").val();
	var index=pageIndex-1;
	getData(index);
}