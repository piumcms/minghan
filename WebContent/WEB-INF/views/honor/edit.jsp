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
<script charset="utf-8" src="${ly }/js/honor.js"></script>
</head>

<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>企业荣誉管理</td><td>&gt;</td>
            <c:if test="${empty download.title}"><th>添加</th></tr></c:if>
            <c:if test="${not empty download.title}"><th>编辑(${download.title})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly}/honor/saveDownload.html" method="post" 
		id="saveDownloadForm" commandName="download" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${download.id}"/>
		<input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber}"/>
		<input type="hidden" id="searchTitle" name="searchTitle" value="${title}"/>
		<input type="hidden" id="siteName" name="siteName" value="${download.siteName}"/>
        <div class="input_text">
        	<label>证书类别：</label>
        	<div style="float: left;display: inline;">
        		<select id="category" name="category" style="width:250px;">
	            	<option value="patent">专利证书</option>
	            	<option value="authentication">认证证书</option>
	            	<option value="collect">采标证明</option>
	            	<option value="high_quality">高品证书</option>
	            	<option value="c3">3C证书</option>
	            </select>
			</div>
        </div>
        <div class="input_text">
        	<label>证书名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${download.title }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="title" name="title"/>
			</div>
        </div>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
        		<img src="${download.picture}" id="img" width="220" height="120"/>
			</div>
        </div>
        <div class="input_text">
        	<label>上传证书：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="picUrl" name="picUrl" value="${download.picture}" 
        		readonly="readonly" /> <input type="button" id="filem" value="选择证书" />
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
