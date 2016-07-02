<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/addAbout.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<title>首页图片</title>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}

</style>
<script type="text/javascript">
	function confirm1(ob_id){
        $.messager.confirm('飞世龙机电信息管理系统', '您确认吗?', function(r){
            if (r){
            		var obj = new Object();
                    obj.id = ob_id;
                    obj.path = " ";
                    obj.url = " ";
                    obj.alt = " ";
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : ctx+'/pic/savePic.html',
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
     	       			
     	       				$.messager.alert('飞世龙机电信息管理系统',result.msg);
     	       				$("#listForm").submit();
     	       		
     	       			},
     	       			 complete: function(XMLHttpRequest, textStatus){
     	       				 $.messager.progress('close');
     	       		        },
     	       	        error:function(jqXHR, textStatus, errorThrown){
     	       	        	top.location.href=ctx + "/common/error";
     	       	        }
            	});
               
            }
        });
    }
	
</script>
</head>
<body style="width: 100%;">
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>首页图片</td><td>&gt;</td>
        	<td>
				首页图片        		
            </td>
            <td>&gt;</td>
            <th>列表</th>
            </tr>
        </table>
    </div>
    <div class="div1_2">
	<form action="${ly}/pic/listPic.html" method="post" id="listForm">
		<ll:tableModel id="list" items="${dto.list}" var="bean" totalRows="${dto.pager.rowCount}">
			<ll:htmlTable caption="Presidents">
				<ll:htmlRow uniqueProperty="id">
					<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="5%"
						exportable="false" />
					<ll:htmlColumn property="path" title="图片" exportable="false" styleClass="table_left_css" width="15%">
						<img src="${ly }/upload/images/image/${bean.path}" width="150" height="110"/>
					</ll:htmlColumn>
					<ll:htmlColumn property="language" title="语言" exportable="false" styleClass="table_left_css"/>
					<ll:htmlColumn property="url" title="链接" exportable="false" styleClass="table_left_css"/>
					<ll:htmlColumn property="alt" title="替换文字" exportable="false" styleClass="table_left_css"/>
					<ll:htmlColumn property="pw" title="顺序" exportable="false"/>
					<ll:htmlColumn property="edit" title="操作" exportable="false" width="10%">
						<a href="${ly }/pic/editPic.html?id=${bean.id}">编辑</a>&nbsp;
						<a href="javascript:confirm1(${bean.id });" id="edit">删除</a>
					</ll:htmlColumn>
				</ll:htmlRow>
			</ll:htmlTable>
		</ll:tableModel>
    </form>
    </div>
</body>
</html>