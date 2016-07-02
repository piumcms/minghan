<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/resource.inc"%>
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly}/js/news.js"></script>
<title>新闻管理.新闻类别列表</title>
</head>
<body>
	<div class="topPathArea">
		<table>
			<colgroup width="30px" />
			<tr>
				<td><img src="${ly}/images/localPlace.jpg" />
				</td>
				<td>系统管理</td>
				<td>&gt;</td>
				<td>新闻管理</td>
				<td>&gt;</td>
				<th>新闻类别列表</th>
			</tr>
		</table>
	</div>
	<div style="float: left; width: 100%;">
		<form action="${ly}/news/shownewstypelist.html" method="post"
			id="shownewstype">
			新闻类别：<input type="text" id="categoryName" name="categoryName"
				value="${categoryName }" /> <input type="submit" id="selbut"
				value="查询">
		</form>
		<form action="${ly}/news/shownewstypelist.html" method="post"
			id="shownewstype">
			<ll:tableModel id="brandList" items="${dto.list}" var="bean"
				importable="false" totalRows="${dto.pager.rowCount}">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							exportable="false" />
						<ll:htmlColumn property="categoryName" title="新闻类别名称"
							exportable="true" styleClass="table_left_css">
							${bean.categoryName}
						</ll:htmlColumn>
						<ll:htmlColumn property="caozuo" title="操作" exportable="false">
							<a href="javascript:editNewsType(${bean.id});">编辑</a>|
                           <a href="javascript:delNewsType(${bean.id});">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
	</div>
</body>
</html>