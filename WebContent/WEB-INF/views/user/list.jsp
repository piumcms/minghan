<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/views/meta.jsp"%>
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}

</style>
</head>
<body>
	<div class="topPathArea">
		<table>
			<colgroup width="30px" />
			<tr>
				<td><img src="${ly}/images/localPlace.jpg" /></td>
				<td>系统管理</td>
				<td>&gt;</td>
				<td>会员管理</td>
				<td>&gt;</td>
				<th>列表</th>
			</tr>
		</table>
	</div>
	<div class="div1_2">
 			<form action="${ly}/user/list" method="post" id="technologyOrProductList">
			<ll:tableModel id="userList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}">
				<ll:htmlTable caption="Presidents">
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
                            <a href="${ly }/user/deleteAdmin.html/${bean.id}">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
				
			</ll:tableModel>
			
			</form>
		</div>
</body>
</html>
