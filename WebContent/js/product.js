//品牌相关js代码
var editor1;
var editor2;
var editor3;
var editor4;
var editor5;
var editor6;
var showNoteKeys = ["superb", "vewin", "xilan","zkmed","vitzro"];
var showNoteDescs = ["superb","zkmed","vitzro"];
var showNoteValues = ["superb", "vewin", "xilan","zkmed","vitzro"];
var showProductDescs = ["beibeij", "vewin", "xilan","zkmed","vitzro"];
KindEditor.ready(function(K) {
	editor1 = K.create('textarea[name="productDesc"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	editor2 = K.create('textarea[name="shortDesc"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	editor3 = K.create('textarea[name="noteValue1"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	editor4 = K.create('textarea[name="noteValue2"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	editor5 = K.create('textarea[name="noteValue3"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	editor6 = K.create('textarea[name="noteValue4"]', {
		uploadJson : ctx + '/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : ctx + '/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true
	});
	K('#image3').click(function() {
		editor1.loadPlugin('image', function() {
			editor1.plugin.imageDialog({
				showRemote : false,
				imageUrl : K('#picture').val(),
				clickFn : function(url, title, width, height, border, align) {
					$('#picSrc').val(url);
					$("#img").attr('src', url);
					editor1.hideDialog();
				}
			});
		});
	});
	
});

 $(document).ready(function() { 
	//保存Brand
	
	 
	 $("#submit").click(function() {
			var obj = new Object();
			obj.id=$('#id').val();
			obj.productName = $("#productName").val();
			obj.language = $("#language").val();
			if (obj.productName == "") {
				$.messager.alert('飞世龙机电管理系统','产品名称不能为空!','warning');
				return false;
			}
			obj.taobaoUrl=$("#taobaoUrl").val();
			if (obj.taobaoUrl == "") {
				$.messager.alert('飞世龙机电管理系统','淘宝地址不能为空!','warning');
				return false;
			}
			obj.picSrc=$("#picSrc").val();
			var html = editor1.html();
//			if (html == "") {
//				$.messager.alert('飞世龙机电管理系统','内容描述不能为空','warning');
//				return false;
//			}
			$("#productDesc").val(html);
			obj.productDesc=$("#productDesc").val();
			
			var html2 = editor2.html();
			if (html2 == "") {
				$.messager.alert('明翰CMS管理系统','内容描述不能为空','warning');
				return false;
			}
			$("#shortDesc").val(html2);
			obj.shortDesc=$("#shortDesc").val();
			
			obj.noteKey1=$("#noteKey1").val();
			obj.noteDesc1=$("#noteDesc1").val();
			var html3 = editor3.html();
			$("#noteValue1").val(html3);
			obj.noteValue1=$("#noteValue1").val();
			
			obj.noteKey2=$("#noteKey2").val();
			obj.noteDesc2=$("#noteDesc2").val();
			var html4 = editor4.html();
			$("#noteValue2").val(html4);
			obj.noteValue2=$("#noteValue2").val();

			obj.noteKey3=$("#noteKey3").val();
			obj.noteDesc3=$("#noteDesc3").val();
			var html5 = editor5.html();
			$("#noteValue3").val(html5);
			obj.noteValue3=$("#noteValue3").val();
			
			obj.noteKey4=$("#noteKey4").val();
			obj.noteDesc4=$("#noteDesc4").val();
			var html6 = editor6.html();
			$("#noteValue4").val(html6);
			obj.noteValue4=$("#noteValue4").val();
			
			obj.tableId=$("#subBrandId").val();
			if ($("#subBrandId").val()=='0') {
				$.messager.alert('明翰CMS管理系统','请选择子品牌！','warning');
				return false;
			}
			obj.tableId=$("#tableId").val();
			obj.pw=$("#pw").val();
			/**
			if ($("#pw").val()=='0') {
				$.messager.alert('飞世龙机电管理系统','排位不能为空！','warning');
				return false;
			}
			**/
			var chk_value =""; 
			$('input[name="tag"]:checked').each(function(){ 
				chk_value+=($(this).val())+","; 
			}); 
			obj.tags=chk_value;
			var jsondata =  JSON.stringify(	obj);
		    $.ajax({
		    	type : 'POST',
				url : ctx+'/product/saveProduct.html',
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
					   $.messager.alert('明翰CMS管理系统',result.msg,'question',function(r){
						   if ($('#id').val() != "") {
							// 创建Form
							    var form = $('<form></form>');
							    // 设置属性
							    form.attr('action', ctx+"/product/"+$("#brandType").val()+"/list.html");
							    form.attr('method', 'post');
							    var pageNumber = $('<input type="text" name="pageNumber" />');
							    pageNumber.val($("#pageNumber").val());
							    form.append(pageNumber);
							    var productName = $('<input type="text" name="productName" />');
							    productName.val($("#searchProductName").val());
							    // 附加到Form
							    form.append(productName);
							    // 提交表单
							    form.submit();
							   
						   } else {
							   window.location.href=ctx+"/product/"+$("#brandType").val()+"/list.html";
						   }
						   
					  });
					}else{
						$.messager.alert('明翰CMS管理系统',result.msg,'question',function(r){
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
 function delProduct(objsid){
	  var pageNumber=$("input[name='pageNumber']").val();
	  $.messager.confirm('明翰CMS管理系统','确定删除吗？',function(r){
		  if(r){
			    var obj = new Object();
			    obj.id=objsid;
			    var jsondata =  $.toJSON(obj);
			    $.ajax({
			    	type : 'POST',
					url : ctx+'/product/remove.html',
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
							window.location.href=ctx+"/product/"+$("#brandType").val()+"/list.html?pageNumber="+pageNumber;
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
 function editProduct(objsid, objPage, objTab, objProd){
	  $.messager.confirm('明翰CMS管理系统','确定编辑吗？',function(r){
		  if(r){
			  objProd = encodeURIComponent(encodeURIComponent(objProd));
			  window.location.href=ctx+"/product/"+$("#brandType").val()+"/showEditProduct.html?id="+objsid+"&pageNumber="+objPage+"&productName=" + objProd;
		  }		  
	  });
 }
 
 function removeAll(tag){
	 var pageNumber=$("input[name='pageNumber']").val();
	 var productIds = "";
	 var checks = $("input[type='checkbox']");
	 for (var i=0;i<checks.length;i++) {
	    	var check = checks.eq(i);
	    	if ($(check).attr("checked")) {
	    		var productId = $(check).parent().parent().parent().attr("id");
	    		productId = productId.replace("productList_row", "");
	    		productIds = productIds + productId + ",";
	    	}
	    }
	 if (productIds=="") {
	    	$.messager.alert('请选择要删除的条目!','warning');
	 } else {
		 productIds = productIds.substring(0, productIds.length-1);
		 $.messager.confirm('飞世龙机电管理系统','确定删除吗？',function(r){
			  if(r){
				    var obj = new Object();
				    //obj.id="";
				    var jsondata =  $.toJSON(obj);
				    
				    
				    	
				    	$.ajax({
					    	type : 'POST',
							url : ctx+'/product/removeProducts.html?ids='+productIds,
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
									window.location.href=ctx+"/product/"+$("#brandType").val()+"/list.html?pageNumber="+pageNumber;
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
 
 function sendToFrontpage(ob_id) {
		var pageNumber=$("input[name='pageNumber']").val();
		$.messager.prompt('飞世龙机电管理系统', '推送首页显示,输入0，取消推送;1.推送', function(r) {
			if (r) {
				if (!/^[0-9]*$/.test(r)) {
					alert("请输入数字!");
					return false;
				}
				var obj = new Object();
				obj.id = ob_id;
				obj.pw = r;
				var jsondata = $.toJSON(obj);
				$.ajax({
					type : 'POST',
					url : ctx+'/product/saveProduct.html',
					data : jsondata,
					dataType : 'json',
					contentType : 'application/json',
					beforeSend : function(XMLHttpRequest) {
						$.messager.progress({
							title : 'Please waiting',
							msg : 'Loading data...'
						});
					},
					success : function(result) {
						$.messager.alert('飞世龙机电管理系统', result.msg);
						window.location.href=ctx+"/product/"+$("#brandType").val()+"/list.html?pageNumber="+pageNumber;
					},
					complete : function(XMLHttpRequest, textStatus) {
						$.messager.progress('close');
					},
					error : function(jqXHR, textStatus, errorThrown) {
						top.location.href = getRootPath() + "/common/error";
					}
				});

			}
		});
	}
 
