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
<link rel="stylesheet" href="${ly }/kindeditor/themes/default/default.css" />
<link href="${ly }/js/calendarControl/skin/default/datepickersel.css">
<script charset="utf-8" src="${ly }/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="${ly }/kindeditor/lang/zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<title>关于云盛信息</title>
<script type="text/javascript">
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.editor({
		uploadJson : getRootPath() + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : getRootPath() + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	K('#image3').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					K('#picture').val(url);
					$("#img").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
});

$(document).ready(function() { 
	
	$("#submit").click(function() {
		var obj = new Object();
		obj.id = $("#id").val();
		obj.newsTypeId = $("#newsTypeId").val();
		
		var yearMonth = $("#yearMonth").val();
		if (yearMonth == "") {
			$.messager.alert('云盛信息管理系统','所属 年份不能为空','warning');
			return false;
		}
		obj.yearM = yearMonth;
		
		var monthM = $("#monthM").val();
		if (monthM == "") {
			$.messager.alert('云盛信息管理系统','所属 月份不能为空','warning');
			return false;
		}
		obj.monthM = monthM;
		
		var title = $("#title").val();
		if (title == "") {
			$.messager.alert('云盛信息管理系统','标题不能为空','warning');
			return false;
		}
		obj.title = title;
		
		
		var pic = $("#picture").val();
		obj.picture = pic;
		
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/about/saveElegant.html',
			data : jsondata,
			dataType : 'json',
			contentType : 'application/json',
			beforeSend: function(XMLHttpRequest){
				 $.messager.progress({
				        title:'Please waiting',
				        msg:'Loading data...'
				    });
        	},
			success : function(result) {
			
				$.messager.alert('云盛信息管理系统',result.msg);
				window.location.href=getRootPath() + "/about/listElegant.html?newsTypeId=" + $("#newsTypeId").val() + "&pageNumber=" + $("#pageNumber").val();
				
		
			},
			 complete: function(XMLHttpRequest, textStatus){
				 $.messager.progress('close');
		        },
	        error:function(jqXHR, textStatus, errorThrown){
	        	top.location.href=getRootPath() + "/common/error";
	        }
	    });
	});
	

});


</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>关于云盛信息</td><td>&gt;</td>
        	<td>
	        	<c:if test="${honour.newsTypeId == 2 }">
					发展历程
				</c:if>
				<c:if test="${honour.newsTypeId == 3 }">
					集团荣誉
				</c:if>
				<c:if test="${honour.newsTypeId == 4 }">
					产品荣誉
				</c:if>   		
            </td>
            <td>&gt;</td>
            <th><ll:emptyTag value="${honour.title }">添加</ll:emptyTag><ll:notEmptyTag value="${honour.title }">编辑</ll:notEmptyTag></th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveElegant.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${honour.id }" id="id"/>
	<input type="hidden" name="newsTypeId" value="${honour.newsTypeId }" id="newsTypeId"/>
	<input type="hidden" name="pageNumber" id="pageNumber" value="${pageNumber }"> 
		<div class="outSideDiv">
		
		<div class="inputArea2">
        	<label>年份：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input class="Wdate" type="text"  id="yearMonth" name="yearMonth" value="${honour.yearM }"  onfocus="WdatePicker({dateFmt:'yyyy'})" 
             readonly="readonly" style="margin-left:6px;">
			</div>
        </div>
        <div class="inputArea2">
        	<label>月份：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input class="Wdate" type="text"  id="monthM" name="monthM" value="${honour.monthM }"  onfocus="WdatePicker({dateFmt:'MM'})" 
             readonly="readonly" style="margin-left:6px;">
			</div>
        </div>
		<div class="inputArea2">
        	<label>标题：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="title" value="${honour.title }" name="title" style="width:200px;"/>
			</div>
        </div>
		<div class="inputArea2">
        	<label>上传图片：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<ll:emptyTag value="${honour.picture }">
        		<img src="${ ly}/upload/article/image/${honour.picture}" id="img" width="150" height="150"/>
        		</ll:emptyTag>
        		<ll:notEmptyTag value="${honour.picture }">
        			<img src="${ ly}/upload/article/image/${honour.picture}" id="img" width="150" height="150"/>
        		</ll:notEmptyTag>
	            <input type="hidden" id="picture" value="${honour.picture }" name="picture"/> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        <div class="inputArea1" style="text-align: right;padding-top:30px;">
            <input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            
        </div>
   	 </div>
    </form>
</body>
</html>