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
<title>Standard Chartered - Dashboard</title>
<link rel="shortcut icon" href="./resources/images/favicon.png"
	type="image/x-icon" />
<link href="./resources/css/style.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Libre+Franklin:300,400,500,600,700&display=swap"
	rel="stylesheet">
<style>
header {
	text-align: right;
	background: #ffffff url(./resources/images/header-bg.png) repeat-x
		bottom center;
	padding-bottom: 10px;
}

.sidebar li:hover, .sidebar li.active {
	background: #b2d5e7 url(./resources/images/mobile-hover.png) no-repeat
		15px 17px;
	color: #005984;
	border-right: 3px solid #0094d5;
}

.sidebar li {
	background: #c9e2ee url(./resources/images/mobile.png) no-repeat 15px
		17px;
	line-height: 50px;
	color: #555555;
	text-align: center;
	font-size: 14px;
	cursor: pointer;
	border-right: 3px solid #c9e2ee;
}

.title {
	background: #0075ae url(./resources/images/divider.png) no-repeat center
		right;
	float: left;
	height: 46px;
	color: #fff;
	padding: 14px 44px 14px 20px;
	font-weight: 600;
}

.checked::before, .unchecked::before {
	content: url(./resources/images/checked.png);
	float: left;
	margin-right: 15px;
	margin-top: 1px;
}

.unchecked::before {
	content: url(./resources/images/unchecked.png);
}

.attempt-content {
	background: #ffffff;
	color: #706f6f;
	font-size: 12px;
	width: 85%;
	margin-left: 45px;
	padding: 20px 35px 10px 35px;
	display: none;
}

.attempt-content p {
	padding: 0;
	margin: 0 0 0 60px;
	display: table;
	line-height: 16px;
}
</style>
</head>
<body onclick="addClass()">
	<header>
		<img src="./resources/images/logo.jpg" alt="logo" />
	</header>
	<h1>Administrator</h1>
	<div class="titlebar">
		<div class="title">Player Information Report</div>
		<form method="get" action="/GameApp/BallOnTheBeach_PlayerInformationReport.xls">
			<button type="submit">

				<img src="./resources/images/excel.png" /> Export to Excel
			</button>
		</form>
	</div>
	<%-- 					<a onclick="javascript:mobile(${users.mobile})">${users.mobile}</a> --%>
	<div class="container">

		<div class="wrapper">
			<div class="sidebar">
				<ul>
					<c:forEach var="users" items="${listuser}">
						<li onclick="javascript:mobile(${users.mobile})"
							id="${users.mobile}">${users.mobile}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="content">
				<div class="attempt-wrapper">
					<c:forEach var="usergame" items="${listGame}" varStatus="status">

						<div class="attempt">
							Attempt${usergame.attemptcount}: Star Points:
							${usergame.starPoints} | Date: ${usergame.dateTime} | Score:
							${usergame.percentage}% | Feedback:
							<c:forEach begin="1" end="${usergame.feedback2}">

								<img src="./resources/images/Green Star.png" width="15"
									height="15">
							</c:forEach>
							<c:forEach begin="${usergame.feedback2}" end="4">
								<img src="./resources/images/white star.png" width="17"
									height="17">
							</c:forEach>
							<span onclick="changeSlider(${usergame.attemptcount})"
								class="viewdetails_${usergame.attemptcount}">View Details</span>
							<p style="display: none;" id="test">${usergame.mobile}</p>
						</div>

						<div class="attempt-content"
							historyId_${usergame.attemptcount}="historyId_${usergame.attemptcount}">

							<c:choose>
								<c:when test="${usergame.restult1== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo1}</span>
										<p>
											<span class="question">Question 01:</span> ${usergame.q1}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa1}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo1}</span>
										<p>
											<span class="question">Question 01:</span> ${usergame.q1}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa1}
										</p>
									</div>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${usergame.restult2== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo2}</span>
										<p>
											<span class="question">Question 02:</span> ${usergame.q2}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa2}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo2}</span>
										<p>
											<span class="question">Question 02:</span> ${usergame.q2}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa2}
										</p>
									</div>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${usergame.restult3== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo3}</span>
										<p>
											<span class="question">Question 03:</span> ${usergame.q3}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa3}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo3}</span>
										<p>
											<span class="question">Question 03:</span> ${usergame.q3}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa3}
										</p>
									</div>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${usergame.restult4== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo4}</span>
										<p>
											<span class="question">Question 04:</span> ${usergame.q4}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa4}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo4}</span>
										<p>
											<span class="question">Question 04:</span> ${usergame.q4}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa4}
										</p>
									</div>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${usergame.restult5== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo5}</span>
										<p>
											<span class="question">Question 05:</span> ${usergame.q5}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa5}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo5}</span>
										<p>
											<span class="question">Question 05:</span> ${usergame.q5}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa5}
										</p>
									</div>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${usergame.restult6== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo6}</span>
										<p>
											<span class="question">Question 06:</span> ${usergame.q6}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa6}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo6}</span>
										<p>
											<span class="question">Question 06:</span> ${usergame.q6}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa6}
										</p>
									</div>
								</c:otherwise>
							</c:choose>

							<c:choose>
								<c:when test="${usergame.restult7== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo7}</span>
										<p>
											<span class="question">Question 07:</span> ${usergame.q7}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa7}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo7}</span>
										<p>
											<span class="question">Question 07:</span> ${usergame.q7}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa7}
										</p>
									</div>
								</c:otherwise>
							</c:choose>



							<c:choose>
								<c:when test="${usergame.restult8== 'correct'}">
									<div class="mb10 checked">
										<span class="q-number">Q.${usergame.qNo8}</span>
										<p>
											<span class="question">Question 08:</span> ${usergame.q8}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa8}
										</p>
									</div>
								</c:when>

								<c:otherwise>
									<div class="mb10 unchecked">
										<span class="q-number">Q.${usergame.qNo8}</span>
										<p>
											<span class="question">Question 08:</span> ${usergame.q8}
										</p>
										<p>
											<span class="answare">Selected Option:</span> ${usergame.qa8}
										</p>
									</div>
								</c:otherwise>
							</c:choose>



						</div>
					</c:forEach>
					</table>
				</div>
			</div>
			<div class="cf"></div>
		</div>
	</div>



	<script type='text/javascript'
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
	<script type='text/javascript'
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.7.6/jquery.nicescroll.js'></script>

	<script>
		$(".sidebar").niceScroll();
	</script>
	<!-- <script>
function changeActive(){
// 	var mob = $(param.mobile);
	console.log("234243"));
	}
</script> -->
	<script>

	function changeSlider(val){
// 		alert(val)
// 		var view = "viewdetails_"+val;
// 		console.log(view)
// 		$(".attempt-content").slideDown("slow");
		$(".attempt-content").slideUp("slow");
				var hId="historyId_"+val;
				$(".attempt-content["+hId+"]").slideToggle("slow");
//    $('.attempt-content').slideUp();
//  if ($(this).next().is(':visible')) { 
//             //Close it if open
//             $(this).next().slideUp('slow');     
//         } else {
//             //Open it if not
//             $(this).next().slideDown('slow');       
//         }

		}
// $(document).ready(function(){
// 		  $(".viewdetails").click(function(){
// // 	alert("Hello");
// 			$(".attempt-content").slideToggle("slow");
// 			$(this);
// 		  });
// 		});


		function mobile(mobile){
// 			alert(mobile);
				window.location="nextMobile?mobile="+mobile;
			}
		 $( document ).ready(function() {
		        console.log( "document loaded" );
		    
		        var temp =     $("#test").text()
		        console.log(temp);
		        $("#"+temp).addClass("active");
		    });
	</script>
</body>
</html>
