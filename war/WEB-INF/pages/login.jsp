<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome to  ShiMen Farmers Customer Manager System</title>
	
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
</head>
<body>
	<div class="container-fluid">
		<div class="row text-center">
			<h3>
			請先登入 Google 帳號<br/>
			</h3> 
			<a 
				href="https://accounts.google.com/o/oauth2/auth?
				client_id=750099995851-osh54a6sv38evrhvha4bvsluvgodc8t2.apps.googleusercontent.com&
				response_type=code&
				scope=openid%20email&
				redirect_uri=https://shimen-farmers-crm.appspot.com/aouth2callback.do&
				state=random_code">
				<img src="img/btn_google+_signin_dark_normal_web.png" />
			</a>
		</div>
	</div>
</body>
</html>
