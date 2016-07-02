 //删除品牌
 function delTag(objsid){
	  var pageNumber=$("input[name='pageNumber']").val();
	  $.messager.confirm('明翰CMS管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata =  $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : ctx+'/tag/remove.html',
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
						$.messager.alert('明翰CMS管理系统',result.msg,'question',function(r){
							window.location.href=ctx+"/tag/tag.html?pageNumber="+pageNumber;
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
 