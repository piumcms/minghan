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
		var tag = $("#tag").val();
		if (tag == "") {
			$.messager.alert('明翰CMS管理系统','标签不能为空','warning');
			return false;
		}
		obj.tag = tag;	
		var title = $("#title").val();
		if (title == "") {
			$.messager.alert('明翰CMS管理系统','title不能为空','warning');
			return false;
		}
		obj.title = title;
		var key_words = $("#keyWords").val();
		if (key_words == "") {
			$.messager.alert('明翰CMS管理系统','keyWords不能为空','warning');
			return false;
		}
		obj.keyWords = key_words;
		var des = $("#des").val();
		obj.des = des;
		var seq = $("#seq").val();
		if (seq == "") {
			$.messager.alert('明翰CMS管理系统','排序不能为空','warning');
			return false;
		}
		obj.seq = seq;
		obj.disabled=$('select[name="disabled"]').val();
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/tag/saveTag.html',
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
			
				$.messager.alert('明翰CMS管理系统',result.msg);
		
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>明翰集团</td><td>&gt;</td>
        	<td>
        		关键字
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${tag.id }">添加</ll:emptyTag><ll:notEmptyTag value="${tag.id }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveIntr.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${tag.id }" id="id"/>
		<div class="outSideDiv">
        <div class="inputArea2">
        	<label>标签：</label>
        	<div style="float: left;display: inline;width: 650px;">
				<input type="text"  name="title" value="${tag.tag }"  id="tag"/>
			</div>
        </div>
         <div class="inputArea2">
        	<label>title：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<input type="text"  name="keyWords" value="${tag.title }"  id="title"/>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>keyWords：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<input type="text"  name="desC1" value="${tag.keyWords }"  id="keyWords"/>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>description：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<input type="text"  name="desC1" value="${tag.des }"  id="des"/>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>排序：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<input type="text"  name="desC1" value="${tag.seq }"  id="seq"/>
				
			</div>
        </div>
        <div class="inputArea2">
        	<label>是否显示：</label>
        	<div style="float: left;display: inline;width: 152px;">
        		<select  name="disabled" style="width: 150px;">
        		<c:if test="${tag.disabled == '1'}"    >
        			<option value='1' selected="selected">不显示</option>
        			<option value='0'>显示</option>
        		</c:if>
        		<c:if test="${tag.disabled == '0'}"    >
        			<option value='1' >不显示</option>
        			<option value='0' selected="selected">显示</option>
        		</c:if>
        		<c:if test="${tag.disabled == null}"    >
        			<option value='1' >不显示</option>
        			<option value='0' >显示</option>
        		</c:if>
        		</select>
				
			</div>
        </div>
        
        <div class="inputArea1" style="text-align: center;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>