$(function() {
	var selectCustomerId;
	
	// mark for stop use jquery ui menu
	// $("#tab_menu").tabs().addClass("ui-tabs-vertical ui-helper-clearfix");
	// $("#tab_menu li").removeClass("ui-corner-top").addClass("ui-corner-left");
	
	// click menu
	$("#tab_menu li").click(function(event) {
		$("#tab_menu li").removeClass("active");
		$(this).addClass("active");
		var ajaxUrl = $(this).children().attr("data-url");
		
		$("#tab-content").load(ajaxUrl);
	});
	
	//$(".ui-tabs-panel").addClass("col-md-9");
	
//	$("#customer-list-panel").load(
//		"QueryCustomer.do", 
//		{ keyword: $("#input-keyword").val() },
//		function(data) {
//			alert(data);
//		}
//	);
	
	// click search button
	$("#tab-content").on("click", "#search-customer-btn", function(event) {
		$("#customer-list-panel").load(
			"QueryCustomer.do", 
			{ keyword: $("#input-keyword").val() },
			function(data) {
			
			}
		);
	});
	
	// select customer row data
	$("#tab-content").on("click", "#customer-table > tbody tr", function(event) {
		selectCustomerId = $(this).attr("data-customer-id");
		$("#customer-table > tbody tr").removeClass("info");
		$(this).addClass("info");
	});
	
	// click customer add button
	$("#tab-content").on("click", "#add-customer-btn", function(event) {
		$("#customer-modal").load(
			"CustomerDetail.do", 
			function(data) {
				$("#customer-modal").modal();
			}
		);
	});
	
	// click customer modify button
	$("#tab-content").on("click", "#modify-customer-btn", function(event) {
		$("#customer-modal").load(
			"CustomerDeatil.do",
			{ customer_id: selectCustomerId },
			function(data) {
				$("#customer-modal").modal();
			}
		);
	});
	
	// click customer delete button
	$("#tab-content").on("click", "#delete-customer-btn", function(event) {
		if (selectCustomerId == "") {
			
		} else {
			$("#modal-dialog .modal-header > h4").html("注意！");
			$("#modal-dialog .modal-body > p").html("是否刪除此客戶？");
			$("#modal-dialog").modal();
		}
	});
	
	// click customer delete confirm button
	$("#tab-content").on("click", "#confirm-btn", function(event) {
		$.post(
			"CustomerDelete.do",
			{ customer_id: selectCustomerId },
			function(data) {
				// show data deleted success, need to implement
				
				
				$("#customer-list-panel").load(
					"QueryCustomer.do", 
					function(data) {
					
					}
				);
			}
		);
		$("#modal-dialog").modal("hide");
	});
	
	// click customer save button
	$("#tab-content").on("click", "#customer-update-btn", function(event) {
		$.post(
			"CustomerSave.do", 
			$("#cstomer-form").serializeArray(),
			function(data) {
				$("#customer-modal").modal("hide");
				$("#customer-list-panel").load(
					"QueryCustomer.do", 
					function(data) {
					
					}
				);
			}
		);
	});
});