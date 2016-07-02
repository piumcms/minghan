<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		$("#submit").click(function() {
			var obj = new Object();
			var memo = $("#memo").val();
			if (memo == "") {
				$.messager.alert('飞世龙机电信息管理系统','角色名称不能为空','warning');
				return false;
			}
			obj.memo = memo;
			var name = $("#name").val();
			if (name == "") {
				$.messager.alert('飞世龙机电信息管理系统','角色英文名称不能为空','warning');
				return false;
			}
			obj.name = name;
			var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/menu/saveRoles.html',
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
					var msg = result.msg;
					var arr = msg.split("_");
					if (parseInt(arr[0]) == 1) {
						$.messager.alert('飞世龙机电信息管理系统', arr[1]);
						return false;
					} else {
						$.messager.alert('飞世龙机电信息管理系统', arr[1]);
					}
					
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
	});
</script>
</head>
<body>

		<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
        	<td>
	        	角色管理
            </td>
            <td>&gt;</td>
            <th>添加角色</th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveElegant.html" method="post" id="jsonForm">
		<div class="outSideDiv">
		

		<div class="inputArea2">
        	<label>角色名称：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="memo" name="memo" style="width:200px;"/>
			</div>
        </div>
        
        <div class="inputArea2" id="nSource">
        	<label>角色英文名称：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="name" name="name" style="width:200px;"/>
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
