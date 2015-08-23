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
	<title>Welcome to Jin Fa Tan Customer Manager System</title>
	
	<link type="text/css" href="css/JinFaTan.css" rel="stylesheet" />
	<link type="text/css" href="css/jquery-ui-1.7.2.custom.css" rel="stylesheet" />
	<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	
	</style>
</head>
<body>

	<h3>
	請先 <a href="${loginURI}">登入</a> Google 帳號
	</h3>

</body>
</html>
