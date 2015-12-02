<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome to Shi-Men Farmers Customer Manager System</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- 選擇性佈景主題 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- 最新編譯和最佳化的 JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.11.4/themes/redmond/jquery-ui.css" />

<!-- For JQuery UI menu tag style, not to need now
<style>
.ui-tabs-vertical {
	width: 100%;
}

.ui-tabs-vertical .ui-tabs-nav {
	padding: .2em .1em .2em .2em;
	float: left;
	width: 100%;
}

.ui-tabs-vertical .ui-tabs-nav li {
	clear: left;
	width: 100%;
	border-bottom-width: 1px !important;
	border-right-width: 0 !important;
	margin: 0 -1px .2em 0;
}

.ui-tabs-vertical .ui-tabs-nav li a {
	display: block;
	width: 100%;
}

.ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active {
	padding-bottom: 0;
	padding-right: .1em;
	border-right-width: 1px;
}

.ui-tabs-vertical .ui-tabs-panel {
	padding: 1em;
	float: right;
	width: 100%;
}
</style>
 -->

<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/product.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<img alt="Banner" src="img/banner.png">
			</div>
			<div class="col-md-10 banner-extend"></div>
		</div>
		<div class="row">
			<h3>Logo 或選單</h3>
		</div>
		<div class="row" id="tab_menu">
			<div class="col-md-2">
				<ul class="nav nav-pills nav-stacked">
                    <li class="active"><a role="presentation">首頁</a></li>
                    <li><a data-url="CustomerManage.do">客戶管理</a></li>
                    <li><a data-url="OrderManage.do">訂單管理</a></li>
                    <li><a data-url="ProductManage.do">產品管理</a></li>
                    <li><a data-url="">報表資訊</a></li>
                </ul>
			</div>
			<div id="tab-content" class="col-md-10">
				<!-- <div id="tab-1">我是首頁</div>  -->
			</div>
		</div>
		<div class="row">
			<h2>標尾</h2>
		</div>
	</div>
</body>
</html>
