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
<script charset="utf-8" src="${ly }/js/attri.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}
</style>
</head>
<body>
	<div class="divn1_1">系统管理&gt;&gt; 商品属性管理</div>
	<div class="div1_2">
	
	 <form action="${ly}/brand/attriList.html" method="post" id="technologyOrProductList">
	  商品属性：<input type="text" id="name" name="name" value="${dto.name }" /> <input type="submit" id="selbut" value="查询" > 
	 </form>
    <form action="${ly}/brand/attriList.html" method="post" id="technologyOrProductList">
			<ll:tableModel id="attriList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="5%"
							exportable="false" />
						<ll:htmlColumn property="name" title="商品属性名称" exportable="true" styleClass="table_left_css" width="5%">
							${bean.name}
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false" width="5%">
                           <a href="javascript:editAttribute(${bean.id});">编辑</a>|
                           <a href="javascript:delAttribute(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
		</div>
</body>
</html>
