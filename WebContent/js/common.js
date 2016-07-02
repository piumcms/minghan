var globaleRegisterObject = new function() { };
var globaleThreeRegisterObject = new function() { };
function registerElement(ElementID, SourceElement, Width) {
    eval("globaleRegisterObject." + ElementID + " = SourceElement");
    eval("globaleRegisterObject." + ElementID + " = globaleRegisterObject." + ElementID + " + ',' +  Width");
}
function registerThreeElement(ElementID, PaddingElementID, SourceElement) {
    eval("globaleThreeRegisterObject." + ElementID + " = PaddingElementID");
    eval("globaleThreeRegisterObject." + ElementID + " = globaleThreeRegisterObject." + ElementID + " + ',' +  SourceElement");
}
function adapterElement() {
    for (var elementID in globaleRegisterObject) {
        var Element = document.getElementById(elementID);
        if (Element) {
            var array = eval("globaleRegisterObject." + elementID).split(",");
            var sourceElement = document.getElementById(array[0]);
            if (sourceElement) {
                var leftWidth = sourceElement.clientWidth - eval(array[1]);
                if (leftWidth > 0)
                    Element.style["width"] = leftWidth + "px";
            }
        }
    }
}
function adapterThreeElement() {
    for (var elementID in globaleThreeRegisterObject) {
        var Element = document.getElementById(elementID);
        if (Element) {
            var array = eval("globaleThreeRegisterObject." + elementID).split(",");
            var paddingElement = document.getElementById(array[0]);
            var sourceElement = document.getElementById(array[1]);
            if (sourceElement && paddingElement) {
                var sourceWidth = GetElemWidth(sourceElement);
                var paddingWidth = GetElemWidth(paddingElement);
                var leftWidth = sourceWidth - paddingWidth;
                if (leftWidth > 0) {
                    Element.style["width"] = leftWidth + "px";
                    //SetElemWidth(Element, leftWidth + "px");
                }
            }
        }
    }
}

function GetElemWidth(elem) {
    if (elem.tagName == "SELECT") {
        return elem.offsetWidth;
    }
    else {
        return elem.clientWidth;
    }
}
function SetElemWidth(elem, width) {
    if (elem.tagName == "SELECT") {
        elem.scrollWidth = width;
    }
    else {
        elem.scrollWidth = width;
    }
}

function bindListener(eventName, functionName) {
    // DOM2
    if (typeof window.addEventListener != "undefined")
        window.addEventListener(eventName, functionName, false);

    // IE 
    else if (typeof window.attachEvent != "undefined") {
        window.attachEvent("on" + eventName, functionName);
    }

    else {
        if (eval("window.on" + eventName) != null) {
            var oldOnload = eval("window.on" + eventName);
            eval("window.on" + eventName + " = function ( e ) { oldOnload( e ); " + functionName + "();}")
        }
        else
            eval("window.on" + eventName + " = " + functionName + ";");
    }
}
bindListener("resize", adapterElement);
bindListener("resize", adapterThreeElement);
//bindListener("load", adapterElement);

function ClickElem(element) {
    if (element != null) {
        if (document.all && typeof (document.all) == "object")   //IE
        {
            element.click();
            //elemID.fireEvent("onclick");
        }
        else {
            if (element.tagName.toLowerCase() == "a") {
                eval(element.href);
            }
            else if (element.tagName.toLowerCase() == "input") {
                eval("element.click()");
            }
            else {
                var e = document.createEvent('MouseEvent');
                e.initEvent('click', true, false);
                elemID.dispatchEvent(e);
            }
        }
    }
}

function GetElemPosition(element) {
    var result = new Object();
    result.x = 0;
    result.y = 0;
    result.width = 0;
    result.height = 0;
    if (element.offsetParent) {
        result.x = element.offsetLeft;
        result.y = element.offsetTop;
        var parent = element.offsetParent;
        while (parent) {
            result.x += parent.offsetLeft;
            result.y += parent.offsetTop;
            var parentTagName = parent.tagName.toLowerCase();
            if (parentTagName != "table" &&
                parentTagName != "body" &&
                parentTagName != "html" &&
                parentTagName != "div" &&
                parent.clientTop &&
                parent.clientLeft) {
                result.x += parent.clientLeft;
                result.y += parent.clientTop;
            }
            parent = parent.offsetParent;
        }
    }
    else if (element.left && element.top) {
        result.x = element.left;
        result.y = element.top;
    }
    else {
        if (element.x) {
            result.x = element.x;
        }
        if (element.y) {
            result.y = element.y;
        }
    }
    if (element.offsetWidth && element.offsetHeight) {
        result.width = element.offsetWidth;
        result.height = element.offsetHeight;
    }
    else if (element.style && element.style.pixelWidth && element.style.pixelHeight) {
        result.width = element.style.pixelWidth;
        result.height = element.style.pixelHeight;
    }
    return result;
}

function trim(text) {
    return text.replace(/^\s+|\s+$/g, "");
}

function lTrim(text) {
    return text.replace(/^\s+/g, "");
}

function rTrim(text) {
    return text.replace(/\s+$/g, "");
}

function textValidate(text) {
    var regex = new RegExp("^.*(<+)|(>+)|('.*=)+|(\".*=)+.*$");
    var result = regex.exec(text);
    if (result) {
        return false;
    }
    else {
        return true;
    }
}

function SetFocus(id) {
    try {
        var elem = document.getElementById(id);
        elem.focus();
    }
    catch (e) {
    }
}

///<summary>
/// 判断对象是否为空
///<summary>
function IsNull(o) {
    return ("undefined" == typeof (o) || "unknown" == typeof (o) || null == o);
}

///<summary>
/// 弹出窗体的对话框，主要做了如下事情，1.弹出窗口阻止程序检测；2.刚好处于屏幕的最中央；3.允许弹出多个窗体
///<summary>
///<param name="url">要打开的地址</param>
///<param name="width">打开的窗口的宽度</param>
///<param name="height">打开的窗口的高度</param>
///<param name="scrollbars">是否出现滚动条，yes表示允许，no表示不允许。可以不输入，默认为no</param>
///<param name="resizable">是否允许改变窗口大小，yes表示允许，no表示不允许。可以不输入，默认为no</param>
///<return>窗体的变量</return>
function OpenWindow(url, width, height, scrollbars, resizable) {
    if (IsNull(scrollbars))
        scrollbars = 'no';
    if (IsNull(resizable))
        resizable = 'no';
    var windowOpened = null;
    try {
        windowOpened = window.open(url, "_blank", 'width=' + width + ',height=' + height + ',toolbar=no,location=no,directories=no,status=yes,menubar=no,scrollbars=' + scrollbars + ',resizable=' + resizable + ',left=' + (screen.width - width) / 2 + ',top=' + (screen.height - height) / 2);
    }
    catch (e) {
        alert("打开窗口失败，窗体可能已经被打开，请关闭后重试！");
    }
    if (IsNull(windowOpened)) {
        alert("平台窗口无法打开，可能已被弹出窗口阻止程序所阻止。请将该服务地址添加到您的弹出窗口阻止程序允许打开新窗口的站点的列表中：" + window.location.hostname);
    }
    return windowOpened;
}

///<summary>
/// 弹出模态窗体的对话框，主要做了如下事情，1.弹出窗口阻止程序检测；2.刚好处于屏幕的最中央；3.允许弹出多个窗体
///<summary>
///<param name="url">要打开的地址</param>
///<param name="width">打开的窗口的宽度</param>
///<param name="height">打开的窗口的高度</param>
///<param name="scrollbars">是否出现滚动条，yes表示允许，no表示不允许。可以不输入，默认为no</param>
///<param name="resizable">是否允许改变窗口大小，yes表示允许，no表示不允许。可以不输入，默认为no</param>
///<return>窗体的变量</return>
function OpenModelWindow(url, width, height, scrollbars, resizable) {
    var windowOpened = null;
    try {
        windowOpened = window.showModalDialog(url, 'newwindow', 'dialogWidth=' + width + 'px;dialogHeight=' + height + 'px;scroll:no;');
        if (windowOpened != null) {
            window.location.reload();
        }
    }
    catch (e) {
        alert("打开窗口失败，窗体可能已经被打开，请关闭后重试！");
    }
    if (IsNull(windowOpened)) {
        alert("平台窗口无法打开，可能已被弹出窗口阻止程序所阻止。请将该服务地址添加到您的弹出窗口阻止程序允许打开新窗口的站点的列表中：" + window.location.hostname);
    }
    return windowOpened;
}

///<summary>
/// 选取公司的弹出框
///<summary>
///<param name="strCompanyPageUrl">公司选择对话框地址</param>
///<param name="strCompanyType">要查看的公司类型</param>
///<param name="strTextId">文本框名称</param>
///<param name="strHdnId">隐藏控件名称</param>
///<param name="strLimCount">限制的个数，如果不限制，则传入为0</param>
///<param name="isBelongVar">ec是否属于var,1:ec属于var;0:ec游离于var之外;-1:该属性不起作用,返回所有信息(注：目前用的场景就是op查询非var的ec加0，其他用户不用考虑)</param>
function SelectCompany(strCompanyPageUrl, strCompanyType, strTextId, strHdnId, strLimCount, isBelongVar) {
    if (strCompanyPageUrl == null || strCompanyPageUrl == "" || strCompanyType == null || strCompanyType == "" || strTextId == "" || strHdnId == "" || strLimCount == null) {
        alert('信息不完整');
        return;
    }
    var hiddenValue = document.getElementById(strHdnId);
    if (hiddenValue) {
        var sPath = strCompanyPageUrl + "?strCompanyType=" + strCompanyType + "&strIds=" + hiddenValue.value + "&strTextId=" + strTextId + "&strHdnId=" + strHdnId + "&strLimCount=" + strLimCount + "&isBelongVar=" + isBelongVar;
        strFeatures = "height=600, width=800, toolbar =no, menubar=no, scrollbars=auto, resizable=no, location=no, status=no";
        window.open(sPath, '', strFeatures);
    }
    else {
        alert('信息不完整');
        return;
    }
}

///<summary>
/// 选取公司的弹出框
///<summary>
///<param name="strCompanyPageUrl">公司选择对话框地址</param>
///<param name="strCompanyType">要查看的公司类型</param>
///<param name="strTextId">文本框名称</param>
///<param name="strHdnId">隐藏控件名称</param>
///<param name="strLimCount">限制的个数，如果不限制，则传入为0</param>
///<param name="isBelongVar">ec是否属于var,1:ec属于var;0:ec游离于var之外;-1:该属性不起作用,返回所有信息(注：目前用的场景就是op查询非var的ec加0，其他用户不用考虑)</param>
///<param name="IsContainVirtualVarOfEC">是否包含虚拟VAR下的EC</param>
function SelectCompanyNew(strCompanyPageUrl, strCompanyType, strTextId, strHdnId, strLimCount, isBelongVar, IsContainVirtualVarOfEC) {
    if (strCompanyPageUrl == null || strCompanyPageUrl == "" || strCompanyType == null || strCompanyType == "" || strTextId == "" || strHdnId == "" || strLimCount == null) {
        alert('信息不完整');
        return;
    }
    var hiddenValue = document.getElementById(strHdnId);
    if (hiddenValue) {
        var sPath = strCompanyPageUrl + "?strCompanyType=" + strCompanyType + "&strIds=" + hiddenValue.value + "&strTextId=" + strTextId + "&strHdnId=" + strHdnId + "&strLimCount=" + strLimCount + "&isBelongVar=" + isBelongVar + "&IsContainVirtualVarOfEC=" + IsContainVirtualVarOfEC;
        strFeatures = "height=600, width=800, toolbar =no, menubar=no, scrollbars=auto, resizable=no, location=no, status=no";
        window.open(sPath, '', strFeatures);
    }
    else {
        alert('信息不完整');
        return;
    }
}

function UseClientShowImg(Pre, ImgShow, UploadFile) {
    var Img = document.getElementById(Pre + ImgShow);
    var File = document.getElementById(Pre + UploadFile).value;
    Img.src = File;
}


function GetContact() {
    var contact = document.getElementById('txtContact');
    if (contact.value == "") {
        alert('请填写要查找的人的姓名！');
        return;
    }
    contact.value = contact.value.replace(' ', '')
    window.OpenWindow("CompanyManager/TenantCommNotesMgmt.aspx?Contact=" + encodeURI(contact.value), 800, 600, 'no', 'no');
}
function EnterPress() {
    if (event.keyCode == 13)
        GetContact();
}
/*********************************************************************************/
/*********Update password begin***************************************************/
/*********************************************************************************/
/*********************************************************************************/
/*---------------For Update password begin----------------*/
function PasswordStrength(showed) {
    this.showed = (typeof (showed) == "boolean") ? showed : true;
    this.styles = new Array();
    this.styles[0] = { backgroundColor: "#EBEBEB", borderLeft: "solid 1px #FFFFFF", borderRight: "solid 1px #BEBEBE", borderBottom: "solid 1px #BEBEBE", textAlign: "center" };
    this.styles[1] = { backgroundColor: "#FF4545", borderLeft: "solid 1px #FFFFFF", borderRight: "solid 1px #BB2B2B", borderBottom: "solid 1px #BB2B2B", textAlign: "center" };
    this.styles[2] = { backgroundColor: "#FFD35E", borderLeft: "solid 1px #FFFFFF", borderRight: "solid 1px #E9AE10", borderBottom: "solid 1px #E9AE10", textAlign: "center" };
    this.styles[3] = { backgroundColor: "#95EB81", borderLeft: "solid 1px #FFFFFF", borderRight: "solid 1px #3BBC1B", borderBottom: "solid 1px #3BBC1B", textAlign: "center" };

    this.labels = ["弱", "中", "强"];

    this.divName = "pwd_div_" + Math.ceil(Math.random() * 100000);
    this.minLen = 5;

    this.width = "150px";
    this.height = "16px";

    this.content = "";

    this.selectedIndex = 0;

    this.init();
}

PasswordStrength.prototype.init = function() {
    var s = '<table cellpadding="0" id="' + this.divName + '_table" cellspacing="0" style="width:' + this.width + ';height:' + this.height + ';text-align:center !important">';
    s += '<tr>';
    for (var i = 0; i < 3; i++) {
        s += '<td id="' + this.divName + '_td_' + i + '" width="33%" align="center"><span style="font-size:1px">&nbsp;</span><span id="' + this.divName + '_label_' + i + '" style="display:none;font-family: Courier New, Courier, mono;font-size: 12px;color: #000000; text-align:center">' + this.labels[i] + '</span></td>';
    }
    s += '</tr>';
    s += '</table>';
    this.content = s;
    if (this.showed) {
        document.write(s);
        this.copyToStyle(this.selectedIndex);
    }
}
PasswordStrength.prototype.copyToObject = function(o1, o2) {
    for (var i in o1) {
        o2[i] = o1[i];
    }
}
PasswordStrength.prototype.copyToStyle = function(id) {
    this.selectedIndex = id;
    for (var i = 0; i < 3; i++) {
        if (i == id - 1) {
            this.$(this.divName + "_label_" + i).style.display = "inline";
        } else {
            this.$(this.divName + "_label_" + i).style.display = "none";
        }
    }
    for (var i = 0; i < id; i++) {
        this.copyToObject(this.styles[id], this.$(this.divName + "_td_" + i).style);
    }
    for (; i < 3; i++) {
        this.copyToObject(this.styles[0], this.$(this.divName + "_td_" + i).style);
    }
}
PasswordStrength.prototype.$ = function(s) {
    return document.getElementById(s);
}
PasswordStrength.prototype.setSize = function(w, h) {
    this.width = w;
    this.height = h;
}
PasswordStrength.prototype.setMinLength = function(n) {
    if (isNaN(n)) {
        return;
    }
    n = Number(n);
    if (n > 1) {
        this.minLength = n;
    }
}
PasswordStrength.prototype.setStyles = function() {
    if (arguments.length == 0) {
        return;
    }
    for (var i = 0; i < arguments.length && i < 4; i++) {
        this.styles[i] = arguments[i];
    }
    this.copyToStyle(this.selectedIndex);
}
PasswordStrength.prototype.write = function(s) {
    if (this.showed) {
        return;
    }
    var n = (s == 'string') ? this.$(s) : s;
    if (typeof (n) != "object") {
        return;
    }
    n.innerHTML = this.content;
    this.copyToStyle(this.selectedIndex);
}
PasswordStrength.prototype.update = function(s) {
    if (s.length < this.minLen) {
        this.copyToStyle(0);
        return;
    }
    var ls = -1;
    if (s.match(/[a-z]/ig)) {
        ls++;
    }
    if (s.match(/[0-9]/ig)) {
        ls++;
    }
    if (s.match(/(.[^a-z0-9])/ig)) {
        ls++;
    }
    if (s.length < 6 && ls > 0) {
        ls--;
    }
    switch (ls) {
        case 0:
            this.copyToStyle(1);
            break;
        case 1:
            this.copyToStyle(2);
            break;
        case 2:
            this.copyToStyle(3);
            break;
        default:
            this.copyToStyle(0);
    }
}
/*------------for update password end---------*/

/*--select color---*/
function getMyColor(elem, selectColorID) {
    var selectColorElem = document.getElementById(selectColorID);
    var old_color = (selectColorElem.value.indexOf('#') == 0) ? '?' + selectColorElem.value.substr(1) : '?' + selectColorElem.value;
    var color = showModalDialog("../../JS/SelectColor/ColorSelector.htm" + old_color + "", "", "dialogWidth:300px; dialogHeight:250px; status:no; resizable:no");
    if (color != null && selectColorElem != null) {
        selectColorElem.value = color;
        elem.style["background"] = color;
    }
    else {
        elem.focus();
    }
    return true;
}
/*--end select color----*/

/*--------- the verify code utility function ---------*/
var verifyCodeUpdateTime = new Date();
function ChangeVerifyCode(imgID) {
    var imageElem = document.getElementById(imgID);
    if (imageElem && imageElem.src != null) {
        var imgSrc = imageElem.src.replace(/\?time\=.*/, "");
        imgSrc += "?time=" + Math.random();
        imageElem.src = imgSrc;
        verifyCodeUpdateTime = new Date();
    }
}
function ShowTheVerifyCode(inputElem, imgID) {
    verifyCodeUpdateTime = new Date();
    var imageElem = document.getElementById(imgID);
    if (imageElem && imageElem.style['display'] != null) {
        if (imageElem.style['display'] == 'none') {
            imageElem.style['display'] = 'block';
        }
        inputElem.value = "";
        ChangeVerifyCode(imgID);
    }
}
function VerifyCodeSubmitCheck(imgID, txtVerifyCodeID) {
    var different = (new Date()).getTime() - verifyCodeUpdateTime.getTime();
    different = Math.floor(different / (1000 * 60));
    if (different > 20) {
        window.alert("您填写的验证码已经过期，请重新填写！");
        var verifyCodeInput = document.getElementById(txtVerifyCodeID);
        if (verifyCodeInput) {
            verifyCodeInput.value = "";
            SetFocus(txtVerifyCodeID);
            ChangeVerifyCode(imgID);
        }
        return false;
    }
    else {
        return true;
    }
}
/*--------- the verify code utility function ---------*/

/*什么都不做，做一个连接的点击*/
function voidCheck()
{ }

/*-------- Portal 分页时跳转页码用到-----------------*/

//页面跳转聚焦
function focusToPage() {
    if (event.keyCode == 13) {
        document.getElementById('<%=imgGoto.ClientID %>').focus();
    }
}

function onblurFocusToPage() {
    document.getElementById('<%=imgGoto.ClientID %>').focus();
}