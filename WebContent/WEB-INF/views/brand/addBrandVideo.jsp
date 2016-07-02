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
<script src="${ly }/kindeditor/lang/zh_CN.js"></script>
<script language="javascript" type="text/javascript" src="${ly }/js/calendarControl/WdatePicker.js"></script>
<title>云盛信息集团</title>
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
	K('#insertfile').click(function() {
		
		editor1.loadPlugin('insertfile', function() {
			editor1.plugin.fileDialog({
				fileUrl : K('#videoUrl').val(),
				clickFn : function(url, title) {
					K('#videoUrl').val(url);
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
		
		/* var brandId = $("#choose").val();
		if (brandId == "") {
			$.messager.alert('云盛信息管理系统','品牌品牌不能为空','warning');
			return false;
		}
		obj.brandId = brandId;
		 */
		var title = $("#title").val();
		if (title == "") {
			$.messager.alert('云盛信息管理系统','标题不能为空','warning');
			return false;
		}
		obj.title = title;
		
		var yearMonth = $("#yearMonth").val();
		if (yearMonth == "") {
			$.messager.alert('云盛信息管理系统','所属日期不能为空','warning');
			return false;
		}
	
		obj.yearM = yearMonth;
		var pic = $("#picture").val();
		if (pic == "") {
			$.messager.alert('云盛信息管理系统','请上传封面','warning');
			return false;
		}
		obj.picture = pic;
		var videoUrl = $("#videoUrl").val();
		/* if (videoUrl == "") {
			$.messager.alert('云盛信息管理系统','请上传视频','warning');
			return false;
		} */
		obj.videoUrl = videoUrl;
		
		obj.youkuId = $("#youkuId").val();
		obj.brandType = $("#brandType").val();
		obj.category = $("#ctype").val();
		obj.videoDesc = $("#videoDesc").val();
		var jsondata =  $.toJSON(obj);

	    $.ajax({
	    	type : 'POST',
			url : getRootPath()+'/video/saveBrandVideo.html',
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
				var pageNumber = $("#pageNumber").val();
				if (pageNumber != null) {
					window.location.href = getRootPath()
							+ "/video/"+$("#brandType").val()+"/list.html?category="+$("#ctype").val()+"&pageNumber="
							+ pageNumber;
				} else {
					window.location.href = getRootPath()
							+ "/video/"+$("#brandType").val()+"/list.html?category="+$("#ctype").val();
				}
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
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>云盛信息品牌</td><td>&gt;</td>
        	<td>
				品牌视频      		
            </td>
            <td>&gt;</td>
            <th>
            	<c:if test="${empty brandVideo.title}">添加</c:if>
            	<c:if test="${not empty brandVideo.title}">编辑(${brandVideo.title})</c:if>
            </th>
            </tr>
        </table>
    </div>
	<form action="${ly }/about/saveElegant.html" method="post" id="jsonForm">
	<input type="hidden" name="id" value="${brandVideo.id }" id="id"/>
	<input type="hidden" id="pageNumber" name="pageNumber" value="${pageNumber }"/>
	<input type="hidden" id="brandType" name="brandType" value="${brandType}"/>
	<input type="hidden" id="ctype" name="ctype" value="${ctype}"/>
	<input type="hidden" id="flag" name="flag" value="${brandVideo.flag}"/>	
	<div class="outSideDiv">
		<%-- <div class="inputArea2">
        	<label>选择品牌：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <select id="choose" name="brand">
	            	<option value="">-请选择-</option>
	            	<c:forEach items="${list }" var="bean">
	            		<c:if test="${brandVideo.brandId == bean.id }">
	            			<option value="${bean.id }" selected="selected">${bean.brand }</option>
	            		</c:if>
	            		<c:if test="${brandVideo.brandId != bean.id }">
	            			<option value="${bean.id }">${bean.brand }</option>
	            		</c:if>
	            	</c:forEach>
	            </select>
			</div>
        </div> --%>
		
		<div class="inputArea2">
        	<label>标题：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="title" value="${brandVideo.title }" name="title"/>
			</div>
        </div>
		
		<div class="inputArea2">
        	<label>日期：</label>
        	<div style="float: left;display: inline;width: 650px;">
	         	<input type="text"  id="yearMonth" name="yearMonth" value="${brandVideo.yearM }"  onfocus="WdatePicker({dateFmt:'yyyy'})" 
             		readonly="readonly"/>
			</div>
        </div>
		
		<div class="inputArea2">
        	<label>上传封面：</label>
        	<div style="float: left;display: inline;width: 650px;">
        		<ll:emptyTag value="${brandVideo.picture }">
        		<img src="${ ly}/upload/article/image/${brandVideo.picture}" id="img" width="150" height="150"/>
        		</ll:emptyTag>
        		<ll:notEmptyTag value="${brandVideo.picture }">
        			<img src="${ ly}/upload/article/image/${brandVideo.picture}" id="img" width="150" height="150"/>
        		</ll:notEmptyTag>
	            <input type="hidden" id="picture" value="${brandVideo.picture }" name="picture"/> <input type="button" id="image3" value="选择图片" />
			</div>
        </div>
        
		<div class="inputArea2">
        	<label>上传视频：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="videoUrl" value="${brandVideo.videoUrl }" name="videoUrl"/> <input type="button" id="insertfile" value="选择文件" />
			</div>
        </div>
		
		<div class="inputArea2">
        	<label>优酷Id：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <input type="text" id="youkuId" value="${brandVideo.youkuId }" name="youkuId"/>
			</div>
        </div>
        
        <div class="inputArea2">
        	<label>视频描述：</label>
        	<div style="float: left;display: inline;width: 650px;">
	            <textarea rows="6" cols="80" id="videoDesc" name="videoDesc"  > ${brandVideo.videoDesc} </textarea>
			</div>
        </div>
        <div class="inputArea2">
            <label></label>
        	<div style="float: left;display: inline;width: 650px;">
            	<input type="button" value="保存" id="submit" style="width:80px;margin-right: 35px;"/>
            </div>
        </div>
   	 </div>
    </form>
</body>
</html>