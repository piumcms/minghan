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
<link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="${ly }/kindeditor/lang/zh_CN.js"></script>
<title>关于云盛信息,科技创新</title>
<script type="text/javascript">
var editor1;
var editor2;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="contentA"]', {
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	
	editor2 = K.create('textarea[name="contentB"]', {
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});

});

$(document).ready(function() { 
	
	$("#submit").click(function() {
		var obj = new Object();
		obj.id = $("#id").val();
		
		var html = editor1.html();
		if (html == "") {
			$.messager.alert('云盛信息管理系统','实力雄厚内容描述不能为空','warning');
			return false;
		}
		obj.contentA = html;
		
		html = editor2.html();
		if (html == "") {
			$.messager.alert('云盛信息管理系统','高端合作内容描述不能为空','warning');
			return false;
		}
		obj.contentB = html;
		var jsondata =  $.toJSON(obj);


	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/innovate/saveInnovate.html',
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>创新与生活</td><td>&gt;</td>
        	<td>科技创新</td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${innovate.id }">添加</ll:emptyTag><ll:notEmptyTag value="${innovate.id }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveInnovate.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${innovate.id }" id="id"/>
		<div class="outSideDiv">
		

	
         <div class="inputArea2">
        	<label>实力雄厚：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
	            <textarea id="contentA" name="contentA" rows="25">${innovate.contentA }</textarea>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>高端合作：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
	            <textarea id="contentB" name="contentB" rows="25">${innovate.contentB }</textarea>
				
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>