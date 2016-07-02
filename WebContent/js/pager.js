$(function() {
	$(".page1").click(function() {
		var id = $(this).attr("id");
		var url =null;
		 url=$("#url").val();
		var currentNum = $("#hidCurPage").val();
		if(url!=null&&url!=""){//调取隐藏的url提交表单
			//上一页
			if (id =="aa<") {
				window.location.href = getRootPath() + "/" +  url +  "/" + (parseInt(currentNum) - 1);
			}else if (id =="aa>") {
				window.location.href = getRootPath() + "/" +  url +  "/" + (parseInt(currentNum) + 1);
			
			}else {
				var num = id.substring(2);
				
				window.location.href = getRootPath() + "/" +  url+  "/"  + num;
			}
		}else{//form提交
			var pageNum=0;
			//上一页
			if (id =="aa<") {
				pageNum=(parseInt(currentNum) - 1);
			} else if (id =="aa>") {
				pageNum=(parseInt(currentNum) + 1);
			
			}else {
				pageNum = id.substring(2);
			}
			$("#pageNumber").val(pageNum);
			$(this).parents('form').submit();
		}
	});
	$(".goClass").click(function() {
		
		var url = $("#url").val();
		var num = $("#inputVal").val();
		var total = $("#totalPages").val();
		if (num == "") {
			
			return false;
		}
		 if(!num.match(/^[\+\-]?\d*$/)){
		     
		      return false;
		  }
		 if (parseInt(total) < num) {
			 return false;
		 }
		 if(url!=null&&url!=""){//调取隐藏的url提交表单
			 window.location.href = getRootPath() + "/" +  url + "/" + num;
		 }else{
			 $("#pageNumber").val(num);
		     $("#form").submit();
		 }
		 
	});
	$.fn.numeral = function(){  
        $(this).css("ime-mode","disabled");  
        this.bind("keypress",function(event){ 
        	var k=window.event?event.keyCode:event.which; 
            return k>=48&&k<=57||k==8;  
        });  
        this.bind("blur",function(event){  
            if(this.value.lastIndexOf(".")==(this.value.length-1)){  
                this.value = this.value.substr(0,this.value.length-1);  
            }else if(isNaN(this.value)){  
                this.value = "";                      
            }  
        });  
        this.bind("paste",function(event){  
            var s=clipboardData.getData('text');   
            if(!/\D/.test(s));   
            value=s.replace(/^0*/,'');   
            return false;  
        });  
        this.bind("dragenter",function(event){  
            return false;  
        });  
        this.bind("keyup",function(event){  
            if(/(^0+)/.test(this.value))this.value=this.value.replace(/^0*/, '');  
        });  
    };
    $("#goNum").numeral();
	$("#goPageBtn").click(function(){
		var goNum = $("#goNum").val();
		var pageAmount = $("#pageAmount").html();
		if (goNum>pageAmount) {
			alert("请输入正确的页数！");
		} else if (goNum!=currentPage) {
			var currentUrl = $("#currentUrl").val();
			window.location.href = currentUrl+"?currentPage="+goNum;
		}
	});
});