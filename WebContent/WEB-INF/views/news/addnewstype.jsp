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
<script type="text/javascript" src="${ly}/js/news.js"></script>
<title>新闻管理.新增新闻类别</title>
<script type="text/javascript">
$(document).ready(function() { 
	$("#submit").click(function() {
		var obj = new Object();
		obj.id = $("#id").val();
		obj.category = $("#categoryName").val();
		if (obj.category == "") {
			$.messager.alert('云盛信息管理系统', '新闻类别不能为空!', 'warning');
			return false;
		}
		var jsondata = $.toJSON(obj);
		$.ajax({
			type : 'POST',
			url : getRootPath() + '/news/savenewstype.html',
			data : jsondata,
			dataType : 'json',
			contentType : 'application/json',
			beforeSend : function(XMLHttpRequest) {
				$.messager.progress({
					title : 'Please waiting',
					msg : 'Loading data...'
				});
			},
			success : function(result) {
				$.messager.alert('云盛信息管理系统', result.msg);
			},
			complete : function(XMLHttpRequest, textStatus) {
				$.messager.progress('close');
			},
			error : function(jqXHR, textStatus, errorThrown) {
				top.location.href = getRootPath() + "/common/error";
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
        	<td>
              新闻管理
          </td>
            <td>&gt;</td>
            <th>新增新闻类别</th>
            </tr>
        </table>
    </div>
    <div class="div_content">
    	<form action="${ly }/news/savenewstype.html" method="post" id="jsonForm">
    	<table cellpadding="0" cellspacing="0" width="500" border="0">
    	   <tr>
    	     <td><input type="hidden" id="id" name="id" value="${newsType.id}"/></td><td></td>
    	   </tr>
    	     <tr>
    	     <td>新闻类别</td><td align="left"><input type="text" id="categoryName" name="categoryName" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" value="${newsType.categoryName}"/></td>
    	   </tr>
    	   <tr>
    	     <td></td>
    	     <td align="left">
    	         <input type="button"  id="submit" value="保存"/>
    	     </td>
    	   </tr>
    	</table>
    </form>
    </div>
</body>
</html>