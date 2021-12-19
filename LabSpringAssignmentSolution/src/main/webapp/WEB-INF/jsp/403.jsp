<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Error</title>
</head>
<body>
	<div class="container">
		<br>
		<h1 style="color: red;">
			HTTP Status 403 - Access is denied <a href="/logout"
				class="btn btn-primary btn-sm mb-3 float-right"> Logout </a>
		</h1>
		<hr>
		<h2 style="color: red;">${msg}
			<a href="/students/list"
				class="btn btn-primary btn-sm mr-2 mb-3 float-right"> Back </a>
		</h2>
	</div>
</body>
</html>
