//品牌相关js代码
var editor1;
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="info"]', {
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
					$('#src').val(url);
					$("#img").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
	K('#image2').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#bannerPic').val(url);
					$("#imgbanner").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
	K('#image1').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#brandImage').val(url);
					$("#imagebrand").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
});

 $(document).ready(function() { 

	//二级下拉框
	 $("#tableId").change(function(){
		 $("#prodv").show();
		 var productId = $("#productId");
		     productId.empty();
		    if( $("#tableId").val()==0){
		    	 $("#prodv").hide();
		    }else{
		    	   var obj = new Object();
				    obj.tableId=$("#tableId").val();
		    var jsondata =  $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/brand/getProduct.html',
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
					 $.each(result,function(index,d){
						    var option = $("<option>").text(d['productName']).val(d['id']);
						    productId.append(option);
						   })
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
	 
	//保存Sku
	 $("#submit").click(function() {
			var obj = new Object();
			obj.id=$('#id').val();
			if ($('#tableId').val() == "0"){
				$.messager.alert('立白管理系统','请选择商品品牌！','warning');
				return false;
			}
			obj.productId=$('#productId').val();
			if (productId == "0"){
				$.messager.alert('立白管理系统','请选择商品！','warning');
				return false;
			}
			if (productId == "0"){
				$.messager.alert('立白管理系统','请选择商品！','warning');
				return false;
			}
			$("#productName").val($('#productId').find("option:selected").text());
			obj.productName = $("#productName").val();
			obj.attributeId=$('#attributeId').val();
			$("#attributeName").val($('#attributeId').find("option:selected").text());
			obj.attributeName = $("#attributeName").val();
			obj.pw = $("#pw").val();
			obj.src=$("#src").val();
			var html = editor1.html();
			if (html == ""){
				$.messager.alert('立白管理系统','内容描述不能为空','warning');
				return false;
			}
			$("#info").val(html)
			obj.info=$("#info").val();
			var jsondata = $.toJSON(obj);
		    $.ajax({
		    	type : 'POST',
				url : getRootPath()+'/brand/saveSku.html',
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
					if(result.success){
					   $.messager.alert('立白管理系统',result.msg,'question',function(r){
						   var pageNumber=$("#pageNumber").val();
						   if(pageNumber!=null){
							   var form = $('<form></form>');
							    // 设置属性
							    form.attr('action', getRootPath()+"/brand/skuList.html");
							    form.attr('method', 'post');
							    // 创建Input
							    var tableId = $('<input type="text" name="tableId" />');
							    tableId.val($("#stableId").val());
							    form.append(tableId);
							    var pageNumber = $('<input type="text" name="pageNumber" />');
							    pageNumber.val($("#pageNumber").val());
							    form.append(pageNumber);
							    var productName = $('<input type="text" name="productName" />');
							    productName.val($("#sproductName").val());
							    // 附加到Form
							    form.append(productName);
							    
							    var attributeName = $('<input type="text" name="attributeName" />');
							    attributeName.val($("#sattributeName").val());
							    // 附加到Form
							    form.append(attributeName);
							    // 提交表单
							    form.submit();
							   
						   }else{
							   window.location.href=getRootPath()+"/brand/skuList.html";
						   }
						
					  });
					}else{
						$.messager.alert('立白管理系统',result.msg,'question',function(r){
							
						  });
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
 
 //删除品牌
 function delSku(objsid){
	  $.messager.confirm('立白管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata = $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : getRootPath()+'/brand/removeSku.html',
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
						$.messager.alert('立白管理系统',result.msg,'question',function(r){
							 var pageNumber=$("input[name='pageNumber']").val();
							window.location.href=getRootPath()+"/brand/skuList.html?pageNumber="+pageNumber;
							});
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
 
 //编辑
 function editSku(objsid, objTab, objPage, objAttr, objProd){
	  $.messager.confirm('立白管理系统','确定编辑吗？',function(r){
		  if(r){
			  objAttr = encodeURIComponent(encodeURIComponent(objAttr));
			  objProd = encodeURIComponent(encodeURIComponent(objProd));
			  window.location.href=getRootPath()+"/brand/showEditSku.html?id="+objsid+"&pageNumber="+objPage + "&tableId=" +objTab + "&attributeName=" +objAttr + "&productName=" +objProd;
		  }		  
	  });
	  
 }
 
 function removeAll (tag) {
		
		$.messager.confirm('立白管理系统','确定删除吗？',function(r){
			  if(r){
					invokeRemove(tag,"sku_tbl","/about/batchDelete.html");
			  }		  
		  });
		
	}
