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
	<div class="divn1_1">系统管理&gt;&gt; 产品管理</div>
	<div class="div1_2">

		<form action="${ly}/brand/productList.html" method="post"
			id="technologyOrProductList">

			<label>选择品牌：</label> <select id="choose" name="tableId">
				<option value="">-请选择-</option>
				<c:forEach items="${list }" var="bean">
					<c:if test="${dto.tableId == bean.id }">
						<option value="${bean.id }" selected="selected">${bean.brand
							}</option>
					</c:if>
					<c:if test="${dto.tableId != bean.id }">
						<option value="${bean.id }">${bean.brand }</option>
					</c:if>
				</c:forEach>
			</select> &nbsp; 产品名称：<input type="text" id="productName" name="productName"
				value="${dto.productName}" /> <input type="submit" id="selbut"
				value="查询">
			<ll:tableModel id="productList" items="${dto.list}" var="bean"
				importable="false" totalRows="${dto.pager.rowCount}"
				batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true"
							width="5%" exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
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

						<ll:htmlColumn property="productDesc" title="产品描述"
							exportable="true" styleClass="table_left_css">
							<c:choose>
								<c:when test="${fn:length(bean.productDesc) > 240}">
									<div>${fn:substring(bean.productDesc, 0, 240)}..."</div>
								</c:when>
								<c:otherwise>
									<div>${bean.productDesc}</div>
								</c:otherwise>
							</c:choose>
						</ll:htmlColumn>

						<ll:htmlColumn property="taobaoUrl" title="淘宝地址" exportable="true"
							styleClass="table_left_css">
							      ${bean.taobaoUrl}
						</ll:htmlColumn>
						<ll:htmlColumn property="pw" title="产品排位" exportable="true"
							styleClass="table_left_css" width="100px">
							${bean.pw}
						</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间"
							exportable="false">
							<fmt:formatDate value="${bean.createTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false"
							width="100px">
							<a
								href="javascript:editProduct(${bean.id}, ${dto.pageNumber }, '${dto.tableId }', '${dto.productName }');">编辑</a>|
                           <a href="javascript:delProduct(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
	</div>
</body>
</html>
