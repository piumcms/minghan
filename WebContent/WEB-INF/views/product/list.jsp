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
<link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script src="${ly }/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${ly }/js/product.js"></script>
<style type="text/css">
body {
	padding: 0px;
}

.div1 {
	padding: 0px;
}
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
				<td>产品管理</td>
				<td>&gt;</td>
				<th>列表</th>
			</tr>
		</table>
	</div>
	<div class="div1_2">

		<form action="${ly}/product/${brandType}/list.html" method="post"
			id="technologyOrProductList">
			<label>产品名称：</label><input type="text" id="productName" name="productName"
				value="${dto.productName}" />
			<input type="hidden" id="brandType" name="brandType" value="${brandType}"/> 
			<input type="submit" id="selbut" name="selbut" value="查询"/>
			<input type="button" id="addbut" name="addbut" value="新增" onclick="javascript:window.location.href='${ly}/product/${brandType}/showEditProduct.html';"/>
			<ll:tableModel id="tableList" items="${dto.list}" var="bean"
				importable="false" totalRows="${dto.pager.rowCount}"
				batchable="true" editable="true" >
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true"
							width="5%" exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							width="50px" exportable="false" />
						<ll:htmlColumn property="language" title="语言" editable="false"
							width="50px" exportable="false" />
						<ll:htmlColumn property="picSrc" title="产品图片" exportable="true"
							styleClass="table_left_css" width="100px;">
							<img src="${bean.picSrc}" id="img"
								style="width: 100px; height: 100px;" />
						</ll:htmlColumn>
						<ll:htmlColumn property="productName" title="产品名称"
							exportable="true" styleClass="table_left_css" width="100px">
							${bean.productName}
						</ll:htmlColumn>

						<%-- <ll:htmlColumn property="productDesc" title="产品描述"
							exportable="true" styleClass="table_left_css">
							<c:choose>
								<c:when test="${fn:length(bean.productDesc) > 240}">
									<div>${fn:substring(bean.productDesc, 0, 240)}..."</div>
								</c:when>
								<c:otherwise>
									<div>${bean.productDesc}</div>
								</c:otherwise>
							</c:choose>
						</ll:htmlColumn> --%>

						<ll:htmlColumn property="taobaoUrl" title="淘宝地址" exportable="true"
							styleClass="table_left_css">
							      ${bean.taobaoUrl}
						</ll:htmlColumn>
						<ll:htmlColumn property="pw" title="推送首页" exportable="true"
							styleClass="table_left_css" width="100px">
							<c:choose>
								<c:when test="${not empty bean.pw && bean.pw eq '1'}">
									是
								</c:when>
								<c:otherwise>
									否
								</c:otherwise>
							</c:choose>
						</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间"
							exportable="false" width="100px">
							<fmt:formatDate value="${bean.createTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false">
							<a href="javascript:sendToFrontpage(${bean.id})">推送首页</a>|
						   <a href="javascript:editProduct(${bean.id}, ${dto.pageNumber }, '${dto.tableId }', '${dto.productName }');">编辑</a>|
                           <a href="javascript:delProduct(${bean.id});">删除</a>|
                           <a href="${ly}/product/${brandType}/assignedCategory.html?id=${bean.id}">指定分类</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
	</div>
</body>
</html>
