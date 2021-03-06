//品牌相关js代码
//var editor1;
var editor2;
var filepath;
KindEditor.ready(function(K) {
/*	editor1 = K.create('textarea[name="downloadDesc"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});*/
	editor2 = K.create('textarea[name="memo"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	K('#filem').click(function() {
		/*editor2.loadPlugin('image', function() {
			editor2.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#url').val(url);
					$("#img").attr('src', url);
					editor2.hideDialog();
				}
			});
		});*/
		
		
		editor2.loadPlugin('insertfile', function() {
	           editor2.plugin.fileDialog({
	               fileUrl : K('#url').val(),
	               clickFn : function(url, title) {
	                   K('#url').val(url);
	                   filepath = url;
	                   editor2.hideDialog();
	               }
	           });
	       });
		
	});
	
});

 $(document).ready(function() { 
	 $("#submit").click(function() {
			var obj = new Object();
			obj.id=$('#id').val();
			obj.title = $("#title").val();
			obj.siteName = $("#siteName").val(); 
			if (obj.title == "") {
				$.messager.alert('飞世龙机电管理系统','附件名称不能为空!','warning');
				return false;
			}
			obj.url= $("#url").val();
			obj.category = "download";
			if (obj.url == "") {
				$.messager.alert('飞世龙机电管理系统','附件不能为空!','warning');
				return false;
			}
			obj.url = filepath;
			var html2 = editor2.html();
			if (html2 == "") {
				$.messager.alert('飞世龙机电管理系统','附件描述不能为空','warning');
				return false;
			}
			$("#memo").val(html2);
			obj.memo=$("#memo").val();
			
			var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : ctx+'/downcenter/saveDownload.html',
				data : jsondata,
				dataType : 'json',
				contentType : 'application/json',
				beforeSend: function(XMLHttpRequest){
					 $.messager.progress({
					        title:'Please waiting',
					        msg:'Loading data...'
					    });
	        	},
				success : function(result){
					
					if(result.success){
					   $.messager.alert('飞世龙机电管理系统',result.msg,'question',function(r){
						   if ($('#id').val() != "") {
							// 创建Form
							    var form = $('<form></form>');
							    // 设置属性
							    form.attr('action', ctx+"/downcenter/"+$("#siteName").val()+"/list.html");
							    form.attr('method', 'post');
							    var pageNumber = $('<input type="text" name="pageNumber" />');
							    pageNumber.val($("#pageNumber").val());
							    form.append(pageNumber);
							    var title = $('<input type="text" name="title" />');
							    title.val($("#searchTitle").val());
							    // 附加到Form
							    form.append(title);
							    // 提交表单
							    form.submit();
							   
						   } else {
							   window.location.href=ctx+"/downcenter/"+$("#siteName").val()+"/list.html";
						   }
						   
					  });
					}else{
						$.messager.alert('飞世龙机电管理系统',result.msg,'question',function(r){
							$("#brand").val('');
						  });
					}
				},
				 complete: function(XMLHttpRequest, textStatus){
					 $.messager.progress('close');
			        },
		        error:function(jqXHR, textStatus, errorThrown){
		        	top.location.href=ctx + "/common/error";
		        }
		    });
		}); 
}); 
 
 //删除品牌
 function delDownload(objsid){
	  var pageNumber=$("input[name='pageNumber']").val();
	  $.messager.confirm('飞世龙机电管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata =  $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : ctx+'/downcenter/delDownload.html',
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
						$.messager.alert('飞世龙机电管理系统',result.msg,'question',function(r){
							window.location.href=ctx+"/downcenter/"+$("#siteName").val()+"/list.html?pageNumber="+pageNumber;
							});
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
 
 //编辑
 function editDownload(objsid, objPage, objTab, objProd){
	  $.messager.confirm('飞世龙机电管理系统','确定编辑吗？',function(r){
		  if(r){
			  objProd = encodeURIComponent(encodeURIComponent(objProd));
			  window.location.href=ctx+"/downcenter/"+$("#siteName").val()+"/showEditDownCenter.html?id="+objsid+"&pageNumber="+objPage+"&title=" + objProd;
		  }		  
	  });
 }
 
 function removeAll(tag){
	 var pageNumber=$("input[name='pageNumber']").val();
	 var downloadIds = "";
	 var checks = $("input[type='checkbox']");
	 for (var i=0;i<checks.length;i++) {
	    	var check = checks.eq(i);
	    	if ($(check).attr("checked")) {
	    		var downloadId = $(check).parent().parent().parent().attr("id");
	    		downloadId = downloadId.replace("downloadList_row", "");
	    		downloadIds = downloadIds + downloadId + ",";
	    	}
	    }
	 if (downloadIds=="") {
	    	$.messager.alert('请选择要删除的条目!','warning');
	 } else {
		 downloadIds = downloadIds.substring(0, downloadIds.length-1);
		 $.messager.confirm('飞世龙机电管理系统','确定删除吗？',function(r){
			  if(r){
				    var obj = new Object();
				    //obj.id="";
				    var jsondata =  $.toJSON(obj);
				    	$.ajax({
					    	type : 'POST',
							url : ctx+'/downcenter/removeDownloads.html?ids='+downloadIds,
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
								$.messager.alert('飞世龙机电管理系统',result.msg,'question',function(r){
									window.location.href=ctx+"/downcenter/"+$("#siteName").val()+"/list.html?pageNumber="+pageNumber;
									});
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
	 
 }
 
