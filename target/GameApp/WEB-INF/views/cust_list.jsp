<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFform'; return false;"
				class="btn btn-primary" /><br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Customer List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
						<c:forEach items="list" var="list">
							<c:url var="updateLink"></c:url>
							<tr>
								<td>${list.firstName}</td>
								<td>${list.lastName}</td>
								<td>${list.email}</td>
							</tr>
						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>