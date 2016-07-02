<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>无锡飞世龙机电有限公司|联系我们</title>
	<!-- Bootstrap -->
	<%@ include file="/vitzro/common/taglibs.jsp" %>
	<%@ include file="/vitzro/common/meta.jsp" %>
	<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/vitzro/common/header.jsp" %>

<!--main-->
<div class="productsbanner">
<img src="${ctx}/vitzro/images/contanct.jpg" width="1140" height="308"></div>

<div class="proaduct">
 
	<div class="main_grid1qqq navpro">
		<ol class="breadcrumb pull-right111">
		  <li><a href="${ctx}/index.html">首页</a></li>
          <li><a href="#">联系我们</a></li>
		  <li class="active">联系我们</li>
		</ol>
	</div>
    
</div>

<div class="proaductsss">
 <div class="main_gridddd1 asidepro">
  
   <div class="zuocebian">
      <div class="asideprocess">
      <a class="active" href="#">联系我们</a>
      
     </div>
     <img src="${ctx}/vitzro/images/products-07.png" width="212" height="336">
   </div>
     <!--右侧边-->
       <div class="rightside blue">
         <div class="aboutus-title">
             <h3>联系我们</h3> 
             <div class="contactus-p">
             <p><span class="contact-us-address">地址：</span>江苏省无锡市国家高新技术产业开发区珠江路67号</br><span class="contact-us-address">邮编：</span>214028</br>
<span class="contact-us-address">电话：</span>0510-88658080</br><span class="contact-us-address">传真：</span>0510-88651919</p>  
          <p>
<span class="contact-us-address">销售热线：</span>0510-68863330 </br> <span class="contact-us-address">技术支持：</span>13665167595</br>
<span class="contact-us-address">邮箱：</span>vitzro@wx-vitzro.com</p> </div>     
      <div class="clearfix"  ></div>
         </div>
          <div class="tab-contentrrraboutline">
             <!--百度地图容器-->
  <div style="width:893px;height:450px;border:#ccc solid 1px;" id="dituContent"></div>
</body>
<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(120.390322,31.514351);//定义一个中心点坐标
        map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    //标注点数组
    var markerArr = [{title:"无锡飞世龙机电有限公司",content:"我的备注",point:"120.390313|31.514413",isOpen:0,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
		 ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
			var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
			marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
			
			(function(){
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.addEventListener("click",function(){
				    this.openInfoWindow(_iw);
			    });
			    _iw.addEventListener("open",function(){
				    _marker.getLabel().hide();
			    })
			    _iw.addEventListener("close",function(){
				    _marker.getLabel().show();
			    })
				label.addEventListener("click",function(){
				    _marker.openInfoWindow(_iw);
			    })
				if(!!json.isOpen){
					label.hide();
					_marker.openInfoWindow(_iw);
				}
			})()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/${ctx}/vitzro/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
</script>       
          </div>
       <div class="clearfix"></div>



     </div>
   
     
   
   </div>
   <div class="clearboth"></div>
</div>
	<!--footer menu-->
	<%@ include file="/vitzro/common/menu.jsp" %>
	<%@ include file="/vitzro/common/footer.jsp" %>

</body>
</html>