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
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<title>关于云盛信息</title>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content"]', {
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
		obj.newsTypeId = $("#newsTypeId").val();
		var title = $("#title").val();
		if (title == "") {
			$.messager.alert('云盛信息管理系统','标题不能为空','warning');
			return false;
		}
		obj.title = title;
		
		var yearMonth = $("#yearMonth").val();
		if (yearMonth == "") {
			$.messager.alert('云盛信息管理系统','所属日期不能为空','warning');
			return false;
		}
	
		obj.yearM = yearMonth;
		var pic = $("#picture").val();
		if (pic == "") {
			$.messager.alert('云盛信息管理系统','请上传封面','warning');
			return false;
		}
		obj.picture = pic;
		var videoUrl = $("#videoUrl").val();
		if (videoUrl == "") {
			$.messager.alert('云盛信息管理系统','请上传视频','warning');
			return false;
		}
		obj.videoUrl = videoUrl;
		var brief = $("#brief").val();
		if (brief == "") {
			$.messager.alert('云盛信息管理系统','内容简介不能为空','warning');
			return false;
		}
		obj.brief = brief;
		var html = editor1.html();
		if (html == "") {
			$.messager.alert('云盛信息管理系统','内容描述不能为空','warning');
			return false;
		}
		obj.content = html;
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/about/saveElegant.html',
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
				window.location.href=getRootPath() + "/about/listElegant.html?newsTypeId=" + $("#newsTypeId").val() + "&pageNumber=" + $("#pageNumber").val();
		
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>关于云盛信息</td><td>&gt;</td>
        	<td>
				集团风采        		
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${honour.content }">添加</ll:emptyTag><ll:notEmptyTag value="${honour.content }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveElegant.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${honour.id }" id="id"/>
	<input type="hidden" name="newsTypeId" value="${honour.newsTypeId }" id="newsTypeId"/>
	<input type="hidden" name="pageNumber" id="pageNumber" value="${pageNumber }"> 
		<div class="outSideDiv">
		<div class="inputArea2">
        	<label>标题：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="title" value="${honour.title }" name="title"/>
			</div>
        </div>
		
		<div class="inputArea2">
        	<label>日期：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input class="Wdate" type="text"  id="yearMonth" name="yearMonth" value="${honour.yearM }"  onfocus="WdatePicker({dateFmt:'yyyy'})" 
             readonly="readonly" style="margin-left:6px;">
			</div>
        </div>
		
		<div class="inputArea2">
        	<label>上传封面：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<ll:emptyTag value="${honour.picture }">
        		<img src="${ ly}/upload/article/image/${honour.picture}" id="img" width="150" height="150"/>
        		</ll:emptyTag>
        		<ll:notEmptyTag value="${honour.picture }">
        			<img src="${ ly}/upload/article/image/${honour.picture}" id="img" width="150" height="150"/>
        		</ll:notEmptyTag>
	            <input type="hidden" id="picture" value="${honour.picture }" name="picture"/> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
		<div class="inputArea2">
        	<label>上传视频：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="videoUrl" value="${honour.videoUrl }" name="videoUrl"/> <input type="button" id="insertfile" value="选择文件" />
			</div>
        </div>
        
		<div class="inputArea2">
        	<label>内容简介：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <textarea id="brief" name="brief" rows="10">${honour.brief }</textarea>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>内容描述：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
	            <textarea id="content" name="content" rows="25">${honour.content }</textarea>
				
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>