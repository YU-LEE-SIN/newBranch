
<%@ page pageEncoding="UTF-8" language="java" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/cssb/bootstrap.css">
    <link rel="stylesheet" href="/cssb/common.css">
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/bootstrap.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <h1>产品管理</h1>
        </div>
        <div class="col-md-8 column">
			<h3 class="pull-right username">当前用户：${username}</h3>
			<a class="pull-right username" href="#modal1">登录</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="nav nav-pills nav-stacked">
                <li >
                    <a href="/admin/category/index">产品分类管理</a>
                </li>
                <li>
                    <a href="/admin/product/index">产品管理</a>
                </li>
            </ul>
        </div>
        <div class="col-md-10 column">
        <c:if test="${!empty msg }">
        		<div class="alert alert-danger">错误！${msg}</div>
        </c:if>
	
            <form class="form-horizontal" role="form" method="post" enctype="multipart/form-data" action="/admin/product/insert">

                <div class="form-group">
                    <label for="cid" class="col-sm-2 control-label">选择商品分类</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="cid" name="cid">
                            <c:forEach items="${category}" var="category" >
                            	<option  value="${category.pk_cid}">${category.cname}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>

                <div class="form-group">
                    <label for="pid" class="col-sm-2 control-label">编码</label>
                    <div class="col-sm-6">
                        <input type="number" disabled="disabled" class="form-control" id="pid" name="pid" value="${product.pk_pid}" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="pname" class="col-sm-2 control-label">名字</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="pname" name="pname" value="${product.pname}" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="unitprice" class="col-sm-2 control-label">单价</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="original_price" name="original_price" value="${product.original_price}" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="pdesc" class="col-sm-2 control-label">描述</label>
                    <div class="col-sm-6">
                        <input type="textarea"  multiple="multiple" name=about id="about" cols="30" rows="10" class="form-control" value="${product.about}"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="pimage" class="col-sm-2 control-label">图片</label>
                    <div class="col-sm-6">
                        <input type="file"   name="pimage" id="pimage"  class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="pimage" class="col-sm-2 control-label"></label>
                    <div class="col-sm-6">
                        <img id="image" class="imageSize">
                    </div>
                </div>
                
    			 <div class="form-group">
                    <label for="pdesc" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-6">
                        <input type="textarea"  multiple="multiple" name="remark" id="remark" cols="30" rows="10" class="form-control" value="${product.remark}"></textarea>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" class="btn btn-default">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <!-- 下面的代码在stackoverflow上看到的水平居中的方法 -->
            <div class="center-block " style="width:400px;max-width:100%;background-color:#ccc;">
                <h3 >没有登陆，你想怎么样就怎么样！！</h3>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
$("#pimage").change(function(){
	//Get a reference to the fileList(获取对文件列表的引用)
	var files = !!this.files ? this.files : [];

	// If no files were selected, or no FileReader support, return(如果没有选择任何文件，或者没有文件读取器支持，则返回)
	if (!files.length || !window.FileReader) return;

	// Only proceed if the selected file is an image(仅当所选文件是图像时才继续)
	if (/^image/.test( files[0].type)){
	    // Create a new instance of the FileReader(创建FileReader的新实例)
	    var reader = new FileReader();

	    // Read the local file as a DataURL(以dataurl形式读取本地文件)
	    reader.readAsDataURL(files[0]);

	    // 加载时，将图像数据设置为图片标签的内容的背景
	    reader.onloadend = function(){
	    	$("#image").attr("src", this.result);
	    }
	}
})
</script>
</body>
</html>