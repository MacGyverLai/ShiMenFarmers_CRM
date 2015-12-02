$(function() {
	var selectProductId
	
	// click product add button
	$("#tab-content").on("click", "#add-product-btn", function(event) {
		$("#product-modal").load(
			"ProductDetail.do", 
			function(data) {
				$("#product-modal").modal();
			}
		);
	});
	
	// select customer row data
	$("#tab-content").on("click", "#product-table > tbody tr", function(event) {
		selectProductId = $(this).attr("data-product-id");
		$("#product-table > tbody tr").removeClass("info");
		$(this).addClass("info");
	});
	
	// click customer modify button
	$("#tab-content").on("click", "#modify-product-btn", function(event) {
		$("#product-modal").load(
			"ProductDetail.do",
			{ product_id: selectProductId },
			function(data) {
				$("#product-modal").modal();
			}
		);
	});
	
	// click product save button
	$("#tab-content").on("click", "#product-update-btn", function(event) {
		$.post(
			"ProductSave.do", 
			$("#product-form").serializeArray(),
			function(data) {
				$("#product-modal").modal("hide");
				$("#product-list-panel").load(
					"QueryProduct.do", 
					function(data) {
					
					}
				);
			}
		);
	});
	
	// click search button
	$("#tab-content").on("click", "#search-product-btn", function(event) {
		$("#product-list-panel").load(
			"QueryProduct.do", 
			{ keyword: $("#input-keyword").val() },
			function(data) {
			
			}
		);
	});
	
	// click customer delete button
	$("#tab-content").on("click", "#delete-product-btn", function(event) {
		if (selectProductId == "") {
			
		} else {
			$("#modal-dialog .modal-header > h4").html("注意！");
			$("#modal-dialog .modal-body > p").html("是否刪除此產品？");
			$("#modal-dialog").modal();
		}
	});
	
	// click customer delete confirm button
	$("#tab-content").on("click", "#confirm-btn", function(event) {
		$.post(
			"ProductDelete.do",
			{ product_id: selectProductId },
			function(data) {
				// show data deleted success, need to implement
				
				
				$("#product-list-panel").load(
					"QueryProduct.do", 
					function(data) {
					
					}
				);
			}
		);
		$("#modal-dialog").modal("hide");
	});
});

function queryProduct() {
	
} 