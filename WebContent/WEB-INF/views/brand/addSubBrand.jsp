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
<script charset="utf-8" src="${ly }/js/subbrand.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>品牌管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加子品牌</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>编辑子品牌(${subbrand.brand})</th></tr></c:if>
        </table>
    </div>
	<form:form action="${ly }/brand/saveSubBrand.html" method="post" id="saveBrandForm" commandName="subbrand" >
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${subbrand.id }"/>
		<input type="hidden" name="pageNumber" id="pageNumber" value="${pageNumber }">
		<div class="input_text">
        	<label>选择父品牌：</label>
        	<div style="float: left;display: inline;">
        	   <select id="brandId" name="brandId" style="width: 120px;">
        	   <c:forEach items="${brandList}" var="bean">
        	     <c:if test="${brand.id==bean.id }">
        	     <option value="${bean.id }" selected="selected">${bean.brand }</option>
        	     </c:if>
        	     <c:if test="${brand.id!=bean.id }">
        	     <option value="${bean.id }" >${bean.brand }</option>
        	     </c:if>
        	   </c:forEach>
        	   </select>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${subbrand.brand }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="brand" name="brand"/>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌链接：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${subbrand.url }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空"  id="url" name="url"/>
			</div>
        </div>
        <div class="input_text">
        	<label>微博Id：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${subbrand.weiboId }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空"  id="weiboId" name="weiboId"/>
			</div>
        </div>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${subbrand.picSrc }">
        		<img src="${subbrand.picSrc}" id="img" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${subbrand.picSrc }">
        			<img src="${subbrand.picSrc}" id="img" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌logo：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="picSrc" name="picSrc" value="${subbrand.picSrc }" readonly="readonly" /> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
        <div class="input_text" style="height:380px;">
        	<label>品牌介绍：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="subBrandDesc" name="subBrandDesc"  > ${subbrand.subBrandDesc} </textarea>
			</div>
        </div>
        <!--
        <div class="input_text">
        	<label>品牌概要：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" class="input_text_css" id="info" name="info"/>
			</div>
        </div>  -->
   
         <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
        </div>
   	 </div>
   </form:form>
</body>
</html>
