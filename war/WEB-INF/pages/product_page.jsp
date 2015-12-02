<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 修改開始 -->
<div class="panel panel-default">
    <div class="panel-body">
        <form class="form-horizontal">
            <div class="col-md-2">
                <label>產品分類</label>
            </div>
            <div class="col-md-3">
                <select class="form-control">
                
                
                    <option></option>
                    
                    
                </select>
            </div>
            
            
            <div class="col-md-4 text-center">
                <input id="input-keyword" type="text" class="input-lg" placeholder="請輸入關鍵字" />
            </div>
            <div class="col-md-2">
                <button id="search-product-btn" type="button" class="btn btn-primary">
                     <span class="glyphicon glyphicon-search"></span> 查詢
                </button>
            </div>
        </form>
    </div>
</div>
<div class="panel panel-default">
	<div id="product-list-panel" class="panel-body">
		<jsp:include page="product_list.jsp" />
	</div>
</div>

<div id="product-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
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