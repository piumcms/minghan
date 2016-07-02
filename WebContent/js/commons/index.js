Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1, //month 
        "d+": this.getDate(), //day 
        "h+": this.getHours(), //hour 
        "m+": this.getMinutes(), //minute 
        "s+": this.getSeconds(), //second 
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter 
        "S": this.getMilliseconds() //millisecond 
    }
    if (/(y+)/.test(format)) 
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) 
        if (new RegExp("(" + k + ")").test(format)) 
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}


function setmain(title,href){
	$(".combo-panel").parent(".panel").remove(); //清楚所有class为combo-panel的class为panel的父元素，解决combobox在页面缓存的问题
	var centerURL = href;
	var centerTitle = title;
	$('body').layout('panel','center').panel({
		title:"所在位置："+centerTitle,
		href:centerURL
	});
//	$('body').layout('panel','center').panel('refresh');
	return false;		
}

function openTab(titlename,url){
	if ($('#tabst').tabs('exists',titlename)){
		$('#tabst').tabs('select', titlename);
	} else {
		$('#tabst').tabs('add',{
			title:titlename,
			href:url,
			closable:true,
			extractor:function(data){
				var tmp = $('<div></div>').html(data);
				/*data = tmp.find('body').html();
				alert(data);
				tmp.remove();*/
				return tmp;
			}
		});
	}
}

function convert(rows){  
    function exists(rows, parentId){  
        for(var i=0; i<rows.length; i++){  
            if (rows[i].id == parentId) return true;  
        }  
        return false;  
    }  
      
    var nodes = [];  
    // get the top level nodes  
    for(var i=0; i<rows.length; i++){  
        var row = rows[i];  
        if (!exists(rows, row.parentId)){  
            nodes.push({  
                id:row.id,  
                text:row.name  
            });  
        }  
    }  
      
    var toDo = [];  
    for(var i=0; i<nodes.length; i++){  
        toDo.push(nodes[i]);  
    }  
    while(toDo.length){  
        var node = toDo.shift();    // the parent node  
        // get the children nodes  
        for(var i=0; i<rows.length; i++){  
            var row = rows[i];  
            if (row.parentId == node.id){  
                var child = {id:row.id,text:row.name};  
                if (node.children){  
                    node.children.push(child);  
                } else {  
                    node.children = [child];  
                }  
                toDo.push(child);  
            }  
        }  
    }  
    return nodes;  
} 

/*//弹出窗口
function showWindow(options){
	$('#win').window(options).window('open');
}

//关闭弹出窗口
function closeWindow(){
	$("#win").window('close');
}

function openDialog(options){
	$("#dlg").dialog(options).dialog('open'); 
	$('#fm').form('clear'); 
}

function closeDialog(){
	('#dlg').dialog('close');
}*/