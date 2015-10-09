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
					<button class="btn btn-primary input-group-addon">查詢</button>
				</div>
			</div>
		</form>
	</div>
</div>

<div class="panel panel-default">
	<div class="panel-body">
		<div class="text-right">
			<button class="btn btn-primary">新增</button>
			<button class="btn btn-info">修改</button>
			<button class="btn btn-danger">刪除</button>
		</div>
		<table class="table table-striped">
			<tr>
				<th class="col-md-2">姓名</th>
				<th class="col-md-4">地址</th>
				<th class="col-md-2">電話</th>
				<th class="col-md-2">手機</th>
				<th class="col-md-2">公司</th>
			</tr>
			<c:forEach var="customer" items="${customerList}">
			<tr>
				<td>${customer.name}</td>
				<td>${customer.address}</td>
				<td>${customer.telPhone}</td>
				<td>${customer.cellPhone}</td>
				<td>${customer.company}</td>
			</tr>
			</c:forEach>
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

<div id="customer-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>