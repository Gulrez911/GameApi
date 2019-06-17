<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Data JPA</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Login</div>
				</div>
				<div class="panel-body">
					<form:form action="userLogin" method="post" modelAttribute="userLogin"
						cssClass="form-horizontal">

						<div class="form-group">
							<label for="username" class="col-md-3 control-label">Email:</label>
							<div class="col-md-9">
								<form:input path="username" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password:</label>
							<div class="col-md-9">
								<form:input path="password" type="password" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Login</form:button>
							</div>
						</div>
						<p style="color: red">${error}</p>
					</form:form>
				</div>
				<a href="reset">Forget Password</a>
			</div>
		</div>
	</div>
</body>
</html>