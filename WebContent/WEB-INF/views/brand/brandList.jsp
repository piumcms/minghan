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
<script charset="utf-8" src="${ly }/js/brand.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}
</style>
</head>
<body>
	<div class="divn1_1">系统管理&gt;&gt; 品牌管理</div>
	<div class="div1_2">
	
	 <form action="${ly}/brand/brandList.html" method="post" id="technologyOrProductList">
	  品牌：<input type="text" id="brand" name="brand" value="${dto.brand }" /> <input type="submit" id="selbut" value="查询" > <input type="button" value="新建" onclick="addBrand()">
	 </form>
 <form action="${ly}/brand/brandList.html" method="post" id="technologyOrProductList">
			<ll:tableModel id="brandList" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}" batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
					<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="50px"
							exportable="false" />
						<ll:htmlColumn property="memo" title="品牌名称" exportable="true" styleClass="table_left_css" width="80px">
							${bean.brand}
						</ll:htmlColumn>
						<ll:htmlColumn property="url" title="品牌链接" exportable="true" styleClass="table_left_css"  width="100px">
						   <a href="http://${bean.url}" target="_blank" > ${bean.url}</a>
						</ll:htmlColumn>
						<ll:htmlColumn property="picSrc" title="品牌Logo" exportable="true" styleClass="table_left_css">
						  <img src="${bean.picSrc}" id="img" width="100px" />
						</ll:htmlColumn>
						<ll:htmlColumn property="bannerPic" title="品牌Banner图" exportable="true" styleClass="table_left_css">
						   <img src="${bean.bannerPic}" id="img" width="220"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="brandImage" title="品牌链接" exportable="true" styleClass="table_left_css">
						    <img src="${bean.brandImage}" id="img" width="220"/>
						</ll:htmlColumn>
					
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false" width="100px" >
                           <a href="javascript:editBrand(${bean.id});">编辑</a>|
                           <a href="javascript:delBrand(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
		</div>
</body>
</html>
