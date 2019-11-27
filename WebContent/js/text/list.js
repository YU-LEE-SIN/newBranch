$(function(){
	//注册一个全局错误处理函数
	 $(document).ajaxError(function(){
	        alert("一个错误发生!");
	  });
	 function getAll(){
			$.getJSON("/admin/category/list",function(data){
				$.each(data,function(index,category){
					var $tr = $("<tr><td></td><td></td><td></td><td>"+
							"<a href='/admin/category/delete' class='delete btn btn-danger'>删除</a>"+
							"<a href='#' class='edit btn btn-info'>编辑</a></td></tr>");
					$tr.find("td:first").text(category.pk_cid);
					$tr.find("td:eq(1)").text(category.sid);
					$tr.find("td:eq(2)").text(category.cname);
					//用data这个函数来保存额外的数据到元素中
					$tr.find("td a:eq(0)").data("pk_cid",category.pk_cid);//cid就是你点击的那一列[td a:eq(01)]的第一个元素值
		            $tr.find("td a:eq(1)").data("sid",category.sid);
		            $tr.find("td a:eq(2)").data("cname",category.cname);
					$tr.appendTo("tbody");//老师的OK
				});
			});
		}
		//调用查询函数,/第一次加载页面的时候立即查询所有的信息.
		getAll();
		//***************删除****************************
		 $("tbody").on("click",".delete",function (e) {
		        e.preventDefault();
		        //记录下当前引发单击事件的元素 ,//删除元素的时候用
		        var $that = $(this);
		        var parmams={cid:$(this).data("pk_cid")};
		        console.log(parmams);
		        if(confirm("你确定要删除🦄"))
		        $.post("/admin/category/delete",parmams,function(){
		        	// 删除成功 直接用脚本删除当前行相当于刷新
		        	$that.closest("tr").remove();
		        });
		    });//删除链接的点击事件处理 end
		
			//***************修改****************************
		    //1.修改操作,打开模式框把值添加到窗口
		    $("tbody").on("click",".edit",function () {
		    	 $("#save").data("op", "update");
		    	//把cid的值从data中取出来，并赋值给模式窗口中的隐藏域中//把cname的值从data中取出来,并赋值给模式窗口
		    	 $("#pk_cid").val($(this).closest("tr").find("td:eq(0)").text());
		    	 $("#cid").val($(this).closest("tr").find("td:eq(1)").text());
		         $("#cname").val($(this).closest("tr").find("td:eq(2)").text());
		        // $("#cid").prop("disabled", "disabled");//禁用输入编号
		         $("#myModal").modal('show');
		         
		    });
		    //2.修改操作,打开模式框
		    $("#save").click(function(){
		    	var op=$("#save").data("op")
		    	if(op!="update"){//如果不等于添加就,返回
		            return;
		        }
		    	var objtes = {sid:$("#cid").val(),cname:$("#cname").val(),cid:$("#pk_cid").val()};
		         console.log(objtes);
		         $.post("/admin/category/update",objtes,function () {
		             //2.第2种刷新方式
		             // 修改成功 直接重新加载页面即可，相当于刷新。不要在servlet中进行跳转动作。
		             location.href="/admin/product/category";
		         }); 
		    });//修改 end
		    
			//***************添加****************************
		    //1.新增操作,打开模式框
		    $("#content").on("click",".add",function () {
		        $("#save").data("op", "insert");
		        $("#cid").val("");
		        $("#cid").prop("disabled", "");
		        $("#cname").val("");
		        $("#myModal").modal('show');//显示模态框
		    });
		    //2.新增操作,打开模态框后的点击保存(save)事件,
		    $("#save").click(function(){
		    	var op=$("#save").data("op");
		    	if(op!="insert"){//如果不等于添加就,返回
		            return;
		        }
		    	var obj = {sid:$("#cid").val(),cname:$("#cname").val()};
		        console.log(obj);
		        $.post("/admin/category/insert",obj,function () {
		            // 3.第三种刷新方式,直接清空表格数据,并重新加载数据
		            $("tbody").empty();
		            getAll();
		        });
		    	$("#myModal").modal('hide');//隐藏模态框
		    });//添加click end
});