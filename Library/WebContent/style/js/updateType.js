$(function() {
	
	

	
})

function updateBookType(id){
	var data=$("#myForm").serialize();
	
  if(checkForm()){
    	 $.ajax({
    		   type:"POST",
    		   url:"http://localhost:8080/Library/updateBookType.action",
    		   data:data,
    		   dataType:"json",
    		   success : function(result){
    			   console.log(result);
    			   if(result.result==1){
    				   
    				   alert("类型修改成功");
    				   window.location.href="http://localhost:8080/Library/booktype.jsp";
    			   }else{
    				   alert("类型修改失败");
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
