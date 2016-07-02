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
<title>企业新闻</title>
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
		if ($("#createTime").length > 0) {
			if ($("#createTime").val() == "") {
				$.messager.alert('云盛信息管理系统','创建时间不能为空','warning');
				return false;
			}
			obj.createTime = $("#createTime").val();
		}
		
		if (("#nSource").length > 0) {
			obj.newsSource = $("#source").val();
		}
		var pic = $("#picture").val();
		obj.picture = pic;
		if ($("#toMedia").attr("checked")) {
			obj.toMedia = "1";
		} else {
			obj.toMedia = "0";
		}
		
		if ($("#toBrandNews").attr("checked")) {
			obj.toBrandNews = "1";
		} else {
			obj.toBrandNews = "0";
		}
		
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
			url : getRootPath()+'/news/saveNews.html',
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
				window.location.href=getRootPath() + "/news/listNews.html?newsTypeId=" + $("#newsTypeId").val() + "&pageNumber=" + $("#pageNumber").val();
				
		
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>企业新闻</td><td>&gt;</td>
        	<td>
	        	<c:if test="${news.newsTypeId == 5 }">
					集团动态
				</c:if>
				<c:if test="${news.newsTypeId == 6 }">
					媒体报道
				</c:if>
				<c:if test="${news.newsTypeId == 7 }">
					精彩活动
				</c:if>
				<c:if test="${news.newsTypeId == 13 }">
					2014媒体报道
				</c:if>  		
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${news.title }">添加</ll:emptyTag><ll:notEmptyTag value="${news.title }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveElegant.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${news.id }" id="id"/>
	<input type="hidden" name="newsTypeId" value="${news.newsTypeId }" id="newsTypeId"/>
	<input type="hidden" name="pageNumber" id="pageNumber" value="${pageNumber }"> 
		<div class="outSideDiv">
		

		<div class="inputArea2">
        	<label>标题：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="title" value="${news.title }" name="title" style="width:200px;"/>
			</div>
        </div>
        <c:if test="${news.newsTypeId == 5 || news.newsTypeId == 6}">
		<div class="inputArea2">
        	<label>创建时间：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input class="Wdate" type="text"  id="createTime" name="createTime" value='<fmt:formatDate value="${news.createTime }" pattern="yyyy-MM-dd"/>'  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
             readonly="readonly" style="width:200px;">
			</div>
        </div>
        </c:if>
        
        <div class="inputArea2" id="nSource">
        	<label>来源：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="source" value="${news.newsSource }" name="source" style="width:200px;"/>
			</div>
        </div>
		<div class="inputArea2">
        	<label>上传图片：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<ll:emptyTag value="${news.picture }">
        		<img src="${ ly}/upload/article/image/${news.picture}" id="img" width="150" height="150"/>
        		</ll:emptyTag>
        		<ll:notEmptyTag value="${news.picture }">
        			<img src="${ ly}/upload/article/image/${news.picture}" id="img" width="150" height="150"/>
        		</ll:notEmptyTag>
	            <input type="hidden" id="picture" value="${news.picture }" name="picture"/> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        <c:if test="${news.newsTypeId == 5}">
        <div class="inputArea2">
        	<label></label>
        	<div style="float: left;display: inline;width: 650px;">
	           <span><input type="checkbox" value="1" id="toMedia"/>同步媒体活动</span><span><input type="checkbox" value="2" id="toBrandNews"/>同步品牌新闻</span>
				
			</div>
        </div>
        </c:if>
        <div class="inputArea2">
        	<label>内容简介：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <textarea id="brief" name="brief" rows="10">${news.brief }</textarea>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>内容描述：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
	            <textarea id="content" name="content" rows="25">${news.content }</textarea>
				
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>