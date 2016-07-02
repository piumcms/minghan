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
<title>云盛信息集团</title>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.editor({
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});

	if ($("#picCover").length > 0) {
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
	}
	K('#insertfile').click(function() {
		
		editor1.loadPlugin('insertfile', function() {
			editor1.plugin.fileDialog({
				fileUrl : K('#videoUrl').val(),
				clickFn : function(url, title) {
					K('#videoUrl').val(url);
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
		obj.category = $("#category").val();
		var title = $("#title").val();
		if (title == "") {
			$.messager.alert('云盛信息管理系统','名称不能为空','warning');
			return false;
		}
		obj.title = title;
		if ($("#picCover").length > 0) {
			var picture = $("#picture").val();
			if (picture == "") {
				$.messager.alert('云盛信息管理系统','请上传封面','warning');
				return false;
			}
			obj.picture = picture;
		}
		
		var videoUrl = $("#videoUrl").val();
		if (videoUrl == "") {
			$.messager.alert('云盛信息管理系统','上传内容不能为空','warning');
			return false;
		}
		obj.url = videoUrl;
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/news/saveDownload.html',
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
				$("#title").val("");
				$("#videoUrl").val("");
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>企业新闻&gt;媒体会客室</td><td>&gt;</td>
        	<td>
        		<c:if test="${download.category == '1' }">宣传资料</c:if>
        		<c:if test="${download.category == '2' }">广告短片</c:if>
        		<c:if test="${download.category == '3' }">活动资料</c:if> 
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${download.id }">添加</ll:emptyTag><ll:notEmptyTag value="${download.id }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/newst/saveDownload.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${download.id }" id="id"/>
	<input type="hidden" name="category" value="${download.category }" id="category"/>
		<div class="outSideDiv">
		<div class="inputArea2">
        	<label>资料名称：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="title" value="${download.title }" name="title"/>
			</div>
        </div>
        <c:if test="${download.category == '2' }">
	        <div class="inputArea2" id="picCover">
	        	<label>上传封面：</label>
	        	<div style="float: left;display: inline;width: 650px;">
	        		<ll:emptyTag value="${download.picture }">
	        		<img src="${ ly}/upload/article/image/${download.picture}" id="img" width="150" height="150"/>
	        		</ll:emptyTag>
	        		<ll:notEmptyTag value="${download.picture }">
	        			<img src="${ ly}/upload/article/image/${fn:substring(download.picture, 0, 8)}/${download.picture}" id="img" width="150" height="150"/>
	        		</ll:notEmptyTag>
		            <input type="hidden" id="picture" value="${download.picture }" name="picture"/> <input type="button" id="image3" value="选择图片" />
				</div>
	        </div>
        
        </c:if>
        
		<div class="inputArea2">
		 <c:if test="${download.category == '2' }">
		 	<label>上传视频：</label>
		 </c:if>
		 <c:if test="${download.category != '2' }">
		 	<label>上传资料：</label>
		 </c:if>
        	
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="videoUrl" value="${download.url }" name="url"/> <input type="button" id="insertfile" value="选择文件" />
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>