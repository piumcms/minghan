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
<link href="${ly}/css/ll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ly }/js/ll_1.0.js"></script>
<title>云盛信息集团</title>
<script type="text/javascript">
	function confirm1(ob_id){
        $.messager.confirm('云盛信息管理系统', '确认接见吗?', function(r){
            if (r){
            		var obj = new Object();
                    obj.id = ob_id;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/news/updateReservation.html',
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
	
	function confirm2(ob_id){
        $.messager.confirm('云盛信息管理系统', 'Are you confirm this?', function(r){
            if (r){
            		var obj = new Object();
                    obj.id = ob_id;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/news/delReservation.html',
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
					invokeRemove(tag,"reservation_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}
</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>企业新闻&gt;媒体会客室</td><td>&gt;</td>
        	<td>
				媒体约见列表  		
            </td>
            <td>&gt;</td>
            <th>列表</th>
            </tr>
        </table>
    </div>
	<form action="${ly}/news/listReservation.html" method="post" id="listForm">
		<div class="outSideDiv">
		<div class="inputArea2" style="width:750px;">
			<ll:tableModel id="list" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}" batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="750">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							exportable="false" />
						<ll:htmlColumn property="fullname" title="姓名" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="mdia" title="所在媒体" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="postion" title="职位" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="email" title="电子邮件" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="telephone" title="办公电话" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="mobile" title="手机号码" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="interestedArea" title="兴趣" exportable="true" styleClass="table_left_css"/>
						<ll:htmlColumn property="outlinie" title="提纲" exportable="true" styleClass="table_left_css" >
							<span title="${bean.outline }"> <ll:cutString cnLength="10" value="${bean.outline }" enLength="20"/></span>
						</ll:htmlColumn>
						
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="status" title="状态" exportable="false">
							<c:if test="${bean.status == '0' }">未接见</c:if>
							<c:if test="${bean.status == '1' }">已接见</c:if>
						</ll:htmlColumn>
						<ll:htmlColumn property="createUser" title="创建用户" exportable="false"/>
						<ll:htmlColumn property="edit" title="操作" exportable="false">
							<c:if test="${bean.status == '0' }"><a href="javascript:confirm1(${bean.id });">接见</a></c:if>
							&nbsp;
							<a href="javascript:confirm2(${bean.id });" id="edit">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
        </div>

   	 </div>
    </form>
</body>
</html>