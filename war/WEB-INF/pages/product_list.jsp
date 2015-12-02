<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-right">
    <button id="add-product-btn" class="btn btn-primary">新增</button>
    <button id="modify-product-btn" class="btn btn-info">修改</button>
    <button id="delete-product-btn" class="btn btn-danger">刪除</button>
</div>
        
<table id="product-table" class="table table-striped">
	<thead>
		<tr>
            <th class="col-md-2">產品類別</th>
            <th class="col-md-3">名稱</th>
            <th class="col-md-2">價格</th>
            <th class="col-md-5">備註</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${productList}">
		<tr data-product-id="${product.id}">
			<td>${product.category}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.description}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<div class="row text-center">
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