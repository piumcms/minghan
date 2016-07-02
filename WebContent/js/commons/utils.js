/**
 * 获取数组中当前记录的索引
 * @param val
 * @returns {Number}
 */
Array.prototype.indexOf = function(val) {
	for ( var i = 0; i < this.length; i++) {
		if (this[i] == val)
			return i;
	}
	return -1;
};

/**
 * 去除数组中指定记录
 * @param val
 */
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	}
};

/**
 * 数组中存在当前记录，删除，否则增加
 */
Array.prototype.add = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
		this.splice(index, 1);
	} else {
		this.push(val);
	}
};

/**
 * 删除数组指定索引记录
 * @param dx
 * @returns {Boolean}
 */
Array.prototype.removeByIndex = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	this.splice(dx, 1);
};

/**
 * 去除前后空格
 * @returns
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 去除左空格
 * @returns
 */
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, "");
};

/**
 * 去除右空格
 * @returns
 */
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, "");
};

//js获取项目根路径
function getRootPath() {
	var thisTHost = top.location.hostname;
	if (thisTHost.indexOf(".com") != -1 || thisTHost.indexOf(".cn") != -1) {
		return "http://" + thisTHost;
	} else {
		//获取当前网址
		var curWwwPath = window.document.location.href;
		//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp    
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		//获取主机地址，如： http://localhost:8083    
		var localhostPaht = curWwwPath.substring(0, pos);
		//获取带"/"的项目名，如：/uimcardprj    
		var projectName = pathName.substring(0,
				pathName.substr(1).indexOf('/') + 1);
		return (localhostPaht + projectName);
	}

}

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
/**
 * 下载
 * @param obj1 路径
 * @param obj2 文件名
 * @param obj3 类型
 * example:download('xls', '企业数据样例.xls','1')
 */
function download(obj1, obj2, obj3) {
	if ($("#ifr_down").length > 0) {

	} else {
		$(
				"<iframe style='display: none' src='about:blank' id='ifr_down' name='download_ifr' style='position:absolute; top:-9999px; left:-9999px'></iframe>")
				.appendTo("body");
		$(
				'<form   method="GET" id="downLoadForm" target="download_ifr"></form>')
				.appendTo("body");
	}
	obj2 = encodeURIComponent(encodeURIComponent(obj2));
	var href = getRootPath() + "/download/file/" + obj1 + "/" + obj2 + "/"
			+ obj3;
	$("#downLoadForm").attr("action", href);
	$("#downLoadForm").submit();

}
function progress(){
    var win = $.messager.progress({
        title:'Please waiting',
        msg:'Loading data...'
    });
    setTimeout(function(){
        $.messager.progress('close');
    },5000);
}