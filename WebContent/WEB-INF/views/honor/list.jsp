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
<script charset="utf-8" src="${ly }/js/honor.js"></script>
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
					<td>企业荣誉</td>
					<td>&gt;</td>
					<th>列表</th>
				</tr>
			</table>
		</div>
	<div class="div1_2">

		<form action="${ly}/honor/${siteName}/list.html" method="post"
			id="technologyOrDownloadList">
			<label>荣誉名称：</label><input type="text" id="title" name="title"
				value="${dto.title}" />
			<input type="hidden" id="siteName" name="siteName" value="${siteName}"/> 
			<input type="submit" id="selbut" name="selbut" value="查询"/>
			<input type="button" value="新增" 
				onclick="javascript:window.location.href='${ly}/honor/${siteName}/showEditDownCenter.html';"/>
			<ll:tableModel id="downloadList" items="${dto.list}" var="bean"
				importable="false" totalRows="${dto.pager.rowCount}"
				batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" style="width:99%;">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true" width="80px" exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="50px" exportable="false" />
						<%-- <ll:htmlColumn property="language" title="语言" editable="false"
							width="50px" exportable="false" /> --%>
						<ll:htmlColumn property="title" title="荣誉名称"
							exportable="true" styleClass="table_left_css">
							${bean.title}
						</ll:htmlColumn>
						<ll:htmlColumn property="url" title="荣誉图片" exportable="true"
							styleClass="table_left_css">
							<img src="${bean.picture}" id="img"
								style="width: 100px; height: 100px;" />
						</ll:htmlColumn>
						<ll:htmlColumn property="category" title="荣誉类别"
							exportable="true" styleClass="table_left_css">
							<c:choose>
								<c:when test="${bean.category=='patent'}">专利证书</c:when>
								<c:when test="${bean.category=='authentication'}">认证证书</c:when>
								<c:when test="${bean.category=='collect'}">采标证明</c:when>
								<c:when test="${bean.category=='high_quality'}">高品证书</c:when>
								<c:when test="${bean.category=='3c'}">3C证书</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间"
							exportable="false">
							<fmt:formatDate value="${bean.createTime}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</ll:htmlColumn>
						<ll:htmlColumn property="flag" title="操作" exportable="false">
						   <a href="javascript:editDownload(${bean.id}, ${dto.pageNumber }, '${dto.siteName }', '${dto.title }');">编辑</a>|
                           <a href="javascript:delDownload(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
	</div>
</body>
</html>
