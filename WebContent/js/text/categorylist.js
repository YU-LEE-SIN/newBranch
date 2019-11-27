$(function(){
	$(".collapsible-header").click(function(){
		  var parmams={id:$(this).attr("id")};
		$.getJSON("category",parmams,function(data){
			$.each(data,function(index,category){
				var $li=$("<li><a href=/product?pk_cid="+(category.pk_cid)+"><span></span></a></li>");
				$li.find("a:first").text(category.cname);
				console.log(category.cname);
				//$li.appendTo("#dropdown1");
				$li.appendTo(".collapsible-body");
			});
		});//getjson end
		$(".collapsible-body").empty();
	  })//click end
})