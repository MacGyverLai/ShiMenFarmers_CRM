<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<h4 class="modal-title">新增/修改 產品資料</h4>
		</div>
		<div class="modal-body">
			<form id="product-form" class="form-horizontal">
				<input id="product_id" name="id" type="text" class="hide" value="${product.id}" />
				<div class="form-group">
					<label class="col-md-3 control-lable">產品類別</label>
					<div class="col-md-9">
						<input name="category" type="text" class="form-control" placeholder="請輸入產品類別" value="${product.category}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">名稱</label>
					<div class="col-md-9">
						<input name="name" type="text" class="form-control" placeholder="請輸產品名稱" value="${product.name}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">價格</label>
					<div class="col-md-9">
						<input name="price" type="text" class="form-control" placeholder="請輸入產品單價" value="${product.price}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">備註</label>
					<div class="col-md-9">
						<input name="description" type="text" class="form-control" placeholder="請輸入產品備註" value="${product.description}" />
					</div>
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			<button type="button" id="product-update-btn" class="btn btn-primary" data-id="${customer.id}">儲存</button>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
