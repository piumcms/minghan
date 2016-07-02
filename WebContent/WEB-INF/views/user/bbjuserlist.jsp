<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}

</style>
<script>
$(document).ready(function() { 

$("#export_1").click(function() {
	

    $.ajax({
    	type : 'POST',
		url : getRootPath()+'/user/userExport',	
		/**success : function(result) {
			$.messager.alert('云盛信息管理系统',result.msg);
			window.location.href=getRootPath() + "/user/bbjuserlist.html";
		},
		 complete: function(XMLHttpRequest, textStatus){
			 $.messager.progress('close');
	        },
        error:function(jqXHR, textStatus, errorThrown){
        	top.location.href=getRootPath() + "/common/error";
        }**/
    });
});
});
</script>
</head>
<body>
	<div class="divn1_1">系统管理&gt;&gt;活动会员管理</div>
	<br><br><br>
	<div class="div_exportUser">
		<input id="exportUser" type=button onclick="window.open('${ly}/user/userExport')" value="导出Excel文件">
	</div>
	<div class="div1_2">
 			<form action="${ly}/user/bbjuserlist" method="post" id="technologyOrProductList">
			<ll:tableModel id="userList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							exportable="false" />
						<ll:htmlColumn property="username" title="用户名" exportable="true" styleClass="table_left_css">
							${bean.username}
						</ll:htmlColumn>
				        <ll:htmlColumn property="mobilePhone" title="手机" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="email" title="邮箱" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="province" title="省份" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="address" title="详细地址" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="createTime" title="活动提交时间" exportable="true">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="roleId" title="操作" exportable="false" width="10%">
                            <a href="${ly}/user/deleteAdmin.html/${bean.id}">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
				
			</ll:tableModel>
			
			</form>
		</div>
</body>
</html>
