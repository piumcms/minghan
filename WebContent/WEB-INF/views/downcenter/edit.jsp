<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<link href="${ly }/js/calendarControl/skin/default/datepickersel.css">
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<script charset="utf-8" src="${ly }/js/downcenter.js"></script>
</head>

<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>附件管理</td><td>&gt;</td>
            <c:if test="${empty download.title}"><th>添加</th></tr></c:if>
            <c:if test="${not empty download.title}"><th>编辑(${download.title})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly}/downcenter/saveDownload.html" method="post" 
		id="saveDownloadForm" commandName="download" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${download.id}"/>
		<input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber}"/>
		<input type="hidden" id="searchTitle" name="searchTitle" value="${title}"/>
		<input type="hidden" id="siteName" name="siteName" value="${download.siteName}"/>
        <%-- <div class="input_text">
        	<label>语言选择：</label>
        	<div style="float: left;display: inline;">
        		<select id="language" name="language" style="width:250px;">
	            	<c:choose>
	            		<c:when test="${download.language=='zh_CN' }">
	            			<option value="zh_CN" selected="selected">中文</option>
	            		</c:when>
	            		<c:otherwise>
	            			<option value="zh_CN">中文</option>
	            		</c:otherwise>
	            	</c:choose>
	            	
	            	<c:choose>
	            		<c:when test="${download.language=='en_US' }">
	            			<option value="en_US" selected="selected">英语</option>
	            		</c:when>
	            		<c:otherwise>
	            			<option value="en_US">英语</option>
	            		</c:otherwise>
	            	</c:choose>
	            </select>
			</div>
        </div> --%>
        <div class="input_text">
        	<label>附件名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${download.title }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="title" name="title"/>
			</div>
        </div>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
        		<a href="${download.url}" target="_blank">${download.title}</a>
			</div>
        </div>
        <div class="input_text">
        	<label>上传附件：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="url" name="url" value="${download.url }" 
        		readonly="readonly" /> <input type="button" id="filem" value="选择附件" />
			</div>
        </div>
        <div class="input_text" style="height:240px;">
        	<label>简介：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="memo" name="memo"> ${download.memo} </textarea>
			</div>
        </div>
        <div class="input_text">
        	<label></label>
        	<div style="float: left;display: inline;">
        		<input type="button" value="保存" id="submit" style="width:80px;"/>
        	</div>
        </div>
   	 </div>
   </form:form>
</body>
</html>
