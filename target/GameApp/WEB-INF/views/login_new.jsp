<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Standard Chartered - Login</title>
<link rel="shortcut icon" href="./resources/images/favicon.png"
	type="image/x-icon" />
<script src="./resources/js/sweetalert.min.js" type="text/javascript"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href="./resources/css/style.css" rel="stylesheet">
<style>
.loginBG {
	background: #fff3d9 url(./resources/images/login-bg.png) no-repeat
		center 84px;
	background-size: cover;
}

header {
	text-align: right;
	background: #ffffff url(./resources/images/header-bg.png) repeat-x
		bottom center;
	padding-bottom: 10px;
}
</style>
</head>
<body class="loginBG">
	<header>
		<img src="./resources/images/logo.jpg" alt="logo" />
	</header>
	<div class="container">
		<div class="loginWrapper">
			<h2>WELCOME</h2>
			<form:form action="userLogin" method="post"
				modelAttribute="userLogin">
				<form:input path="username" placeholder="Username" />
				<form:input path="password" type="password" placeholder="Password" />
				<button>Login</button>
			</form:form>
			<a onclick="sendMail()" href="#">Forgot Password</a>
		</div>
	</div>
	<script type="text/javascript">
		sendMail = function() {
			$.ajax({
				url : "sendMail",
				cache : false,
				success : function(response) {
					swal(response.data, {
					      icon: "success",
					    });
				}
			});
		}
	</script>
</body>
</html>
