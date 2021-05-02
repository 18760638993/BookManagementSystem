$(function(){
        /*定义图片索引*/
        var index=0;
        /*添加节流阀  true说明本次单击会有响应处理*/
        var flag=true;
        /*下一张*/
        $(".next").on("click",function(){
            if(flag==true){
                /*设置节流阀*/
                flag=false;
                index--;
                /*所谓下一张，就是将所有li元素围绕x旋转*/
                $(".view li").each(function(key,value){ //0 1 2 3 4
                    /*通过添加transform样式进行旋转*/
                    $(this).css({
                        "transform":"rotateX("+(index*90)+"deg)",
                        "transition-delay":(key*0.2)+"s"
                    });
                });
                setTimeout(function(){
                    flag=true;
                },1000);
            }
        });
        /*上一张*/
        $(".pre").on("click",function(){
            if(flag==true){
                /*设置节流阀*/
                flag=false;
                index++;
                /*所谓下一张，就是将所有li元素围绕x旋转*/
                $(".view li").each(function(key,value){ //0 1 2 3 4
                    /*通过添加transform样式进行旋转*/
                    $(this).css({
                        "transform":"rotateX("+(index*90)+"deg)",
                        "transition-delay":(key*0.2)+"s"
                    });
                });
                setTimeout(function(){
                    flag=true;
                },1000);
            }
        });
    });
