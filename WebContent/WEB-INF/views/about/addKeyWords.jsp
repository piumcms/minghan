<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<title>关键字.集团简介</title>
<script type="text/javascript">

$(document).ready(function() { 
	
	$("#submit").click(function() {
		var obj = new Object();
		obj.id = $("#id").val();
	
		var title = $("#title").val();
		if (title == "") {
			$.messager.alert('云盛信息管理系统','标题不能为空','warning');
			return false;
		}
		obj.title = title;
		var key_words = $("#keyWords").val();
		if (key_words == "") {
			$.messager.alert('云盛信息管理系统','关键字不能为空','warning');
			return false;
		}
		obj.keyWords = key_words;
		var des_c1 = $("#desC1").val();
		obj.desC1 = des_c1;
		
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/about/saveKeyWords.html',
			data : jsondata,
			dataType : 'json',
			contentType : 'application/json',
			beforeSend: function(XMLHttpRequest){
				 $.messager.progress({
				        title:'Please waiting',
				        msg:'Loading data...'
				    });
        	},
			success : function(result) {
			
				$.messager.alert('云盛信息管理系统',result.msg);
		
			},
			 complete: function(XMLHttpRequest, textStatus){
				 $.messager.progress('close');
		        },
	        error:function(jqXHR, textStatus, errorThrown){
	        	top.location.href=getRootPath() + "/common/error";
	        }
	    });
	});
	

});


</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>云盛信息集团</td><td>&gt;</td>
        	<td>
        		关键字
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${keyWords.id }">添加</ll:emptyTag><ll:notEmptyTag value="${keyWords.id }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveIntr.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${keyWords.id }" id="id"/>
		<div class="outSideDiv">
        <div class="inputArea2">
        	<label>标题：</label>
        	<div style="float: left;display: inline;width: 650px;">
				<input type="text"  name="title" value="${keyWords.title }"  id="title"/>
			</div>
        </div>
         <div class="inputArea2">
        	<label>关键字：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<input type="text"  name="keyWords" value="${keyWords.keyWords }"  id="keyWords"/>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>描述1：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<input type="text"  name="desC1" value="${keyWords.desC1 }"  id="desC1"/>
				
			</div>
        </div>
        
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>