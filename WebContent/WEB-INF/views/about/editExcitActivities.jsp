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
<script charset="utf-8" src="${ly }/js/brandnews.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>精彩活动管理</td><td>&gt;</td>
            <c:if test="${empty brandNews.title}"><th>添加</th></tr></c:if>
            <c:if test="${not empty brandNews.title}"><th>编辑(${brandNews.title})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly}/saveBrandNews.html" method="post" 
		id="saveBrandForm" commandName="brandNews" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${brandNews.id }"/>
		<input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber }"/>
		<input type="hidden" id="brandType" name="brandType" value="${brandType}"/>
		<input type="hidden" id="ctype" name="ctype" value="${ctype}"/>
		<div class="input_text">
        	<label>标题：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${brandNews.title}" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="title" name="title"/>
			</div>
        </div>
        <div class="input_text" id="nSource">
        	<label>创建时间：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input class="Wdate" type="text"  id="createTime" name="createTime" value='<fmt:formatDate value="${brandNews.createTime }" pattern="yyyy-MM-dd"/>'  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" 
             readonly="readonly" style="width:200px;">
			</div>
        </div>
        
        <%-- <div class="input_text" id="nSource">
        	<label>来源：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="source" value="${brandNews.newsSource }" name="newsSource" style="width:200px;"/>
			</div>
        </div> --%>
       <%--  <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${brandNews.picture}">
        		<img src="${brandNews.picture}" id="img" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${brandNews.picture }">
        			<img src="${brandNews.picture}" id="img" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div> --%>
        <div class="input_text">
        	<label>图片：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="picture" name="picture" value="${brandNews.picture }" readonly="readonly" /> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
         <%-- <div class="input_text">
        	<label>新闻视频：</label>
        	<div style="float: left;display: inline;">
        	 <input type="text" id="videoUrl" value="${honour.videoUrl }" name="videoUrl"/> <input type="button" id="insertfile" value="选择文件" />
			</div>
        </div> --%>
        <div class="input_text" style="height:380px;">
        	<label>内容：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="content" name="content"  > ${brandNews.content} </textarea>
			</div>
        </div>
         <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
   </form:form>
</body>
</html>
