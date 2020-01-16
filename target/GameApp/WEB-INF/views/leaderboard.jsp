<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet" />
<script src="./resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="./resources/js/jquery-3.2.1.slim.min.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
<!-- 					<th>Mobile</th> -->
					<th>StarPoints</th>
					<th>Rank</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="li" items="${list}">
				<tr>
<%-- 						<td>${li.mobile}</td> --%>
						<td>${li.starPoints}</td>
						<td>${li.rank}</td>
					</tr>
				</c:forEach>
			</tbody>


		</table>
	</div>
</body>
</html>