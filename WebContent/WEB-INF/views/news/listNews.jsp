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
<title>企业新闻</title>
<script type="text/javascript">
	function confirm1(ob_id){
        $.messager.confirm('飞世龙机电信息管理系统', 'Are you confirm this?', function(r){
            if (r){
            		var obj = new Object();
                    obj.id = ob_id;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/news/delNews.html',
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
	
	function confirm2(ob_id){
		
        $.messager.prompt('飞世龙机电信息管理系统', '推荐轮播显示,输入0，取消置顶;1.推荐置顶', function(r){
            if (r){
            	
            	if(!/^[0-9]*$/.test(r)){
                    alert("请输入数字!");
                    return false;
                }
            		var obj = new Object();
                    obj.id = ob_id;
                    obj.seq = r;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/news/recommendSeq.html',
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
	
	function confirm5(ob_id){
		
        $.messager.prompt('飞世龙机电信息管理系统', '推送首页显示,输入0，取消推送;1.推送', function(r){
            if (r){
            	
            	if(!/^[0-9]*$/.test(r)){
                    alert("请输入数字!");
                    return false;
                }
            		var obj = new Object();
                    obj.id = ob_id;
                    obj.indexSeq = r;
                    var jsondata =  $.toJSON(obj);
     	               $.ajax({
     	       	    	type : 'POST',
     	       			url : getRootPath()+'/news/recommendSeq.html',
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
function confirm3(ob_id, ob_ck){
	$("#newsId").val(ob_id);
	$('#dlg').dialog('open');
    }
    
function confirm4(){
	
	var ob_ck = $("input[name='audit']:checked").val();
	if (ob_ck.length > 0) {
		var ob_id = $("#newsId").val();
		$('#dlg').dialog('open');
	           		var obj = new Object();
	                   obj.id = ob_id;
	                   obj.isCheck = ob_ck;
	                   var jsondata =  $.toJSON(obj);
	    	               $.ajax({
	    	       	    	type : 'POST',
	    	       			url : getRootPath()+'/news/audit.html',
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
	
    }
    
	$(function () {
		$("input[name='audit']").click(function () {
			var id = $(this).attr("id");
			if ($(this).attr("checked")) {
				if (id == 'c1') {
					$("#c2").attr("checked", false);
				} else {
					$("#c1").attr("checked", false);
				}
			}
			
		});
	});
	
function removeAll (tag) {
		
		$.messager.confirm('飞世龙机电信息管理系统','确定删除吗？',function(r){
			  if(r){
					invokeRemove(tag,"news_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}
</script>
</head>
<body>
	<div class="topPathArea">
    	<table>
        	<colgroup width="30px"/>
        	<tr><td><img src="${ly}/images/localPlace.jpg"/></td><td>企业新闻</td><td>&gt;</td>
        	<td>
				<c:if test="${dto.newsTypeId == 5 }">
					集团动态
				</c:if>
				<c:if test="${dto.newsTypeId == 6 }">
					媒体报道
				</c:if>
				<c:if test="${dto.newsTypeId == 7 }">
					精彩活动
				</c:if>
				<c:if test="${dto.newsTypeId == 13 }">
					2014媒体报道
				</c:if>   		     		
            </td>
            <td>&gt;</td>
            <th>列表</th>
            </tr>
        </table>
    </div>
	<form action="${ly}/news/listNews.html" method="post" id="listForm">
	<input type="hidden" name="newsTypeId" value="${dto.newsTypeId }" id="newsTypeId"/>
		<div class="outSideDiv">
		<div class="inputArea2" >
			<ll:tableModel id="list" items="${dto.list}" var="bean" importable="false" totalRows="${dto.pager.rowCount}" batchable="true" editable="true">
				<ll:htmlTable caption="Presidents" width="95%">
					<ll:htmlRow uniqueProperty="id">
					<ll:htmlColumn property="selected" title="选择" editable="true" width="5%"
							exportable="false" />
						<ll:htmlColumn property="rowNumber" title="编号" editable="false"
							exportable="false" width="5%"/>
						<ll:htmlColumn property="title" title="标题" exportable="false" styleClass="table_left_css" width="18%">
							${bean.title}
						</ll:htmlColumn>
						<ll:htmlColumn property="brief" title="简介" exportable="false" styleClass="table_left_css">
							${bean.brief}
						</ll:htmlColumn>
						<ll:htmlColumn property="createTime" title="创建时间" exportable="false">
							<fmt:formatDate value="${bean.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</ll:htmlColumn>
						<ll:htmlColumn property="createUser" title="创建用户" exportable="false" width="10%"/>
						
						<ll:htmlColumn property="indexSeq" title="是否首页显示" exportable="false" width="10%">
							<c:if test="${bean.indexSeq > 0 }"><span style="color:red;">是</span></c:if>
							<c:if test="${bean.indexSeq == 0 || bean.indexSeq == null}">否</c:if>
						</ll:htmlColumn>
						
						<ll:htmlColumn property="seq" title="是否置顶" exportable="false" width="10%">
							<c:if test="${bean.seq > 0 }"><span style="color:red;">是</span></c:if>
							<c:if test="${bean.seq == 0 }">否</c:if>
						</ll:htmlColumn>
						<ll:htmlColumn property="edit" title="操作" exportable="false" width="10%">
							<a href="javascript:confirm5(${bean.id });">推送首页</a>&nbsp;
							<a href="javascript:confirm2(${bean.id });">置顶</a>&nbsp;
							<a href="${ly }/news/editNews.html?id=${bean.id}&pageNumber=${dto.pageNumber}">编辑</a>&nbsp;
							<a href="javascript:confirm1(${bean.id });" id="edit">删除</a>
						</ll:htmlColumn>
					</ll:htmlRow>
				</ll:htmlTable>
			</ll:tableModel>
        </div>

   	 </div>
    </form>
    
    <div id="dlg" class="easyui-dialog" title="新闻审核" style="width:400px;height:200px;padding:10px;text-align: center;vertical-align: middle;"
            data-options="
                iconCls: 'icon-save',closed: true,modal:false,
                buttons: [{
                    text:'Ok',
                    iconCls:'icon-ok',
                    handler:function(){
                        confirm4();
                    }
                },{
                    text:'Cancel',
                    handler:function(){
                        $('#dlg').dialog('close');
                    }
                }]">
            
            <input id="newsId">
            <table>
            	<tr>
            	 <td><input type="checkbox"  name="audit" value="1" id='c1'/>&nbsp;通过 &nbsp;<input type="checkbox"  name="audit" value="2" id='c2'/>&nbsp;不通过</td>
                </tr>
            </table>
 
    </div>
</body>
</html>