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
<title>关于云盛信息</title>
<script type="text/javascript">
	function confirm1(ob_id){
        $.messager.confirm('云盛信息管理系统', 'Are you confirm this?', function(r){
            if (r){
            		var obj = new Object();
                    obj.id = ob_id;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/innovate/delQues.html',
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
					invokeRemove(tag,"ques_answ_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}
</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>关于</td><td>&gt;</td>
        	<td>
				清洁宝典        		
            </td>
            <td>&gt;</td>
            <th>列表</th>
            </tr>
        </table>
    </div>
    
     
	
		<div class="outSideDiv">
		<form action="${ly}/innovate/listQues.html" method="post" id="listForm">
		<div class="inputArea2"　>
        	<%-- <label>选择品牌：</label>
            <select id="choose" name="brandId">
            	<option value="">-请选择-</option>
            	<c:forEach items="${list }" var="bean">
            		<c:if test="${dto.brandId == bean.id }">
            			<option value="${bean.id }" selected="selected">${bean.brand }</option>
            		</c:if>
            		<c:if test="${dto.brandId != bean.id }">
            			<option value="${bean.id }">${bean.brand }</option>
            		</c:if>
            	</c:forEach>
            </select> 
             --%>
            <div style="padding-left: 20px;">
	           <%-- <input type="submit" id="selbut" value="查询" />           --%>
	            <input type="button" onclick="javascript:window.location.href='${ly}/innovate/addSpirit.html';" value="新增" name="addbut" id="addbut">
        	</div>
        </div>
		 
		<div class="inputArea2" style="width: 100%">
			<ll:tableModel id="list" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}" batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="95%">
					<ll:htmlRow uniqueProperty="id">
						<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false" width="5%"
							exportable="false" />
						<ll:htmlColumn property="question" title="问题" exportable="false" styleClass="table_left_css" >${bean.question }</ll:htmlColumn>
						<ll:htmlColumn property="answer" title="回答" exportable="true" styleClass="table_left_css">${bean.answer }</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false" width="15%">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="createUser" title="创建用户" exportable="false" width="10%"/>
						<ll:htmlColumn property="edit" title="操作" exportable="false" width="15%">
							<a href="${ly }/innovate/editQues.html?id=${bean.id}&pageNumber=${dto.pageNumber }&brandId=${dto.brandId}">编辑</a>&nbsp;
							<a href="javascript:confirm1(${bean.id });" id="edit">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
        </div>
</form>
   	 </div>
    
</body>
</html>