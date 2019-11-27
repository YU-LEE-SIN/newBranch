<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" language="java" contentType="text/html; UTF-8" %>
<html>
<head>
    <title>商品信息</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/cssb/bootstrap.css">
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/bootstrap.js"></script>


</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <p>
                <a href="/index">继续购物</a>
            </p>
            <form method="post">
                <button value="删除"  id="batchDelete" class="btn btn-primary btn-danger">删除</button>
            </form>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th><input type="checkbox" id="batchDeleteChecked"></th>
                    <th>
                       	编号
                    </th>
                     <th>
                      	名称1
                    </th>
                     <th>
                      	名称2
                    </th>
                    <th>
                      	  单价
                    </th>
                    <th>
                     	   数量
                    </th>
                    <th>
                    	    小计
                    </th>
                    <th>
                       	 操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cart.items}" var="item">
                    <form method="post" action="/removefromcart"> 
                    <input type="hidden" name="pk_pid" id="pk_pid" value="${item.prt_specification.pk_id}"/>
                        <tr>
                            <td><input type="checkbox" ></td>
                            <td>${item.prt_specification.pk_id}</td>
                            <td>${item.prt_specification.prt_sp_one_name}</td>
                            <td>${item.prt_specification.prt_sp_two_name}</td>
                            <td>${item.prt_specification.prt_sp_price}</td>
                            <td><input type="number" name="qty" id="qty" value="${item.count}"/></td>
                            <td>${item.subTotal}</td>
                            <td><input type="submit" value="删除" class="btn btn-primary btn-danger"></td>
                        </tr>
                    </form>
                </c:forEach>
                <tr ><td colspan="6" style="align-content: right">总计: ${cart.total}</td> </tr>
                </tbody>


            </table>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("#batchDeleteChecked").click(function () {
            $("tbody :checkbox").prop("checked", $(this).prop("checked"));
        });
        //批量删除
        $("#batchDelete").click(function () {
            var url= "/removefromcart?";
            $("tbody :checkbox").each(function (index,ele) {
                if($(ele).prop("checked")){
                    url += ("pk_pid=" + $(ele).closest("tr").find("td:eq(1)").text());
                    url += "&";
                }
            });
            url = url.substring(0, url.length - 1);
            var $form = $(this).parent();
            $form.prop("action", url);
            alert($form.prop("action"));
            $form[0].submit();

        });

    })
</script>
</body>
</html>
