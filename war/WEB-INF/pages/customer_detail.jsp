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
			<h4 class="modal-title">新增/修改 客戶資料</h4>
		</div>
		<div class="modal-body">
			<form id="cstomer-form" class="form-horizontal">
				<input id="customer_id" name="id" type="text" class="hide" value="${customer.id}" />
				<div class="form-group">
					<label class="col-md-3 control-lable">客戶姓名</label>
					<div class="col-md-9">
						<input name="name" type="text" class="form-control" placeholder="請輸入客戶姓名" value="${customer.name}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">送貨地址</label>
					<div class="col-md-9">
						<input name="address" type="text" class="form-control" placeholder="請輸入客戶地址" value="${customer.address}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">室內電話</label>
					<div class="col-md-9">
						<input name="telPhone" type="text" class="form-control" placeholder="請輸入客戶室內電話" value="${customer.telPhone}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">行動電話</label>
					<div class="col-md-9">
						<input name="cellPhone" type="text" class="form-control" placeholder="請輸入客戶行動電話" value="${customer.cellPhone}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-lable">公司名稱</label>
					<div class="col-md-9">
						<input name="company" type="text" class="form-control" placeholder="請輸入客戶公司名稱" value="${customer.company}" />
					</div>
				</div>
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			<button type="button" id="customer-update-btn" class="btn btn-primary" data-id="${customer.id}">儲存</button>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
