<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>主页面</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
				<script src="js/jquery.min.js"></script>
				<script src="js/materialize.js"></script>
				<script src="js/index.js"></script>
				<script src="js/text/indextop.js"></script>
				<script src="js/text/login.js"></script>
				<script src="js/text/categorylist.js"></script>		
		<link rel="stylesheet" type="text/css" href="css/materialize.css"/>
		<link rel="stylesheet" type="text/css" href="css/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="css/store_style.css"/>

  <style type="text/css">
  .surfaceMain {
    text-align: center;
    margin: 0;
    padding: 0;
}
.mainContainer {
    width: 90%;
    max-width: 1180px;
    margin: 0 auto;
}
h2 {
    display: block;
    font-size: 1.5em;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.surfaceMain .mainContainer .desc {
    font-size: 16px;
    margin-top: 10px;
    color: #000;
}
h3 {
    display: block;
    font-size: 1.17em;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.surfaceMain .mainContainer .surfaceMainList > li:nth-child(even) {
    margin-left: 0.8%;
}
 .surfaceMain .mainContainer .surfaceMainList > li {
    font-size: 14px;
    margin-top: 30px;
    display: inline-block;
    width: 49.2%;
    text-align: left;
    }
 .surfaceMain .mainContainer .surfaceMainList > li .surfaceMainWrapper img {
    width: 100%;
    height: auto;  
}
p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}
  </style>	
 
	</head>
	<body>
		<div id="nav1" class="nav-wrapper">
			<!--logo-->
			<a href="index.html" class="left brand-logo"><img src="img/index/microsoft-gray.png"/></a>
			<ul class="left hide-on-med-and-down">
				<li><a href="#help">支持与帮助</a></li>
				<li id="help" class="modal">
					<!--modal-->
					<div class="modal-content">
						<h4>在此写下您宝贵的建议:</h4>
						<form class="row input-field">
							<input type="text" name="" id="textarea1" value=""/>
							<label for="textarea1" data-lengh="120">在此写下您宝贵的建议:</label>
						</form>
					</div>
					<div class="divider"></div>
					<div class="modal-footer">
						<a href="" class="modal-action modal-close waves-effect waves-green btn-flat">发送</a>
					</div>
				</li>
				<li>
					<a href="">在线咨询</a>
				</li>
			</ul>
			<ul class="right search-wrapper">
				<li class="input-field">
					<!-- 这里利用了el表达式的隐式对象param，
                    param用来读取查询参数，比如url上的查询字符串数据-->
                     <form action="/product" method="get">
                     <input type="hidden" name="pk_cid" id="pk_cid" value="${pvo.currentCid}"/>
					<input type="search" name="pname" placeholder="搜索..." class="hide-on-med-and-down" value="${param.pname}"/>
					<li><input type="submit" class="iconfont icon-iconsousuo" value="搜索"></li>
					</form>
				</li>
				<li><a href="/viewcart" class="iconfont icon-gouwuchexian"></a></li>
				<li><a class="" href="#modal1">登录</a></li>
				<li id="modal1" class="modal" style="z-index: 1003; display: none; opacity: 0; transform: scaleX(0.7); top: 0px;">
						<div class="modal-content">
							<h4>登录 </h4>
							<div class="row">
								<form class="input-field col s12">
									<input type="email" class="validate" name="email" id="email">
									<label for="email" data-error="请输入正确的邮箱格式" data-success="输入成功">邮箱账号:</label>
								</form>
							</div>
							<div class="row">
								<form class="input-field col s12">
									<input type="password" name="password" id="password" name="password" value="">
									<label for="password">输入密码:</label>
								</form>
							</div>
						</div>
						<div class="divider"></div>
						<div class="modal-footer">							
							<a href="zhuce.html" class="modal-action modal-close waves-effect waves-green btn-flat" style="padding-top: 0px">没有账号?注册一个</a>
							<input type="submit" id="input-modal-action" class=" modal-action waves-effect waves-green btn-flat" style="padding-top: 0px" value="登录"/>
						</div>
					</li>
					
			</ul>
			<div class="clearfix"></div>
		</div>
		<nav id="nav2" class=" nav-wrapper">
			<a href="/index" class="brand-logo left">商城</a>
			<!--mobile menu-->
			<a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
			<!--PC 端-->
			<ul id="nav-mobile" class="left collapsible hide-on-med-and-down">		
				<c:forEach var="store" items="${store}">
					<li >
					<a class="collapsible-header" href="#!" data-activates="dropdown1" id="${store.pk_sid}">
						<span class="left">${store.sname}</span> 
						<span class="right iconfont icon-jiantou-copy"></span>
						<div class="clearfix"></div>
					</a>
					
					<ul id="dropdown1" class="collapsible-body  section table-of-contents">
							<!-- 显示数据 -->
							<li></li>
						<div class="clearfix"></div>
					</ul> 
				</li>	
				</c:forEach>
				<li>
					<a class="collapsible-header" href="#!" >
						<span class="left">企业频道</span> 
						<div class="clearfix"></div>
					</a>
				</li>
				<li>
					<a class="collapsible-header" href="#!" >
						<span class="left">教育商城</span> 
						<div class="clearfix"></div>
					</a>
				</li>
				<li>
					<a class="collapsible-header" href="#!" >
						<span class="left">以旧换新</span> 
						<div class="clearfix"></div>
					</a>
				</li>
				<div class="clearfix"></div>
			</ul>
			<!--移动端-->
			<ul id="mobile-demo" class="side-nav  collapsible left" data-collapsible="accordion">
				<li>
					<a class="collapsible-header" href="#!" data-activates="dropdown1">
						<span class="left">硬件</span> 
						<span class="right iconfont icon-jiantou-copy"></span>
						<div class="clearfix"></div>
					</a>
					<ul id="dropdown1" class="collapsible-body  section table-of-contents">
						<li><a href="">Surface</a></li>
						<li><a href="">电脑与平板</a></li>
						<li><a href="">Xbox + 游戏</a></li>
						<li><a href="">Windows Phone</a></li>
						<li><a href="">配件</a></li>
						<div class="clearfix"></div>
					</ul>
				</li>
				<li>
					<a class="collapsible-header" href="#!" data-activates="dropdown1">
						<span class="left">软件</span> 
						<span class="right iconfont icon-jiantou-copy"></span>
						<div class="clearfix"></div>
					</a>
					<ul id="dropdown2" class="collapsible-body  section table-of-contents">
						<li><a class="" href="#dropdown2-1" >Office<span class="iconfont icon-202-copy-copy right"></span></a></li>
						<li><a class="" href="#dropdown2-2" >Windows<span class="iconfont icon-202-copy-copy right"></span></a></li>
						<li><a class="" href="#dropdown2-3" >Apps and Windows 10 游戏<span class="iconfont icon-202-copy-copy right"></span></a></li>
						<li><a class="" href="#dropdown2-4" >Skype <span class="iconfont icon-202-copy-copy right"></span></a></li>
						<li><a class="" href="#dropdown2-5" >Visual Studio<span class="iconfont icon-202-copy-copy right"></span></a></li>
						<li><a class="" href="#dropdown2-5" >其他软件与服务<span class="iconfont icon-202-copy-copy right"></span></a></li>
					</ul>
				</li>
				<li>
					<a class="collapsible-header" href="#!" >
						<span class="left">企业频道</span> 
						<div class="clearfix"></div>
					</a>
				</li>
				<li>
					<a class="collapsible-header" href="#!" >
						<span class="left">教育商城</span> 
						<div class="clearfix"></div>
					</a>
				</li>
				<li>
					<a class="collapsible-header" href="#!" >
						<span class="left">以旧换新</span> 
						<div class="clearfix"></div>
					</a>
				</li>
			</ul>
			<!--other-->
			<ul class="right hide-on-small-and-down">
				<li><a href="" class="">订单跟踪</a></li>
				<li><a class="">全场免运费</a></li>
			</ul>
		</nav>
		<!--nav end-->
		<!--content-->
		<div class="surfaceMain">
			<div class="mainContainer">
				<h2><span>更强大的笔记本电脑</span></h2>
				<div class="desc">要自由工作、要尽情创意，你需要一部强劲的新一代笔记本电脑，灵活多变，性能卓越，外形时尚。每一部 Surface，都是为您倾力打造的精心之作。</div>
			<ul class="surfaceMainList">
		<c:forEach var="product" items="${pvo.products}">
	<li>
			<div class="surfaceMainWrapper">
				<a href="/buy?pk_pid=${product.pk_pid}" class="img">
					<img src="${product.images}" >
				</a>
				<h3>${product.pname}</h3>
				<p>${product.about}</p>
				<p>${product.original_price}</p>
				<a href="/buy?pk_pid=${product.pk_pid}">立即购买 &gt;</a>
			</div>
		</li>
	</c:forEach>
		</ul>
				<div class="row">
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="/product?pname=${param.pname}&pk_cid=${pvo.currentCid}&pageno=${pvo.pageInfo.first}">首页</a>
                    </li>
                    <li>
                        <a href="/product?pname=${param.pname}&pk_cid=${pvo.currentCid}&pageno=${pvo.pageInfo.prev}">上一页</a>
                    </li>
                    <li>
                        <a href="/product?&pname=${param.pname}&pk_cid=${pvo.currentCid}&pageno=${pvo.pageInfo.next}">下一页</a>
                    </li>
                    <li>
                        <a href="/product?&pname=${param.pname}&pk_cid=${pvo.currentCid}&pageno=${pvo.pageInfo.last}">尾页</a>
                    </li>
                   <c:forEach begin="1"  end="${pvo.pageInfo.pageCount}" var="index">
					<a href="/product?pk_cid=${pvo.currentCid}&pageno=${index}">${index}</a>
					</c:forEach>
                </ul>
            </div>
			</ul>
		</div>
	</div>
</div>
			</div>
		</div>			
	</div>
		</div>
		<!--footer start-->
		<footer class="page-footer ">
			<div class="footer-top row">
				<p class="col l4 m12 s12"><span class="material-icons" style="color: #0059BC;">loyalty</span><a href="">促销信息抢先看，更可享专属优惠</a></p>
				<div class="input-field col l4 m11 s11">
					<a href="#!" class="prefix">订阅</a>
					<form>
						<input type="email" id="email" class="validate" placeholder="请输入您的邮箱"/>
						<label for="email" data-error="请输入正确的邮箱格式"  data-success="输入成功"></label>
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="divider"></div>
			<div class="row footer-b" data-collapsible="accordion">
				<!--pc-->
				<ul class=" " data-collapsible="accordion">
				    <li class="col l2 m12 s12 ">
					    <p class=" ">学习<span class="right hide-on-large-only iconfont icon-202-copy-copy"></span></p>
					    <div class=" ">
					      	<ul>
								<li><a href="#!">Windows </a></li>
								<li><a href="#!"> Office</a></li>
								<li><a href="#!">Skype</a></li>
								<li><a href="#!">Outlook</a></li>
								<li><a href="#!">OneDrive</a></li>
								<li><a href="#!">MSN</a></li>
							</ul>
					    </div>
				    </li>
				    <li class="col l2 m12 s12 ">
					    <p class=" ">设备<span class="right hide-on-large-only iconfont icon-202-copy-copy"></span></p>
					    <div class=" ">
					      	<ul>
								<li><a href="#!"> Microsoft Surface</a></li>
								<li><a href="#!">Xbox</a></li>
								<li><a href="#!">PC</a></li>
								<li><a href="#!">Microsoft Lumia </a></li>
							</ul>
					    </div>
				    </li>
				    <li class="col l2 m12 s12 ">
					    <p class=" ">微软官方商城<span class="right hide-on-large-only iconfont icon-202-copy-copy"></span></p>
					    <div class=" ">
					      	<ul>
								<li><a href="#!">我的订单</a></li>
								<li><a href="#!">与我们联系</a></li>
							</ul>
					    </div>
				    </li>
				    <li class="col l2 m12 s12 ">
					    <p class=" ">下载<span class="right hide-on-large-only iconfont icon-202-copy-copy"></span></p>
					    <div class=" ">
					      	<ul>
								<li><a href="#!">微软中国下载中心 </a></li>
								<li><a href="#!">所有 Windows 下载 </a></li>
								<li><a href="#!">Windows 10 Apps </a></li>
								<li><a href="#!">Office Apps </a></li>
								<li><a href="#!">Microsoft Lumia Apps</a></li>
								<li><a href="#!">Internet Explorer </a></li>
							</ul>
					    </div>
				    </li>
				    <li class="col l2 m12 s12 ">
					    <p class=" ">价值观<span class="right hide-on-large-only iconfont icon-202-copy-copy"></span></p>
					    <div class=" ">
					      	<ul>
								<li><a href="#!">Microsoft 隐私 </a></li>
								<li><a href="#!">教育</a></li>
							</ul>
					    </div>
				    </li>
				    <li class="col l2 m12 s12 ">
					    <p class=" ">公司<span class="right hide-on-large-only iconfont icon-202-copy-copy"></span></p>
					    <div class=" ">
					      	<ul>
								<li><a href="#!">招贤纳士 </a></li>
								<li><a href="#!"> 关于微软</a></li>
								<li><a href="#!">网站地图</a></li>
							</ul>
					    </div>
				    </li>
				</ul>
			</div>	
			<div class="footer-copyright">
				<div class="row">
					<span class="some1 col l3 m12 s12"><i class="iconfont icon-diqiu-copy"></i> 中文(中华人民共和国)</span>
					<div class="some2 col l9 m12 s12" href="#!">
						<a href="">使用条款</a>
						<a href="">关于我们的广告</a>
						<a href="">与我们联系</a>
						<a href="">隐私权声明</a>
						<a href="">商标</a>
						<a >京ICP备09042378号-6</a>
						<a >京公网安备 11010802010597</a>
						<a >© 2016 Microsoft</a>
					</ul>
				</div>
			</div>
		</footer>
		<!--footer end-->
		<a id="go_top" class="btn-floating">go</a>
	</body>
</html>