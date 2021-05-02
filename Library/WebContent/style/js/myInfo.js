function update(id){
	var data=$("#myForm").serialize();
	if(checkForm){
       $.ajax({
    	   url:"http://localhost:8080/Library/updateUser.action",
    	   type:"post",
    	   data:data,
    	   succsee: function(result){
    		   
    	   },
    	   error:function(e){
    		   console.log(e.status);
   			console.log(e.responseText);
    		   },
       });
	}
}
$(function(){
	
	$("[name='sex'][value='"+$("#usersex").val()+"']").prop("checked", "checked");
	$('input[type=radio][name=sex]').change(function() {
	
		var id=$("#id").val();
		update(id);
		
	});
	
})

