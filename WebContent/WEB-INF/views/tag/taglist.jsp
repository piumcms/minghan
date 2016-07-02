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
<script type="text/javascript" src="${ly }/js/taglist.js"></script>
<%-- <link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script src="${ly }/kindeditor/lang/zh_CN.js"></script> --%>
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
				<td>标签管理</td>
			</tr>
		</table>
	</div>
	<div class="div1_2">

		<form action="#" method="post"
			id="technologyOrProductList">
			<%-- <input type="hidden" id="brandType" name="brandType" value="${brandType}"/>  --%>
			<input type="button" id="addbut" name="addbut" value="新增" onclick="javascript:window.location.href='${ly}/tag/addTag.html';"/>
			<ll:tableModel id="tagList" items="${dto.list}" var="bean"
				importable="false" totalRows="${dto.pager.rowCount}"
				batchable="false" editable="true">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true"
							width="5%" exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							width="5%" exportable="false" />
						<ll:htmlColumn property="tag" title="标签名" editable="false"
							width="15%" exportable="false" />
						<ll:htmlColumn property="title" title="title" editable="false"
							width="10%" exportable="false" />
						<ll:htmlColumn property="keyWords" title="key_words" editable="false"
							width="10%" exportable="false" />
						<ll:htmlColumn property="des" title="description" editable="false"
							width="15%" exportable="false" />
						<ll:htmlColumn property="falseUrl" title="自定义地址" editable="false"
							width="15%" exportable="false" />
						<ll:htmlColumn property="seq" title="排序" editable="false"
							width="5%" exportable="false" />						
						<ll:htmlColumn property="disabled" title="是否显示" editable="false"
							width="5%" exportable="false">
							<c:if test="${bean.disabled == 0 }"><span style="color:red;">是</span></c:if>
							<c:if test="${bean.disabled == 1 ||bean.disabled == null}">否</c:if>	
						</ll:htmlColumn>	
						<ll:htmlColumn property="flag" title="操作" exportable="false" width="10%">
						   <a href="${ly}/tag/aditTag.html?id=${bean.id}">编辑</a>
						   <a href="javascript:delTag(${bean.id});">删除</a>|
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
	</div>
</body>
</html>
