<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-default">
	<div class="panel-body">
		<form class="form-horizontal">
			<div class="form-group">
				<label>關鍵字</label>
				<div class="input-group">
					<input type="text" class="form-control" />
					<button id="search-customer-btn" class="btn btn-primary input-group-addon">查詢</button>
				</div>
			</div>
		</form>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-body">
		<div class="text-right">
			<button id="add-customer-btn" class="btn btn-primary" data-toggle="modal" >新增</button>
			<button id="modify-customer-btn" class="btn btn-info">修改</button>
			<button id="delete-customer-btn" class="btn btn-danger">刪除</button>
		</div>
		<table id="customer-table" class="table table-striped">
			<thead>
				<tr>
					<th class="col-md-2">姓名</th>
					<th class="col-md-4">地址</th>
					<th class="col-md-2">電話</th>
					<th class="col-md-2">手機</th>
					<th class="col-md-2">公司</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customerList}">
				<tr data-customer-id="${customer.id}">
					<td>${customer.name}</td>
					<td>${customer.address}</td>
					<td>${customer.telPhone}</td>
					<td>${customer.cellPhone}</td>
					<td>${customer.company}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<nav>
				<ul class="pagination">
					<li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
					<c:forEach var="pageCount" begin="${startPage}" end="${endPage}">
						<c:if test="${pageCount != currentPage}"><li><a class="changePage" href="#">${pageCount}</a></li></c:if>
						<c:if test="${pageCount == currentPage}"><li class="active"><a>${pageCount}</a></li></c:if>
					</c:forEach>
					<li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>

<div id="customer-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
</div>

<div id="modal-dialog" class="modal fade">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body">
				<p></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button id="confirm-btn" type="button" class="btn btn-primary">確定</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->