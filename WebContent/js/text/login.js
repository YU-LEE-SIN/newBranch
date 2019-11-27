$(function(){
	//注册一个全局错误处理函数
	 $(document).ajaxError(function(){
	        alert("一个错误发生!");
	  });
	// .on('click',function()
	 $('#input-modal-action').click(function(){
			if($('#password').val()!="" && $('#email').hasClass('valid')){	
				var objtes={email:$("#email").val(),password:$("#password").val()};
				$.post("/userlogin",objtes,function(data){
					if(data != "null"){
						confirm('登陆成功');
						//$("#modal1").hide();
						window.location.href="/index";
					}else{
						confirm('登陆失败请重新输入正确的邮箱格式以及正确的密码')
					}
				}); //post end
			}else{
				confirm('请重新输入正确的邮箱格式以及正确的密码。');	
			} //if end
	}); //click end
	 
	 $('#modal1').modal('');
		;(function () {
			"use strict";
			$.fn.toTop = function (t) {
				var i = this,
					e = $(window),
					s = $('html, body'),
					n = $.extend({
						autohide: !0,   // 是否自动隐藏
						offset  : 420,  // 距离顶部多少的时候显示 回到顶部按钮
						speed   : 500,  // 动画速度
						position: !0,   // 是否定位
						right   : 15,   // 右边距离
						bottom  : 30    // 下边距离
					}, t);
				
				// 设置手型点击
				i.css({
					'cursor': 'pointer'
				});
				// 自动隐藏
				n.autohide && i.css({ 'display': 'none' });
				// 定位位置
				n.position && i.css({
					'position': 'fixed',
					'right'   : n.right,
					'bottom'  : n.bottom
				});
				// 回到顶部
				i.click(function () {
					s.stop().animate({
						scrollTop: 0
					}, n.speed);
				});
				// 回到顶部按钮是否隐藏显示
				e.scroll(function () {
					var o = e.scrollTop();
					// 若自动隐藏为 true, window 的滚动条高度 > 420 则显示, 否则隐藏
					n.autohide && ( o > n.offset ? i.fadeIn(n.speed) : i.fadeOut(n.speed) );
				});
           return this;
			}
		})(jQuery);
		$(function () {
			$('#go_top').toTop();
		})
});