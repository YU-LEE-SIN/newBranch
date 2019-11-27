<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8" />
		<title>主页面</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		
				<script src="js/jquery.min.js"></script>
				<script src="js/materialize.js"></script>
				<script src="js/index.js"></script>
				<script src="js/text/indextop.js"></script>
				<script src="js/text/login.js"></script>
				<script src="js/text/categorylist.js"></script>	
				
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/materialize.css?v=<%= System.currentTimeMillis()%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/iconfont.css?v=<%= System.currentTimeMillis()%>">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/store_style.css?v=<%= System.currentTimeMillis()%>">
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
					<input type="search" placeholder="搜索..." class="hide-on-med-and-down">
					<a href="" class="iconfont icon-iconsousuo hide-on-large-only"></a>
				</li>
				<li><a href="/viewcart" class="iconfont icon-gouwuchexian"></a></a></li>
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
					<a class="collapsible-header" href="javascript:;" data-activates="dropdown1" id="${store.pk_sid}">
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
		<div class="content">
			<div class="row">
				<div class="content1">
					<div class="col l8 m8 s12">
						<a href="http://localhost:8080/buy?pk_pid=1"><img src="Image\全新 Surface Go.jpg"/></a>
					</div>
					<div class="col l4 m4 s12">
						<ul>
							<li><a href="http://localhost:8080/buy?pk_pid=6"><img src="Image\Xbox One X 1TB 主机.png"/></a></li>
							<li><a href="http://localhost:8080/buy?pk_pid=7"><img src="Image\Xbox One S 1TB 主机.jpg"/></a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="content2">
					<div class="right content2-2 col l9 m12 s12">
						<ul>
							<li class="col l4 m4 s6">
								<div class="card">
						            <div class="card-image">
						              <img src="img/store/7.jpg">
						            </div>
						            <div class="card-content">
						            	<p>11.11盛惠提前抢，家庭和学生版2016仅售¥629</p>
						            </div>
						        </div>
							</li>
							<li class="col l4 m4 s6">
								<div class="card">
						            <div class="card-image">
						              <img src="img/store/Spot-office-1-2.jpg">
						            </div>
						            <div class="card-content">
						            	<p>动感家庭套装，限时赠《真•三国无双 7：帝国》</p>
						            </div>
						        </div>
							</li>
							<li class="col l4 m4 s6">
								<div class="card">
						            <div class="card-image">
						              <img src="img/store/Spot-office-1-3.jpg">
						            </div>
						            <div class="card-content">
						            	<p>全场笔记本优惠¥200，优惠代码MODERNPC</p>
						            </div>
						        </div>
							</li>
							<li class="col l4 m4 s6">
								<div class="card">
						            <div class="card-image">
						              <img src="img/store/Spot-office-2-1.jpg">
						            </div>
						            <div class="card-content">
						            	<p>微软以旧换新，换购Surface享最高¥700额外优惠</p>
						            </div>
						        </div>
							</li>
							<li class="col l4 m4 s6">
								<div class="card">
						            <div class="card-image">
						              <img src="img/store/Education-379X199.jpg">
						            </div>
						            <div class="card-content">
						            	<p>教育优惠：多品类优惠中，购Surface享额外好礼</p>
						            </div>
						        </div>
							</li>
							<li class="col l4 m4 s6">
								<div class="card">
						            <div class="card-image">
						              <img src="img/store/smb-379X199.jpg">
						            </div>
						            <div class="card-content">
						            	<p>为企业采购Surface Pro 4，详询企业购买与服务热线400-805-6783</p>
						            </div>
						        </div>
							</li>
						</ul>
					</div>
					<div class="right content2-1 col l3 m12 s12">
						<h4>大家都在看</h4>
						<ul>
							<li class="col l12 m12 s12">
							    <div class="card horizontal">
								    <div class="card-image">
								        <img src="img/store/Office2016HSMac-130Wx130H-1.png">
								    </div>
								    <div class="card-stacked">
								        <div class="card-content">
									        <p>Office 家庭和学生版 2016 for Mac</p>
									        <div class="price">
									        	<span class="left"><a>&yen; 629</a></span>
									        	<span class="right"><a href="">购买</a></span>
									        </div>
								        </div>
								    </div>
							    </div>
							</li>
							<li class="col l12 m12 s12">
							    <div class="card horizontal">
								    <div class="card-image">
								        <img src="img/store/MIC1631-130Wx130H-1.png">
								    </div>
								    <div class="card-stacked">
								        <div class="card-content">
									        <p>Xbox Elite (精英版)无线控制器</p>
									        <div class="price">
									        	<span class="left"><a>&yen; 1,099</a></span>
									        	<span class="right"><a href="">购买</a></span>
									        </div>
								        </div>
								    </div>
							    </div>
							</li>
							<li class="col l12 m12 s12">
							    <div class="card horizontal">
								    <div class="card-image">
								        <img src="img/store/Windows-8-Sculpt-Ergonomic-Mouse-0436-00000-MIC0436-130x130.png">
								    </div>
								    <div class="card-stacked">
								        <div class="card-content">
									        <p>微软Sculpt 人体工学鼠标</p>
									        <div class="price">
									        	<span class="left"><a>&yen; 229</a></span>
									        	<span class="right"><a href="">购买</a></span>
									        </div>
								        </div>
								    </div>
							    </div>
							</li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="content3">
					<div class="col l3 hide-on-med-and-down" style="height: 198px;background-image: url(img/store/Store-Choice.png);background-size: cover;">
						<h4>店长推荐</h4>
					</div>
					<div class=" col l9 m12 s12">
						<ul class="tabs">
					        <li class="tab col s2"><a href="#test1">开发者专区</a></li>
					        <li class="tab col s2"><a href="#test2">Test 2</a></li>
					    </ul>
			        	<div id="test1"  class="col s12">
			        		<div class="tab-txt right">
			        			<h5>开发者软件</h5>
			        			<a class="btn" href="">查看详情</a>
			        		</div>
			        	</div>
			        	<div id="test2"  class="col s12">
				        	<div class="tab-txt right">
			        			<h5>test2</h5>
			        			<a class="btn" href="">查看详情</a>
			        		</div>
			        	</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="content4">
					<ul>
						<li class="col l3 m6 s6">
						    <div class="card">
							    <div class="card-image">
							        <a href=""><img src="img/store/MICJS0212-593Wx390H-1.png"></a>
							    </div>
							    <div class="card-stacked">
							        <div class="card-content">
								        <p>Sennheiser 森海塞尔 CX 3.00 入耳式耳机</p>
							        </div>
							    </div>
							    <div class="card-action">
					                <a href="#">&yen; 339</a>
					                <a href="" class="right">查看详情</a>
					            </div>
						    </div>
						</li>
						<li class="col l3 m6 s6">
						    <div class="card">
							    <div class="card-image">
							        <a href=""><img src="img/store/MICJS0239-593Wx390H-1.png"></a>
							    </div>
							    <div class="card-stacked">
							        <div class="card-content">
								        <p>Logitech 罗技 UE900s 入耳式耳机</p>
							        </div>
							    </div>
							    <div class="card-action">
					                <a href="#">&yen; 1,739</a>
					                <a href="" class="right">查看详情</a>
					            </div>
						    </div>
						</li>
						<li class="col l3 m6 s6">
						    <div class="card">
							    <div class="card-image">
							        <a href=""><img src="img/store/MICJS0419-593Wx390H-1.png"></a>
							    </div>
							    <div class="card-stacked">
							        <div class="card-content">
								        <p>Dell 戴尔 XPS 13-9360-R1605G 笔记本电脑</p>
							        </div>
							    </div>
							    <div class="card-action">
					                <a href="#">&yen; 7,239</a>
					                <a href="" class="right">查看详情</a>
					            </div>
						    </div>
						</li>
						<li class="new-online col l3 m6 s6">
						    <div class="card" style="background-image: url(img/store/New-Product.png);">
						    	<h4><a href="">新品上市</a></h4>
						    </div>
						</li>
						<div class="clearfix"></div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="content5">
					<h4>微软商城，四大承诺</h4>
					<ul>
						<li class="col l3 m6 s12">
							<div class="card">
							    <div class="card-image hide-on-med-and-down" >
							        <a href=""><img src="img/store/promise_1.jpg"/></a>
							    </div>
						        <div class="card-content">
							        <p><span class="material-icons">replay_30</span> 30天退换货</p>
						        </div>
						    </div>
						</li>
						<li class="col l3 m6 s12">
							<div class="card">
							    <div class="card-image hide-on-med-and-down">
							        <a href=""><img src="img/store/promise_2.jpg"/></a>
							    </div>
						        <div class="card-content">
							        <p><span class="material-icons">replay_30</span> 2年有限保修</p>
						        </div>
						    </div>
						</li>
						<li class="col l3 m6 s12">
							<div class="card">
							    <div class="card-image hide-on-med-and-down">
							        <a href=""><img src="img/store/promise_3.jpg"/></a>
							    </div>
						        <div class="card-content">
							        <p><span class="material-icons">schedule</span> 24x7在线服务</p>
						        </div>
						    </div>
						</li>
						<li class="col l3 m6 s12">
							<div class="card">
							    <div class="card-image hide-on-med-and-down">
							        <a href=""><img src="img/store/promise_4.jpg"/></a>
							    </div>
						        <div class="card-content">
							        <p><span class="material-icons">trending_up</span> 极速上手服务</p>
						        </div>
						    </div>
						</li>
						<div class="clearfix"></div>
					</ul>
					<div class="hide-on-med-and-down" style="text-align: center;">
						<p><span class="material-icons">call</span> 微软官方商城服务热线：4008822059&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="material-icons">call</span> 微软中国技术支持热线：4008203800 </p>  
						<p><span class="material-icons">call</span> 微软官方商城企业服务热线：4008056783&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="material-icons">help</span> 想了解更多，请点击 <a href="">这里</a></p>
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