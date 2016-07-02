<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/views/meta.jsp"%>
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}

</style>
<script type="text/javascript">
function confirm1(ob_id){
    $.messager.confirm('飞世龙机电信息管理系统', 'Are you confirm this?', function(r){
        if (r){
        		var obj = new Object();
                obj.id = ob_id;
                var jsondata =  $.toJSON(obj);
 	               $.ajax({
 	       	    	type : 'POST',
 	       			url : getRootPath()+'/menu/deleteRole.html',
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
 	       	        	top.location.href=getRootPath() + "/common/error";
 	       	        }
        	});
           
        }
    });
}
</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>系统管理</td><td>&gt;</td>
        	<td>
				角色管理        		
            </td>
            <td>&gt;</td>
            <th>列表</th>
            </tr>
        </table>
    </div>
	<div class="div1_2">
 		<form action="${ly}/menu/list.html" method="post" id="listForm">
			<ll:tableModel id="userList" items="${list}" var="bean" importable="false" totalRows="${list.size()}">
				<ll:htmlTable caption="Presidents" width="500px">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							exportable="false" />
						<ll:htmlColumn property="memo" title="角色名称" exportable="true" styleClass="table_left_css">
							${bean.memo}
						</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="view" title="备注" exportable="false" styleClass="table_left_css"/>
						<ll:htmlColumn property="operate" title="操作" exportable="false" styleClass="table_left_css">
							<a href="${ly }/role/editRole.html?name=${bean.name}">编辑</a>&nbsp;
							<a href="javascript:confirm1(${bean.id });" id="edit">删除</a>&nbsp;
							<a href="${ly }/menu/assignedMenus.html?name=${bean.name}">权限分配</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
		</form>
	</div>
</body>
</html>
