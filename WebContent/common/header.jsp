<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="top_box">
	<div class="top">
		<%-- <div class="fl">
            <a href="javascript:;"><img src="${ctx}/imgs/top/weibo.png" alt=""/></a>
            <a href="javascript:;"><img src="${ctx}/imgs/top/weixin.png" alt=""/></a>
        </div> --%>
 		<div class="bdsharebuttonbox fl">
 			<a href="#" class="bds_more" data-cmd="more"></a>
 			<a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a>
 			<a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a>
 			<a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a>
 			<a title="分享到腾讯微博" href="#" class="bds_tqq" data-cmd="tqq"></a>
 			<a title="分享到人人网" href="#" class="bds_renren" data-cmd="renren"></a>
 		</div>
		<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":["mshare","qzone","weixin","tsina","fbook","twi","renren","tqq","tqf","taobao","douban","tsohu","bdysc","bdxc","kaixin001","tieba","bdhome","sqq","thx","qq","ibaidu","hi","baidu","sohu","t163","qy","meilishuo","mogujie","diandian","huaban","leho","share189","duitang","hx","tfh","fx","youdao","sdo","qingbiji","ifeng","people","xinhua","ff","mail","kanshou","isohu","yaolan","wealink","xg","ty","iguba","deli","s51","s139","linkedin","copy","print"],"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{},"image":{"viewList":["qzone","weixin","tsina","tqq","renren"],"viewText":"分享到：","viewSize":"24"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","weixin","tsina","tqq","renren"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
 		<script>
        	$(function(){
        		$("div.bdsharebuttonbox > a").each(function(idx){
        			$(this).attr("style","margin:3px 6px 3px 0px");
        		});
        	})
        </script>
 		       
        <div class="fr">
        	<a href="mailto:zekang@js-zkmed.com"><img src="${ctx}/imgs/top/email.png" alt=""/>zekang@js-zkmed.com</a>
            <img class="phone" src="${ctx}/imgs/top/phone.png" alt=""/>0510-85388899 
            <select class="en_cn">
            	<option value=""><spring:message code="zkmed.index.areachoose"/></option>
            	<option value="en_US"><spring:message code="zkmed.index.language.english"/></option><option  value="zh_CN"><spring:message code="zkmed.index.language.chinese"/></option>
            </select>
            <script type="text/javascript">
            	$(function(){
            		$("select.en_cn").change(function(){
            			window.location.href = ctx+"/index.html?locale="+$(this).children('option:selected').val();
            		});
            	});
            </script>
        </div>
    </div>
</div>
