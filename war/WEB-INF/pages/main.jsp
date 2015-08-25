<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html>
<html lang="zh-Hant">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome to Jin Fa Tan Customer Manager System</title>
	
	<!-- 最新編譯和最佳化的 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

	<!-- 選擇性佈景主題 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

	<!-- 最新編譯和最佳化的 JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	
	<script type="text/javascript">
		$(function() {
			//$("#menu a:last").tab("show");
			
			$("#menu a").click(function (e) {
				e.preventDefault();
				$(this).tab("show");
			});
		});
		
	</script>
</head>
<body>
<div class="container">
	<div class="row">
		<h2>標頭</h2>
	</div>
	<div class="row">
	</div>
	<div class="row">
		<div class="col-md-3">
			<h3>我是選單</h3>
			<ul id="menu" class="nav nav-pills nav-stacked">
		  		<li role="presentation" class="active"><a href="#home" data-toggle="pill">Home</a></li>
		  		<li role="presentation"><a href="#Profile" data-toggle="pill">Profile</a></li>
		  		<li role="presentation"><a href="#Messages" data-toggle="pill">Messages</a></li>
			</ul>
		</div>
		<div class="col-md-9">
			<h3>
				請先 <a href="${loginURI}">登入</a> Google 帳號
			</h3>
		</div>
	</div>
	<div class="row">
		<h2>標尾</h2>
	</div>
</div>
</body>
</html>
