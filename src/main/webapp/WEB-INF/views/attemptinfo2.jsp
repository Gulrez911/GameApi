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
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script>
	function changeContext1() {
		var selectedValue = $("#context").val();
		var test = "1";
		// 		var x=${status.count};
				alert("Hi " + test + ": "+selectedValue)
		console.log(selectedValue);
		selectedValue = encodeURIComponent(selectedValue);
		console.log(selectedValue);
// 		alert(selectedValue)
		window.location = "changeAttempt?no=" + test + "&gameId="
				+ selectedValue;
	}
</script>
<script>
	function bye(id) {
		var id = id;
		alert("hi");
		changeContext1();
	}
</script>
</head>
<body>
	<!-- 	<img alt="tick" src="./resources/icon/tick.png"> -->
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
				<b>Phone Number:</b> ${game.mobile} | Attempt ${atmptcount} details ${user.noOfAttempts}
				<%-- 				<form:select id="context" path="u.noOfAttempts" onchange="changeContext1()"> --%>
				<%-- 										<c:forEach begin="1" end="${user.noOfAttempts}" var="role" varStatus="status"> --%>
				<%-- 											<option value="${status.count}" id="${status.count}">${status.count}</option> --%>
				<%-- 										</c:forEach> --%>
				<%-- 					<c:forEach begin="1" end="${user.noOfAttempts}" var="role" varStatus="status"> --%>
				<%-- 						<option value="${gameid.gameId}" >${status.count}</option> --%>
				<%-- 					</c:forEach> --%>
				<%-- 					<form:options items="${listid.UserGame}" /> --%>
				<%-- 				</form:select> --%>
				<form:select path="u.noOfAttempts" class="form-control" id="context" onchange="changeContext1()">
					<form:options items="${listobj22}" />
				</form:select>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-1">Question NO: ${game.qNo1}</div>
			<div class="col-sm-8" style="background-color: yellow;">
				<b>Question no1:</b> ${game.q1}
				<c:choose>
					<c:when test="${game.restult1== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option:</strong> ${game.qa1} <br> <br> <b>Question no2:</b>
				${game.q2}
				<c:choose>
					<c:when test="${game.restult2== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option:</strong> ${game.qa2} <br> <br> <b>Question no3:</b>
				${game.q3}
				<c:choose>
					<c:when test="${game.restult3== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option:</strong> ${game.qa3} <br> <br> <b>Question no4:</b>
				${game.q4}
				<c:choose>
					<c:when test="${game.restult4== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option:</strong> ${game.qa4} <br> <br> <b>Question no5:</b>
				${game.q5}
				<c:choose>
					<c:when test="${game.restult5== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option:</strong> ${game.qa5} <br> <br> <b>Question no6:</b>
				${game.q6}
				<c:choose>
					<c:when test="${game.restult6== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option:</strong> ${game.qa6} <br> <br> <b>Question no7:</b>
				${game.q7}
				<c:choose>
					<c:when test="${game.restult7== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option: </strong>${game.qa7} <br> <br> <b>Question no8:</b>
				${game.q8}
				<c:choose>
					<c:when test="${game.restult8== 'correct'}">
						<img alt="tick" src="./resources/icon/tick.png">
					</c:when>

					<c:otherwise>
						<img alt="tick" src="./resources/icon/cross.png">
					</c:otherwise>
				</c:choose>
				<br> <strong>Selected Option: ${game.qa8}</strong>
			</div>
		</div>
	</div>
</body>
</html>