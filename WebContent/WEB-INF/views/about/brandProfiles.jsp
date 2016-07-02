<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台管理系统</title>
<%@include file="/WEB-INF/inc/resource.inc"%>
<link href="${ly}/css/back.css" rel="stylesheet" type="text/css" />
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<script charset="utf-8" src="${ly }/js/about.js"></script>
<style type="text/css">
body{padding: 0px;}
.div1{padding: 0px;}
</style>
<script type="text/javascript">
	function confirm1(ob_id){
        $.messager.confirm('云盛信息管理系统', 'Are you confirm this?', function(r){
            if (r){
            		var obj = new Object();
                    obj.id = ob_id;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/about/delElegant.html',
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
	
	function removeAll (tag) {
		
		$.messager.confirm('云盛信息管理系统','确定删除吗？',function(r){
			  if(r){
					invokeRemove(tag,"news_honour_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}
</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>关于云盛信息</td><td>&gt;</td>
        	<td>
				品牌历程        		
            </td>
            <td>&gt;</td>
            <th>列表</th>
            </tr>
        </table>
    </div>
	<form action="${ly}/brand/${brandType}/list.html?category=${ctype}" method="post" id="listForm">
		<input type="button" value="新建" onclick="addAboutUs()"/>
		<input type="hidden" id="ctype" name="ctype" value="${ctype}"/>
		<input type="hidden" id="brandType" name="brandType" value="${brandType}" /> 
		<div class="outSideDiv">
		<div class="inputArea2" style="width:100%;">
			<ll:tableModel id="list" items="${dto.list}" var="bean" totalRows="${dto.pager.rowCount}" batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="95%">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="5%"
							exportable="false" />
						<ll:htmlColumn property="title" title="标题" exportable="true" styleClass="table_left_css">
							${bean.title}
						</ll:htmlColumn>
						<%-- <ll:htmlColumn property="brief" title="简介" exportable="false" styleClass="table_left_css"/> --%>
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="createUser" title="创建用户" exportable="false"/>
						<ll:htmlColumn property="edit" title="操作" exportable="false" width="10%">
							<a href="javascript:editAboutUs(${bean.id});">编辑</a>&nbsp;
							<a href="javascript:delAboutUs(${bean.id });" id="edit">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
        </div>

   	 </div>
    </form>
</body>
</html>