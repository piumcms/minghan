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
<script charset="utf-8" src="${ly }/js/brand.js"></script>
<script type="text/javascript"></script>
</head>
<body>
<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
            <td>品牌管理</td><td>&gt;</td>
            <c:if test="${bflag==1 }"><th>添加品牌</th></tr></c:if>
            <c:if test="${bflag==2 }"><th>编辑品牌(${brand.brand})</th></tr></c:if>
        </table>
    </div>
	<form action="${ly }/brand/saveBrand.html" method="post" id="saveBrandForm">
		<div class="outSideDiv">
		<input type="hidden" id="id" name="id" value="${brand.id }"/>
        <div class="input_text">
        	<label>品牌名称：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${brand.brand }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="brand" name="brand"/>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌简写：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${brand.brandType }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空" id="brandType" name="brandType"/>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌链接：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${brand.url }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空"  id="url" name="url"/>
			</div>
        </div>
        
         <div class="input_text">
        	<label>微博Id：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" value="${brand.weiboId }" class="easyui-validatebox" required="true" validType="length[2,30]" missingMessage="不能为空"  id="weiboId" name="weiboId"/>
			</div>
        </div>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${brand.picSrc }">
        		<img src="${brand.picSrc}" id="img" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${brand.picSrc }">
        			<img src="${brand.picSrc}" id="img" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌logo：</label>
        	<div style="float: left;display: inline;">
        	<input type="text"  id="picSrc" name="picSrc" value="${brand.picSrc }" readonly="readonly" /> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${brand.bannerPic }">
        		<img src="${brand.bannerPic}" id="imgbanner" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${brand.bannerPic }">
        			<img src="${brand.bannerPic}" id="imgbanner" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
         <div class="input_text">
        	<label>品牌banner图：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" class="input_text_css" id="bannerPic" name="bannerPic" value="${brand.bannerPic }" readonly="readonly" /><input type="button" id="image2" value="选择图片" />
			</div>
        </div>
        
         <div class="input_text" style="height:130px;">
        	<label></label>
        	<div style="float: left;height:130px;">
             <ll:emptyTag value="${brand.brandImage }">
        		<img src="${brand.brandImage}" id="imagebrand" width="220" height="120"/>
        		</ll:emptyTag>
        	 <ll:notEmptyTag value="${brand.bannerPic }">
        			<img src="${brand.brandImage}" id="imagebrand" width="220" height="120"/>
        	 </ll:notEmptyTag>
			</div>
        </div>
        <div class="input_text">
        	<label>品牌形象图：</label>
        	<div style="float: left;display: inline;">
        	<input type="text" class="input_text_css" id="brandImage" name="brandImage" value="${brand.brandImage }" readonly="readonly" /> <input type="button" id="image1" value="选择图片" />
			</div>
        </div>
        
        <div class="input_text" style="height:380px;">
        	<label>品牌介绍：</label>
        	<div style="float: left;display: inline;width: 650px;height: 380px;">
        	<textarea rows="6" cols="80" id="brandDesc" name="brandDesc"  > ${brand.brandDesc} </textarea>
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
    </form>
</body>
</html>
