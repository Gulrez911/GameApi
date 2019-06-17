<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Recovery</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">
		<form action="resetPassword" method="post" cssClass="form-horizontal">

			<div class="form-group">
				<label for="username" class="col-md-3 control-label">Email:</label>
				<div class="col-md-9">
					<input type="email" name="email" />
					<p style="color: red">${error}</p>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<input type="submit" value="Send Password">
				</div>
			</div>
		</form>
	</div>
</body>
</html>