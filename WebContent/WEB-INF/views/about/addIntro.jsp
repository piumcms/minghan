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
<title>关于<spring:message code="zkmed.index"/>.集团简介</title>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="content"]', {
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
		obj.category = $("#category").val();
		obj.brandType = $("#brandType").val();
		obj.language = $("#language").val();
		var html = editor1.html();
		if (html == "") {
			$.messager.alert('<spring:message code="zkmed.index"/>管理系统','内容描述不能为空','warning');
			return false;
		}
		if (editor1.isEmpty()) {
			$.messager.alert('<spring:message code="zkmed.index"/>管理系统','内容描述不能为空','warning');
			return false;
		}
		obj.content = editor1.html();
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/about/saveIntr.html',
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
			
				$.messager.alert('<spring:message code="zkmed.index"/>管理系统',result.msg);
		
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
        	<tr>
        		<td><img src="${ly}/images/localPlace.jpg"/></td>
        		<td>关于
        			<c:if test="${about.brandType == 'cheerwin' }">超威日化</c:if>
        			<c:if test="${about.brandType == 'superb' }">超威</c:if>
        			<c:if test="${about.brandType == 'beibeij' }">贝贝健</c:if>
        			<c:if test="${about.brandType == 'xilan' }">西兰</c:if>
        			<c:if test="${about.brandType == 'vewin' }">威王</c:if>
        			<c:if test="${about.brandType == 'zkmed' }"><spring:message code="zkmed.index"/></c:if>
				</td>
        		<td>&gt;</td>
	        	<td>
	        		<c:if test="${about.category == 'brand_profile' }">品牌简介</c:if>
	        		<c:if test="${about.category == 'honor' }">获取荣誉</c:if>
	        		<c:if test="${about.category == 'exciting_activities' }">精彩活动</c:if>
	        		<c:if test="${about.category == 'discovery' }">发现之旅</c:if>
	        		<c:if test="${about.category == 'incense_test' }">寻香测试</c:if>
	        		<c:if test="${about.category == 'aroma' }">香气百科</c:if>
	        		<c:if test="${about.category == 'vision_values' }">愿景&价值观</c:if>
	            </td>
	            <td>&gt;</td>
	            <th>
	            	<ll:emptyTag value="${about.content }">添加</ll:emptyTag>
	            	<ll:notEmptyTag value="${about.content }">编辑</ll:notEmptyTag>
	            </th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveIntr.html" method="post" id="jsonForm">
		<input type="hidden" name="id" value="${about.id }" id="id"/>
		<input type="hidden" name="category" value="${about.category }" id="category"/>
		<input type="hidden" name="brandType" value="${about.brandType }" id="brandType"/>
		<div class="outSideDiv">
			<div class="inputArea2">
	        	<label>语言选择：</label>
	        	<div style="float: left;">
		            <select id="language" name="language" style="width:250px;">
		            	<c:choose>
		            		<c:when test="${about.language=='zh_CN' }">
		            			<option value="zh_CN" selected="selected">中文</option>
		            		</c:when>
		            		<c:otherwise>
		            			<option value="zh_CN">中文</option>
		            		</c:otherwise>
		            	</c:choose>
		            	
		            	<c:choose>
		            		<c:when test="${about.language=='en_US' }">
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
	        	<label>内容描述：</label>
	        	<div style="float: left;width: 850px;height: 380px;">
		            <textarea id="content" name="content" rows="18" >${about.content }</textarea>
				</div>
	        </div>
	        <div class="inputArea1">
	        	<label></label>
	            <input type="button" value="保存" id="submit"/>
	        </div>
	   	 </div>
    </form>
</body>
</html>