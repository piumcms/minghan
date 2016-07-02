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
<link href="${ly }/js/calendarControl/skin/default/datepickersel.css">
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="${ly }/kindeditor/lang/zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<title>关于飞世机机电</title>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.editor({
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	K('#image3').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					K('#picture').val(url);
					$("#img").attr('src', url);
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
		var path = $("#picture").val();
		if (path == "") {
			$.messager.alert('飞世机机电管理系统','请上传图片','warning');
			return false;
		}
		obj.path = path;
		var url = $("#url").val();
		if (url == "") {
			$.messager.alert('飞世机机电管理系统','请填写图片链接','warning');
			return false;
		}
	
		obj.url = url;
		var alt = $("#alt").val();
		if (alt == "") {
			$.messager.alert('飞世机机电管理系统','请填写图片替换文字','warning');
			return false;
		}
		obj.alt = alt;
		
		var pw = $("#pw").val();
		if (pw == "") {
			$.messager.alert('飞世机机电管理系统','请填写先后顺序','warning');
			return false;
		}
		obj.pw = pw;
		
		obj.brandType = $("#brandType").val();
		obj.language = $("#language").val();
		
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/pic/savePic.html',
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
				$.messager.alert('飞世机机电管理系统',result.msg);
				window.location.href=getRootPath() + "/pic/"+result.brandType+"/listPic.html";
		
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>首页图片</td><td>&gt;</td>
        	<td>
				首页图片      		
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${picture.id }">添加</ll:emptyTag><ll:notEmptyTag value="${picture.id }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/pic/savePic.html" method="post" id="jsonForm">
		<input type="hidden" name="id" value="${picture.id }" id="id"/>
		<input type="hidden" name="brandType" value="${picture.brandType }" id="brandType"/>
		<div class="outSideDiv">
		
		<div class="inputArea2">
        	<label>语言选择：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <select id="language" name="language" style="width:250px;">
	            	<c:choose>
	            		<c:when test="${picture.language=='zh_CN' }">
	            			<option value="zh_CN" selected="selected">中文</option>
	            		</c:when>
	            		<c:otherwise>
	            			<option value="zh_CN">中文</option>
	            		</c:otherwise>
	            	</c:choose>
	            	
	            	<c:choose>
	            		<c:when test="${picture.language=='en_US' }">
	            			<option value="en_US" selected="selected">英语</option>
	            		</c:when>
	            		<c:otherwise>
	            			<option value="en_US">英语</option>
	            		</c:otherwise>
	            	</c:choose>
	            	
	            	
	            </select>
			</div>
        </div>
		
		<div class="inputArea2">
        	<label>上传图片：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<ll:emptyTag value="${picture.path }">
        		<img src="${ ly}/upload/images/image/${picture.path}" id="img" width="200" height="150"/>
        		</ll:emptyTag>
        		<ll:notEmptyTag value="${picture.path }">
        			<img src="${ ly}/upload/images/image/${picture.path}" id="img" width="150" height="150"/>
        		</ll:notEmptyTag>
	            <input type="hidden" id="picture" value="${picture.path }" name="picture"/> 
	            <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
		<div class="inputArea2">
        	<label>图片链接：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="url" value="${picture.url }" name="url"/>
			</div>
        </div>
        
		<div class="inputArea2">
        	<label>图片替换文字：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="alt" value="${picture.alt }" name="alt"/>
			</div>
        </div>
        <div class="inputArea2">
        	<label>顺序：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="pw" value="${picture.pw }" name="pw"/>
			</div>
        </div>
        <div class="inputArea2">
        	<label></label>
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
    </form>
</body>
</html>