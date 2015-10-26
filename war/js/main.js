$(function() {
	var selectCustomerId;
	
	$("#tab_menu").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	$("#tab_menu li").removeClass("ui-corner-top").addClass("ui-corner-left");
	
	//$(".ui-tabs-panel").addClass("col-md-9");
	
	
	// click search button
	$("#tab-content > div").on("click", "#search-customer-btn", function(event) {
		
	});
	
	// select customer row data
	$("#tab-content > div").on("click", "#customer-table > tbody tr", function(event) {
		selectCustomerId = $(this).attr("data-customer-id");
		$("#customer-table > tbody tr").removeClass("info");
		$(this).addClass("info");
	});
	
	// click customer add button
	$("#tab-content > div").on("click", "#add-customer-btn", function(event) {
		$("#customer-modal").load(
			"CustomerDeatil.do", 
			function(data) {
				$("#customer-modal").modal();
			}
		);
	});
	
	// click customer modify button
	$("#tab-content > div").on("click", "#modify-customer-btn", function(event) {
		$("#customer-modal").load(
			"CustomerDeatil.do",
			{ customer_id: selectCustomerId },
			function(data) {
				$("#customer-modal").modal();
			}
		);
	});
	
	// click customer delete button
	$("#tab-content > div").on("click", "#delete-customer-btn", function(event) {
		if (selectCustomerId == "") {
			
		} else {
			$("#modal-dialog .modal-header > h4").html("注意！");
			$("#modal-dialog .modal-body > p").html("是否刪除此客戶？");
			$("#modal-dialog").modal();
		}
	});
	
	// click customer delete confirm button
	$("#tab-content > div").on("click", "#confirm-btn", function(event) {
		
		$("#modal-dialog").modal("hide");
	});
	
	// click customer save button
	$("#tab-content > div").on("click", "#customer-update-btn", function(event) {
		$.post(
			"CustomerSave.do", 
			$("#cstomer-form").serializeArray(),
			function(data) {
				$("#customer-modal").modal("hide");
				
			}
		);
	});
});