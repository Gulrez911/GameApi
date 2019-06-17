<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.2.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
	<div class="container">
		<h1>Welcome Admin ${userlogin.username}</h1>

		<form method="get" action="/GameApp/changePass">
			<button type="submit" class="btn btn-primary">Change Password</button>
		</form>
		<!-- 		<button> -->
		<!-- 			<a href="/changepass">Change Password</a> -->
		<!-- 		</button> -->
		<div id="accordion">
			<c:forEach var="users" items="${listuser}">
				<div class="card">
					<div class="card-header" id="headingThree">
						<h5 class="mb-0">
							<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#${users.mobile}"
								aria-expanded="false" aria-controls="${users.mobile}">Phone Number: ${users.mobile}</button>
						</h5>
					</div>

					<div id="${users.mobile}" class="collapse" aria-labelledby="headingOne"
						data-parent="#accordion">
						<%
							int count = 0;
						%>
						<c:forEach var="usergame" items="${users.userGame}"  varStatus="status">
							<div class="card-body">
								<b>Attempt <c:out value="${status.count}"></c:out></b>: Star Points: ${usergame.starPoints} | Date: ${usergame.dateTime}|
								Performance: ${usergame.percentage} |<a href="attemptinfo?gameId=${usergame.gameId}&atmptcount=${status.count}">  View
									Details</a>
							</div>
						</c:forEach>
					</div>

				</div>
			</c:forEach>
		</div>

		<!-- 		<table border="1"> -->

		<!-- 			<th style="color: red">Name</th> -->
		<!-- 			<th style="color: red">Mobile</th> -->
		<!-- 			<th style="color: red">User Type</th> -->
		<!-- 			<th style="color: red">Action</th> -->

		<%-- 			<c:forEach var="users" items="${listuser}"> --%>
		<!-- 				<tr style="color: Dark blue"> -->

		<%-- 					<td>${users.mobile}</td> --%>
		<%-- 					<td>${users.email}</td> --%>
		<%-- 					<c:forEach var="usergame" items="${users.userGame}"> --%>
		<%-- 						<td>${usergame.starPoints}</td> --%>
		<%-- 						<td>${usergame.dateTime}</td> --%>
		<%-- 					</c:forEach> --%>
		<!-- 				</tr> -->
		<%-- 			</c:forEach> --%>

		<!-- 		</table> -->
	</div>
</body>
</html>