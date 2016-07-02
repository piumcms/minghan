<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
$(function(){
	$("#currentPage").val(1);
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
    			turnPage(goNum,0);
    		}
    	});
})
Date.prototype.format = function(format){ 
            var o = { 
            "M+" : this.getMonth()+1, //month 
            "d+" : this.getDate(), //day 
            "h+" : this.getHours(), //hour 
            "m+" : this.getMinutes(), //minute 
            "s+" : this.getSeconds(), //second 
            "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
            "S" : this.getMilliseconds() //millisecond 
            } 
 
            if(/(y+)/.test(format)) { 
            format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
            } 
 
            for(var k in o) { 
            if(new RegExp("("+ k +")").test(format)) { 
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
            } 
            } 
            return format; 
        }
function turnPage(_turnPage, _prevOrNext) {
	var currentPage = $("#currentPage").val();
	if (_turnPage!=0) {
		if (currentPage!=_turnPage) {
			currentPage = _turnPage;
		} else {
			return;
		}
	} else {
		if (currentPage==1 && _prevOrNext==-1) {
			return;
		} else {
			currentPage = parseInt(currentPage)+parseInt(_prevOrNext);
		}
	}
	
	$("#currentPage").val(currentPage);
	
	var urls = $("#urls").val();
	$.ajax({
    	type : 'POST',
		url : ctx+'/'+urls+'/getBrandNewsByAjax?currentPage='+currentPage,
		//data : jsondata,
		dataType : 'json',
		contentType : 'application/json',
		success : function(result) {
			$(".news_list").children("ul").html("");
			for (var i=0;i<result.length;i++) {
				var date=new Date(result[i].createTime);
				$(".news_list").children("ul").append("<li><a href=\"${ly}/news-detail.html?newsId="+result[i].id+"\">"+result[i].title+"</a>"+
						"<span class=\"time\">"+date.format("yyyy-MM-dd")+"</span></li>");
			}
			$(".pagearea").find("a").removeClass("currpage");
			$(".pagearea").find("a[index="+currentPage+"]").addClass("currpage");
		},
        error:function(jqXHR, textStatus, errorThrown){
        	//top.location.href=getRootPath() + "/common/error";
        }
    });
}
</script>
<div class="pagearea tr">
	<input type="hidden" id="currentPage" value="1">
	<input type="hidden" id="currentUrl" value="${ly}/${urlS}/news.html">
	跳至<input class="inputtext" type="text" id="goNum" style="ime-mode:disabled"/><input type="image"
		src="${ly}/imgs/pagearea/go.png" id="goPageBtn" /> 共<strong id="pageAmount">${pageAmount}</strong>页 
		<a onclick="turnPage(0, -1);" href="javascript:void(0);"><img src="${ly}/imgs/pagearea/prev.png" alt="" /></a>  
	<c:if test="${pageAmount>0}">
				<c:forEach var="i" begin="1" end="${pageAmount}">
					<c:choose>
						<c:when test="${i==1}">
							<a index="${i}" class="currpage" onclick="turnPage(${i}, 0);" href="javascript:void(0);">${i }</a>&nbsp;
							            	</c:when>
						<c:otherwise>
							<a index="${i}" onclick="turnPage(${i}, 0);" href="javascript:void(0);">${i }</a>&nbsp;
							            	</c:otherwise>
					</c:choose>
				</c:forEach>
	</c:if>
	<a onclick="turnPage(0, 1);" href="javascript:void(0);"><img src="${ly}/imgs/pagearea/next.png" alt="" /></a>  
	
</div>