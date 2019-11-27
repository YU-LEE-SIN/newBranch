<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet" href="/cssb/bootstrap.css">
<script  src="/js/jquery-3.3.1.min.js"></script>
<script  src="/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-4 column">
		<h1>后台管理</h1>
		</div>
		<div class="col-md-8 column">
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
					<a href="/admin/product/category">产品分类管理</a>
				</li>
				<li>
					<a href="/admin/product/index">产品管理</a>
				</li>
			</ul>
		</div>
		<div class="col-md-10 column" id="content">
			<table class ="table table-bordered table-hover">
				<thead>
					<tr>
						<th>编号</th>
						<th>名称</th>
						<th>价格</th>
						<th>图片</th>
						<th>操作</th>
					</tr>	
				</thead>
				<tbody >
				<c:forEach items="${pvo.products}" var="product">
					<tr>
						<td>${product.pk_pid}</td>
						<td>${product.pname}</td>
						<td>${product.original_price}</td>
						<td><img src="/${product.images}" style="width: 100px"></td>
						<td>${product.about}</td>
						<td>
							<a href="/admin/product/edit?pid=${product.pk_pid}" class="btn btn-info">编辑</a>
							<a href="/admin/product/delete?pid=${product.pk_pid}" class="btn btn-danger" onclick="return confirm('确定要删除吗？')">删除</a>
						</td>
					</tr>
				</c:forEach>

				</tbody>
				<tfoot>
				
					<ul class="pagination pagination-lg">
						<li>
							<a href="/admin/product/index?pageno=${pvo.pageInfo.first }">首页</a>
						</li>
						<li>
							<a href="/admin/product/index?pageno=${pvo.pageInfo.prev }">上一页</a>
						</li>
						<c:forEach begin="1" end="${pvo.pageInfo.last }" var="index">
							<li>
							<a href="/admin/product/index?pageno=${index }">${index }</a>
							</li>
						</c:forEach>
						<li>
							<a href="/admin/product/index?pageno=${pvo.pageInfo.next }">下一页</a>
						</li>
						<li>
							<a href="/admin/product/index?pageno=${pvo.pageInfo.last }">尾页</a>
						</li>
					</ul>
					
				</tfoot>
			</table>
			<a href="/admin/product/add"><button href="#" class="btn btn-info add">新增</button><a>
		</div>
	</div>
	
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="center-block" style="width:400px;max-width:100%;background-color:#ccc;">
				<h3>没有登陆，你想怎么样就怎么样！！</h3>
			</div>
		</div>
	</div>
</div>
</body>
</html>