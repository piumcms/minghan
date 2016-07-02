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
<script charset="utf-8" src="${ly }/js/sku.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}
</style>
</head>
<body>
	<div class="divn1_1">系统管理&gt;&gt; 商品管理</div>
	<div class="div1_2">
	 <form action="${ly}/brand/skuList.html" method="post" id="technologyOrSkuList">
	 <label>选择品牌：</label>
	            <select id="choose" name="tableId">
	            	<option value="">-请选择-</option>
	            	<c:forEach items="${list }" var="bean">
	            		<c:if test="${dto.tableId == bean.id }">
	            			<option value="${bean.id }" selected="selected">${bean.brand }</option>
	            		</c:if>
	            		<c:if test="${dto.tableId != bean.id }">
	            			<option value="${bean.id }">${bean.brand }</option>
	            		</c:if>
	            	</c:forEach>
	            </select> &nbsp;
	 
	   商品属性：<input type="text" id="attributeName" name="attributeName" value="${dto.attributeName}" />
	   商品名称：<input type="text" id="productName" name="productName" value="${dto.productName}" /> <input type="submit" id="selbut" value="查询" > 
			<ll:tableModel id="skuList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}" batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
					<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
					<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="5%"
							exportable="false" />
					<ll:htmlColumn property="src" title="商品图片" exportable="true" styleClass="table_left_css">
						  <img src="${bean.src}" id="img" width="120" height="80"  />
						</ll:htmlColumn>
						<ll:htmlColumn property="productName" title="商品名称" exportable="true" styleClass="table_left_css" width="15%">
							${bean.productName}
						</ll:htmlColumn>
						<ll:htmlColumn property="attributeName" title="属性" exportable="true" styleClass="table_left_css" width="15%">
							${bean.attributeName}
						</ll:htmlColumn>
						<ll:htmlColumn property="info" title="品牌概要" exportable="true" styleClass="table_left_css">
                         <c:choose> 
     <c:when test="${fn:length(info) > 20}"> 
        <label title="${bean.info }">${fn:substring(bean.info, 0, 20)}...</label>
     </c:when> 
     <c:otherwise> 
      <c:out value="${bean.info}" /> 
     </c:otherwise>
    </c:choose>
						</ll:htmlColumn>
						<ll:htmlColumn property="pw" title="排位" exportable="true" styleClass="table_left_css" width="15%">
							${bean.pw}
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false" width="10%">
                           <a href="javascript:editSku(${bean.id}, '${dto.tableId }', ${dto.pageNumber }, '${dto.attributeName}', '${dto.productName }');">编辑</a>|
                           <a href="javascript:delSku(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
		</div>
</body>
</html>
