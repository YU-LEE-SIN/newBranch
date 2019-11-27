<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<meat name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/cssb/bootstrap.css">  
<script src="/js/bootstrap.js"></script>

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
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-4 column">
		<h1>后台管理</h1>
		</div>
		<div class="col-md-8-column">
			<h3 class="pull-right username">当前用户：${username}</h3>
			<a class="pull-right username" href="#modal1">登录</a>
		</div>
	</div>
	
	<div class="row clearfix">
		<div class="col-md-2 column">
			<ul class="nav nav-pills nav-stacked">
				<li>
					<a href="/admin/category/index">分类管理</a>
				</li>
				<li>
					<a href="/admin/product/index">产品管理</a>
				</li>
			</ul>
		</div>
		<div class="col-md-10 column">
			<div class="jumbotron">
				<h1>
				用户操着界面
				</h1>
			</div>
		</div>
	</div>
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="center-block" style="width:400px;max-width:100%;background-color:#ccc;">
				<h3>没有登陆，你想怎么样就怎么样！！</h3>
			</div>
		</div>
	</div>
</div>
</body>
</html>