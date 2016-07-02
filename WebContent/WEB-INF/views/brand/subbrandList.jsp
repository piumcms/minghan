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
<script charset="utf-8" src="${ly }/js/subbrand.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}
</style>
</head>
<body>
	<div class="divn1_1">系统管理&gt;&gt; 子品牌管理</div>
	<div class="div1_2">
	
	 <form action="${ly}/brand/subbrandList.html" method="post" id="technologyOrProductList">
	 
	 <label>选择父品牌：</label>
	            <select id="choose" name="brandId">
	            	<option value="">-请选择-</option>
	            	<c:forEach items="${list }" var="bean">
	            		<c:if test="${dto.brandId == bean.id }">
	            			<option value="${bean.id }" selected="selected">${bean.brand }</option>
	            		</c:if>
	            		<c:if test="${dto.brandId != bean.id }">
	            			<option value="${bean.id }">${bean.brand }</option>
	            		</c:if>
	            	</c:forEach>
	            </select> <input type="submit" id="selbut" value="查询" >
			<ll:tableModel id="brandList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}" editable="true" batchable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
					<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="50px"
							exportable="false" />
						<ll:htmlColumn property="memo" title="品牌名称" exportable="true" styleClass="table_left_css" width="80px">
							${bean.brand}
						</ll:htmlColumn>
						<ll:htmlColumn property="url" title="品牌链接" exportable="true" styleClass="table_left_css" width="100px">
						   <a href="http://${bean.url}" target="_blank" > ${bean.url}</a>
						</ll:htmlColumn>
						<ll:htmlColumn property="picSrc" title="品牌Logo" exportable="true" styleClass="table_left_css">
						  <img src="${bean.picSrc}" id="img" width="120px" />
						</ll:htmlColumn>
						<ll:htmlColumn property="brandDesc" title="品牌概要" exportable="true" styleClass="table_left_css">
                         <c:choose> 
     <c:when test="${fn:length(subBrandDesc) > 20}"> 
        <label title="${bean.subBrandDesc }">${fn:substring(bean.subBrandDesc, 0, 20)}...</label>
     </c:when> 
     <c:otherwise> 
      <c:out value="${bean.subBrandDesc}" /> 
     </c:otherwise>
    </c:choose>
						</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false" width="150px">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false" width="100px">
                           <a href="javascript:editBrand(${bean.id}, ${dto.pageNumber });">编辑</a>|
                           <a href="javascript:delBrand(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
		</div>
</body>
</html>
