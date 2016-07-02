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
<title>权限修改</title>
<script type="text/javascript">
$(document).ready(function() { 
	
	$("#submit").click(function() {
		var obj = new Object();
		obj.id = $("#id").val();
		var memo = $("#memo").val();
		if (memo == "") {
			$.messager.alert('云盛信息管理系统','角色名称不能为空','warning');
			return false;
		}
		obj.memo = memo;
		var name = $("#name").val();
		if (name == "") {
			$.messager.alert('云盛信息管理系统','角色英文名称不能为空','warning');
			return false;
		}
		obj.name = name;
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/menu/saveAuthorites.html',
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
				
				window.location.href=getRootPath() + "/menu/list.html";
		
			},
			 complete: function(XMLHttpRequest, textStatus){
				 $.messager.progress('close');
		        },
	        error:function(jqXHR, textStatus, errorThrown){
	        	top.location.href=getRootPath() + "/common/error";
	        }
	    });
	});
	
	$("input[type='checkbox']").click(function() {
		var name = $(this).attr("name");
		var first_c = name.substring(0, 1);
		var other_c = name.substring(1);
		if (first_c == 'p') {
			if (!$(this).attr("checked")) {
				$("input[name='c"+other_c+"']").attr("checked", false);
			} else {
				var arr = $("input[name='c"+other_c+"']:checked");
				if (arr.length == 0) {
					$("input[name='c"+other_c+"']").attr("checked" , "checked");
				}
			}
		} else {
			if ($(this).attr("checked")) {
				if (!$("input[name='p"+other_c+"']").attr("checked")) {
					$("input[name='p"+other_c+"']").attr("checked", "checked");
				}
			} else {
				var arr = $("input[name='c"+other_c+"']:checked");
				if (arr.length <= 0) {
					$("input[name='p"+other_c+"']").attr("checked", false);
				}
			}
		}
	});
});


</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>角色权限</td><td>&gt;</td>
        	<td>
				权限设置        		
            </td>
            <td>&gt;</td>
            <th>编辑</th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveElegant.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${role.id}" id="id"/>
	
		<div class="outSideDiv">
			<div class="inputArea2">
	        	<label>角色名称：</label>
	        	<div style="float: left;display: inline;width: 650px;">
		            <input type="text" id="memo" name="memo" style="width:200px;" value="${role.memo }"/>
				</div>
	        </div>
	        
	        <div class="inputArea2" id="nSource">
	        	<label>角色英文名称：</label>
	        	<div style="float: left;display: inline;width: 650px;">
		            <input type="text" id="name" name="name" style="width:200px;" value="${role.name }"/>
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