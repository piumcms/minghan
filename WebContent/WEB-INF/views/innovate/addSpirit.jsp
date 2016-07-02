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
<script src="${ly }/kindeditor/lang/zh_CN.js"></script>
<title>创新与生活.生活灵感</title>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="question"]', {
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	
	editor2 = K.create('textarea[name="answer"]', {
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	K('#image1').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#url1').val(),
				clickFn : function(url, title, width, height, border, align) {
					K('#url1').val(url);
					editor1.hideDialog();
				}
			});
		});
	});
});

$(document).ready(function() { 
	
	$("#submit").click(function() {
		var obj = new Object();
		obj.id = $("#id").val();
		/* var brandId = $("#choose").val();
		if (brandId == "") {
			$.messager.alert('云盛信息管理系统','请选择品牌','warning');
			return false;
		}
		obj.brandId = brandId; */
		var question = editor1.html();
		if (question == "") {
			$.messager.alert('云盛信息管理系统','问题描述不能为空','warning');
			return false;
		}
		obj.question = question;
		
		var answer = editor2.html();
		if (answer == "") {
			$.messager.alert('云盛信息管理系统','回答描述不能为空','warning');
			return false;
		}
		obj.answer = answer;
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/innovate/saveQues.html',
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
		
				window.location.href=getRootPath() + "/innovate/listQues.html?pageNumber=" + $("#pageNumber").val() + "&brandId=" + $("#brandId").val();
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>清洁宝典</td><td>&gt;</td>
        	<td>Q&A</td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${innovate.id }">添加</ll:emptyTag><ll:notEmptyTag value="${innovate.id }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveIntr.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${innovate.id }" id="id"/>
	<input type="hidden" name="pageNumber" id="pageNumber" value="${pageNumber }">
	<input type="hidden" name="brandId" id="brandId" value="${brandId }">
		<div class="outSideDiv">
        <div class="inputArea2">
        	<label>问题：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <textarea id="question" name="question" rows="5" cols="25">${innovate.question }</textarea>
				
			</div>
        </div>
		
        <div class="inputArea2">
        	<label>答案：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <textarea id="answer" name="answer" rows="5" cols="25">${innovate.answer }</textarea>
				
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>