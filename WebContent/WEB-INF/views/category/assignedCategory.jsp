<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<title>权限修改</title>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#submit").click(
										function() {
											var obj = new Object();
											obj.id = $("#id").val();
											var outerArray = new Array();

											$("input[type='checkbox']:checked").each(
												function() {
													outerArray.push($(this).val());
											});
											if (outerArray.length <= 0) {
												$.messager.alert('飞世龙机电信息管理系统',
														'请为产品选择分类类别!');
												return;
											}
											obj.ids = outerArray.join(",");
											var jsondata = $.toJSON(obj);

											$.ajax({
														type : 'POST',
														url : getRootPath()
																+ '/product/saveRelatedCates.html',
														data : jsondata,
														dataType : 'json',
														contentType : 'application/json',
														beforeSend : function(XMLHttpRequest) {
															$.messager.progress({
																title : 'Please waiting',
																msg : 'Loading data...'
															});
														},
														success : function(result) {
															$.messager.alert('飞世龙机电信息管理系统',	result.msg);
															window.location.href = getRootPath()
																	+ "/product/${brandType}/list.html";
														},
														complete : function(XMLHttpRequest,textStatus) {
															$.messager.progress('close');
														},
														error : function(jqXHR,textStatus,errorThrown) {
															top.location.href = getRootPath()
																	+ "/common/error";
														}
													});
										});

						$("input[type='checkbox']").click(
								function() {
									var name = $(this).attr("name");
									var first_c = name.substring(0, 1);
									var other_c = name.substring(1);
									if (first_c == 'p') {
										if (!$(this).attr("checked")) {
											$("input[name='c" + other_c + "']")
													.attr("checked", false);
										} else {
											var arr = $("input[name='c"
													+ other_c + "']:checked");
											if (arr.length == 0) {
												$(
														"input[name='c"
																+ other_c
																+ "']").attr(
														"checked", "checked");
											}
										}
									} else {
										if ($(this).attr("checked")) {
											if (!$(
													"input[name='p" + other_c
															+ "']").attr(
													"checked")) {
												$(
														"input[name='p"
																+ other_c
																+ "']").attr(
														"checked", "checked");
											}
										} else {
											var arr = $("input[name='c"
													+ other_c + "']:checked");
											if (arr.length <= 0) {
												$(
														"input[name='p"
																+ other_c
																+ "']").attr(
														"checked", false);
											}
										}
									}
								});
					});
</script>
</head>
<body>
	<div class="topPathArea">
		<table>
			<colgroup width="30px" />
			<tr>
				<td><img src="${ly}/images/localPlace.jpg" /></td>
				<td>产品中心</td>
				<td>&gt;</td>
				<td>指定产品类别</td>
				<td>&gt;</td>
				<th>编辑</th>
			</tr>
		</table>
	</div>
	<form action="#" method="post"
		id="jsonForm">
 		<input type="hidden" name="id" value="${product.id}" id="id" />
		<div class="outSideDiv">
			<div class="inputArea2">
	        	<label>产品名称：</label>
	        	<div style="float: left;display: inline;width: 650px;">
		            <input type="text" id="name" name="name" style="width:200px;" value="${product.productName}" readonly="readonly"/>
				</div>
	        </div>
			<c:forEach items="${menuList}" var="bean" varStatus="st">
				<div class="inputArea2">
					<fieldset>
						<legend>
							<c:if test="${!bean.checked}">
								<input type="checkbox" value="${bean.dataId }"
									name="p${st.index }" />
							</c:if>
							<c:if test="${bean.checked}">
								<input type="checkbox" value="${bean.dataId }" checked="checked"
									name="p${st.index }" />
							</c:if>
							${bean.text}
						</legend>
						<c:set var="seconds" value="${bean.children}"></c:set>
						<c:if test="${fn:length(seconds)>0}">
							<div style="float: left; display: inline; width: 800px;">
								<c:forEach items="${seconds}" var="innerB"
									varStatus="status">
									<!-- 三级 -->
									<c:set var="thirds" value="${innerB.children}"></c:set>
									<c:choose>
										<c:when test="${fn:length(thirds)>0}">
											<fieldset>
												<legend>
													<c:if test="${!innerB.checked}">
														<input type="checkbox" value="${innerB.dataId }"
															name="c${st.index }" />
													</c:if> 
													<c:if test="${innerB.checked}">
														<input type="checkbox" value="${innerB.dataId }"
															checked="checked" name="c${st.index }" />
													</c:if> ${innerB.text }
												</legend>
												<!-- 第三级 -->
												<div style="float: left; display: inline; width: 800px;">
													<c:forEach var="innerC" items="${thirds}">
														<label> 
															<c:if test="${!innerC.checked}">
																<input type="checkbox" value="${innerC.dataId }"
																	name="c${st.index }" />
															</c:if> 
															<c:if test="${innerC.checked}">
																<input type="checkbox" value="${innerC.dataId }"
																	checked="checked" name="c${st.index }" />
															</c:if> ${innerC.text }
														</label>														
													</c:forEach>
												</div>
											</fieldset>
										</c:when>
										<c:otherwise>
											<label> 
												<c:if test="${!innerB.checked}">
													<input type="checkbox" value="${innerB.dataId }"
														name="c${st.index }" />
												</c:if> 
												<c:if test="${innerB.checked}">
													<input type="checkbox" value="${innerB.dataId }"
														checked="checked" name="c${st.index }" />
												</c:if> ${innerB.text }
											</label>											
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>								
						</c:if>
						
					</fieldset>
				</div>
			</c:forEach>
			<div class="inputArea1" style="text-align: right; padding-top: 30px;">
				<input type="button" value="保存" id="submit"
					style="width: 80px; margin-right: 35px;" />
			</div>
		</div>
	</form>
</body>
</html>