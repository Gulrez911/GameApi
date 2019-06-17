<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">
		<form method="get" action="/GameApp/backadmin">
			<button type="submit" class="btn btn-primary">Back</button>
		</form>
		<form action="changePassword" method="post" cssClass="form-horizontal">

			<div class="form-group">
				<label for="username" class="col-md-3 control-label">Old Password:</label>
				<div class="col-md-9">
					<input type="password" name="pass1" required="required" />
					<p style="color: red">${error}</p>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-md-3 control-label">New Password:</label>
				<div class="col-md-9">
					<input type="password" name="pass2" required="required" />
					<p style="color: green">${msg}</p>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<input type="submit" value="Change Password">
				</div>
			</div>
		</form>
	</div>
</body>
</html>