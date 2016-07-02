<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8" http-equiv="Content-Type" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${ctx}/vitzro/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="${ctx}/vitzro/css/bootstrap.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${ctx}/vitzro/css/blue.css" rel="stylesheet" type="text/css" media="all" />
<!----font-Awesome----->
   	<link rel="stylesheet" href="${ctx}/vitzro/fonts/css/font-awesome.min.css">
<!----font-Awesome----->
<!-- start plugins -->
<script type="text/javascript" src="${ctx}/vitzro/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/vitzro/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/vitzro/js/bootstrap.min.js"></script>
<!--start slider -->
    <link rel="stylesheet" href="${ctx}/vitzro/css/fwslider.css" media="all">
    <script src="${ctx}/vitzro/js/jquery-ui.min.js"></script>
    <script src="${ctx}/vitzro/js/css3-mediaqueries.js"></script>
    <script src="${ctx}/vitzro/js/fwslider.js"></script>
<!--end slider -->
<!-- must have -->
<link href="${ctx}/vitzro/css/allinone_carousel.css" rel="stylesheet" type="text/css">
<script src="${ctx}/vitzro/js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="${ctx}/vitzro/js/jquery.ui.touch-punch.min.js" type="text/javascript"></script>
<script src="${ctx}/vitzro/js/allinone_carousel.js" type="text/javascript"></script>
<!--[if IE]><script src="${ctx}/vitzro/js/excanvas.compiled.js" type="text/javascript"></script>
<![endif]-->
<!-- must have -->
	<script>
		jQuery(function() {

			jQuery('#allinone_carousel_charming').allinone_carousel({
				skin: 'charming',
				width: 990,
				height: 454,
				responsive:true,
				autoPlay: 3,
				resizeImages:true,
				autoHideBottomNav:false,
				showElementTitle:false,
				verticalAdjustment:50,
				showPreviewThumbs:false,
				//easing:'easeOutBounce',
				numberOfVisibleItems:5,
				nextPrevMarginTop:23,
				playMovieMarginTop:0,
				bottomNavMarginBottom:-10
			});		
		});
		
		function viewImg(imgPath){       	
            var img_url =imgPath;
            var imagefile = new Image();
            imagefile.src = img_url;
            imagefile.onload = function() {// 加载完成后执行的事件
                var p = imagesize(this);
                imagefile.width = Math.round(this.width*p);
                imagefile.height = Math.round(this.height*p);
                $('#viewImgDiv').html(this);
            };

            imagefile.onerror = function() {
            };
        }

        imagesize = function(image) {
            var p1 = 1;
            if (image.width > 680) {
                p1 = 650 / image.width;
            }
            var p2 = 1;
            if (image.height > 480) {
                p2 = 480 / image.height;
            }
            return Math.min(p1, p2);
        };
	</script>
<!-- Owl Carousel Assets -->
<link href="${ctx}/vitzro/css/owl.carousel.css" rel="stylesheet">
<script src="${ctx}/vitzro/js/owl.carousel.js"></script>
		<script>
			$(document).ready(function() {

				$("#owl-demo").owlCarousel({
					items : 4,
					lazyLoad : true,
					autoPlay : true,
					navigation : true,
					navigationText : ["", ""],
					rewindNav : false,
					scrollPerPage : false,
					pagination : false,
					paginationNumbers : false,
				});

			});
		</script>
		<!-- //Owl Carousel Assets -->
<!-- start circle -->
<script>
(function($){
	$.fn.percentPie = function(options){

		var settings = $.extend({
			width: 100,
			trackColor: "EEEEEE",
			barColor: "E2534B",
			barWeight: 30,
			startPercent: 0,
			endPercent: 1,
			fps: 60
		}, options);

		this.css({
			width: settings.width,
			height: settings.width
		});

		var	that = this,
			hoverPolice = false,
			canvasWidth = settings.width,
			canvasHeight = canvasWidth,
			id = $('canvas').length,
			canvasElement = $('<canvas id="'+ id +'" width="' + canvasWidth + '" height="' + canvasHeight + '"></canvas>'),
			canvas = canvasElement.get(0).getContext("2d"),
			centerX = canvasWidth/2,
			centerY = canvasHeight/2,
			radius = settings.width/2 - settings.barWeight/2;
			counterClockwise = false,
			fps = 1000 / settings.fps,
			update = .01;
			this.angle = settings.startPercent;

		this.drawArc = function(startAngle, percentFilled, color){
			var drawingArc = true;
			canvas.beginPath();
			canvas.arc(centerX, centerY, radius, (Math.PI/180)*(startAngle * 360 - 90), (Math.PI/180)*(percentFilled * 360 - 90), counterClockwise);
			canvas.strokeStyle = color;
			canvas.lineWidth = settings.barWeight;
			canvas.stroke();
			drawingArc = false;
		}

		this.fillChart = function(stop){
			var loop = setInterval(function(){
				hoverPolice = true;
				canvas.clearRect(0, 0, canvasWidth, canvasHeight);

				that.drawArc(0, 360, settings.trackColor);
				that.angle += update;
				that.drawArc(settings.startPercent, that.angle, settings.barColor);

				if(that.angle > stop){
					clearInterval(loop);
					hoverPolice = false;
				}
			}, fps);
		}

		this.mouseover(function(){
			if(hoverPolice == false){
				that.angle = settings.startPercent;
				that.fillChart(settings.endPercent);
			}
		});

		this.fillChart(settings.endPercent);
		this.append(canvasElement);
		return this;
	}
}(jQuery));

$(document).ready(function() {

	$('.google').percentPie({
		width: 100,
		trackColor: "E2534B",
		barColor: "76C7C0",
		barWeight: 20,
		endPercent: .9,
		fps: 60
	});
  
  $('.moz').percentPie({
		width: 100,
		trackColor: "E2534B",
		barColor: "76C7C0",
		barWeight: 20,
		endPercent: .75,
		fps: 60
	});
  
  $('.safari').percentPie({
		width: 100,
		trackColor: "E2534B",
		barColor: "#76C7C0",
		barWeight: 20,
		endPercent: .5,
		fps: 60
	});
    
});
</script>