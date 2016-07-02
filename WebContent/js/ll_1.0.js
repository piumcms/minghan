/**
 * 获取当前分页form。
 */
 var getFormByTableId = function(id) {
        var node = document.getElementById(id);
        var found = false;
        while (!found) {
            if (node.nodeName == 'FORM') {
                found = true;
                return node;
            }
            node = node.parentNode;
        }
        return null;
    };

/**
 * 分页。
 * @param tag 当前formId
 * @param obj 页码值
 */
function clickPage(tag, obj) {
    var form = getFormByTableId(tag);
    $('input[name="pageNumber"]', form).val(obj);
    $('input[name="exportType"]', form).val("");
    $(form).submit();
}

/**
 * 切换最大页。
 * @param tag
 * @param obj
 */
function changeMaxPages(tag, obj) {
    var form = getFormByTableId(tag);
    $('input[name="maxRows"]', form).val(obj);
    $('input[name="pageNumber"]', form).val(1);
    $('input[name="exportType"]', form).val("");
    $(form).submit();
}

/**
 * 数据导出
 * @param tag tableId
 * @param obj 数据导出类型
 */
function exportData(tag, obj) {
    var form = getFormByTableId(tag);
    $('input[name="exportType"]', form).val(obj);
    $(form).submit();
}

/**
 * 全选。
 * @param tag
 */
function checkAll(tag) {
    $('input[type="checkbox"]','.tableStyle').attr("checked", true);
}

/**
 * 反选。
 * @param tag
 */
function inverseSelection(tag) {
    $('input[type="checkbox"]','.tableStyle').each(function(){
        if ($(this).attr("checked")) {
            $(this).attr("checked", false);
        } else {
            $(this).attr("checked", true);
        }
    });
}

/**
 * 批量删除。
 * @param tag
 */
function invokeRemove(tag,tableName, ac) {
	var form = getFormByTableId(tag);
    var ids = new Array();
    $('input[type="checkbox"]:checked','.tableStyle').each(function(){
        var currentTR = $(this).parent().parent().parent();
        currentTR = currentTR.attr("id");
        ids.push(currentTR.substring(currentTR.lastIndexOf("row") + 3));
    });
    if (ids.length > 0) {
        var jsonObject = {ids:ids.join(","),tableName:tableName};
        var data = JSON.stringify(jsonObject);
        var path = $("input[name='"+tag+"_ctx_']").val();
        $.ajax({
            type:'post',
            url:path + ac,
            data:data,
            dataType: 'json',
            contentType:'application/json;',
            beforeSend: function(XMLHttpRequest){
            	 $.messager.progress({
				        title:'Please waiting',
				        msg:'Loading data...'
				    });
            },
            success:function(result){
            	
            	var items = result.messList;
            	var info = "" ;
            	for (var i = 0; i < items.length; i++) {
            		info = info + items[i].message + '<br/>';
            		
            	}
            	if (info.length > 1) {
            		info = info.substring(0, info.lastIndexOf("<br/>"));
            		alert(info);
                	return false;
            	}
                // 刷新当前分页
                $('input[name="exportType"]', form).val("");
                $(form).submit();
            },
            complete: function(XMLHttpRequest, textStatus){
            	 $.messager.progress('close');
            },
            error:function(jqXHR, textStatus, errorThrown){ 
            	top.location.href=path + "/common/error";
           }
        });
    }
}
$(function() {
    /**
     * 分页跳转。
     */
    $('.page_input').keydown(function(e){
        var array  = $(this).attr("title").split("_");
        if(e.keyCode==13){
             var reg = new RegExp("^[0-9]*$");
            if($(this).val() != "" && !reg.test($(this).val())){
                $.dialog.alert("请输入数字!");
                return false;
            }
            if ($(this).val() != "" && parseInt(array[1]) < $(this).val()) {
            	 $.dialog.alert("输入页码大于总页数");
                return false;
            }
            if ($(this).val() == "") {
            	$.dialog.alert("请输入页码");
                return false;
            }
            var form = getFormByTableId(array[0]);
            $('input[name="pageNumber"]', form).val($(this).val());
            $('input[name="exportType"]', form).val("");
            $(form).submit();
        }
    });
    
    /**
     * edit cell
     */
    $(".editEvent").click(function(){
    	//创建文本框对象 
    	var inputobj = $("<input type='text' name='editCell' onchange='javascript:$.editSubjectValue(this)'>"); 
    	//获取当前点击的单元格对象 
    	var tdobj = $(this); 
    	var width = tdobj.width();
    	var height = tdobj.height();
    	//获取单元格中的文本 
    	var text = tdobj.text();
    	//如果当前单元格中有文本框，就直接跳出方法 
    	//注意：一定要在插入文本框前进行判断 
    	
    	if(tdobj.children("input").length>0){ 
    		//alert(tdobj.children("input").length);
    		return false; 
    	} 
    	//清空单元格的文本 
    	tdobj.html(""); 
    	inputobj.css("border","0") 
    	.css("font-size",tdobj.css("font-size")) 
    	.css("font-family",tdobj.css("font-family")) 
    	.css("background-color",tdobj.css("background-color")) 
    	.css("color","#C75F3E") 
    	.width(width)
    	.height(height-2)
    	.val(text)
    	.attr("title", text)
    	.appendTo(tdobj); 
    	tdobj.width(width)
    	.height(height);
    	inputobj.get(0).select(); 
    	//阻止文本框的点击事件 
    	inputobj.click(function(){ 
    	return false; 
    	}); 
    });
});
 
/**
 * 清除
 * @param obj
 */
function clearAll(obj) {
	$("input[name='editCell']", "#" + obj).each(function(){
		$(this).parent().text($(this).attr("title"));
	});
}

/**
 * 保存。
 * @param ob
 */
function saveAjaxAll(ob, objAction) {
	var path = $("input[name='"+ob+"_ctx_']").val();
	var objArray = new Array();
	var obj = new Object();
	$("input[name='editCell']", "#" + ob).each(function(){
		if (($(this).val() == "" &&  $(this).attr("title") != "") || ($(this).val() != "" &&  $(this).attr("title") == "") ||
				$(this).val() != $(this).attr("title")) {
			obj = new Object();
			var rowIds = $(this).parent().parent().attr("id");
			obj.rowId = rowIds.substring(rowIds.lastIndexOf("row") + 3);
			var columnIds = $(this).parent().attr("id");
			obj.columnId = columnIds.substring(columnIds.lastIndexOf("_") + 1);
			obj.subjectValue = $(this).val();
			objArray.push(obj);
		} else {
			$(this).parent().text($(this).val());
		}
	});
	if (objArray.length <= 0) {
		return false;
	}
	$.ajax( {
		type : 'POST',
		url : path + objAction,
		data : JSON.stringify(objArray),
		dataType : 'json',
		contentType : 'application/json',
		 beforeSend: function(XMLHttpRequest){
                $("body").mask("Waiting...");
            },
		success : function(result) {
			if (result.status == "1") {
				var items = result.list;
            	var info = "" ;
            	for (var i = 0; i < items.length; i++) {
            		info = info + items[i].message + '<br/>';
            	}
            	if (info.length > 1) {
            		info = info.substring(0, info.lastIndexOf("<br/>"));
            		alert(info);
                	return false;
            	}
			} else {
				alert("保存成功");
				$("input[name='editCell']", "#" + ob).each(function(){
					$(this).parent().text($(this).attr("title"));
				});
               
			}
		},
        complete: function(XMLHttpRequest, textStatus){
            $("body").unmask();
       },
       error:function(jqXHR, textStatus, errorThrown){ 
       	top.location.href=path + "/common/error";
      }
	});
}
