$(function() {
	
	$("#tab_menu").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	$("#tab_menu li").removeClass("ui-corner-top").addClass("ui-corner-left");
	
	//$(".ui-tabs-panel").addClass("col-md-9");
	
	// click customer modify botton
	$("#tab-content").on("click", ".customer-detail-btn", function(event) {
		var customerId = $(this).attr("data-customer-id");
		$("#customer-modal").load("CustomerDeatil.do", 
				{ customer_id: customerId});
	});
});