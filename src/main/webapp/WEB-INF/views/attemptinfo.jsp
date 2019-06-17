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
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
	<div class="container">
		<form method="get" action="/GameApp/backadmin">
			<button type="submit" class="btn btn-primary">Back</button>
		</form>
		<h1>Administrator</h1>
		<div class="row">
			<!-- 			<div class="col-sm-1"></div> -->
			<div class="col-sm-12" style="background-color: blue;">
				<h3>Player Information report</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10" style="background-color: #338DFF; font-size: large;">
				<b>Phone Number:</b> ${game.mobile} | Attempt ${atmptcount} details
			</div>
		</div>

		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8" style="background-color: yellow;">
				<b>Question no1:</b> ${game.q1}<br> <b>Question no2:</b> ${game.q2}<br> <b>Question
					no3:</b> ${game.q3}<br> <b>Question no4:</b> ${game.q4}<br> <b>Question no5:</b>
				${game.q5}<br> <b>Question no6:</b> ${game.q6}<br> <b>Question no7:</b> ${game.q7}<br>
				<b>Question no8:</b> ${game.q8}
			</div>
		</div>
	</div>
</body>
</html>