$(function(){
	$('#help').modal('');
	$('#textarea1').val('');
		$('#textarea1').trigger('autoresize');
	$(document).on('scroll',function(){
		if ($(document).scrollTop() >= 70) {
			$("#nav2").addClass('active')
			$(".content").css('padding-top','120px')
		} else{
			$("#nav2").removeClass('active')
			$(".content").css('padding-top','0px')
		}
	})
	$(document).ready(function(){
	    $('.content3 ul.tabs').tabs('select_tab', 'tab_id');
	});
	//card   height
	var _cardH1 = $(".content4 ul li:first-child").find('.card').height()
	$(".content4 ul li:last-child").find('.card').css('height',_cardH1);
	//footer
	//footer input
	$("footer .footer-top input").on('click',function(){
		$(this).parent().find('a').addClass('active')
	})
	//footer collapsible
	$('.collapsible').collapsible();
	if ($(window).width()<800) {
		$("footer .footer-b ul").addClass('collapsible');
		$("footer .footer-b ul p").addClass('collapsible-header');
		$("footer .footer-b ul div").addClass('collapsible-body');
	} else{
		$("footer .footer-b ul").removeClass('collapsible');
		$("footer .footer-b ul p").removeClass('collapsible-header');
		$("footer .footer-b ul div").removeClass('collapsible-body');
	}
	$("footer .footer-b ul li .collapsible-header").on('click',function(){
		$("footer .footer-b ul li .collapsible-header").find('span').removeClass('active')
		$(this).find('span').toggleClass('active')
	})
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