<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" href="../css/login.css">

<title>Selection options</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.text {
	text-align: center;
}

.ancor_div {
	background: #237097;
	width: 100%;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	text-transform: uppercase;
	font-family: "Roboto", sans-serif;
	font-weight: bold;
}

.ancor_div a {
	text-decoration: none;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>
				University - <sub>selection options</sub>
			</h1>
		</div>
		<div class="w3-container">
			<br>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</c:if>
		</div>
	</div>

	<div>


		<div class="container form">

			<form:form method="POST" action="${contextPath}/selection_options"
				class="form-signin">
				<h2 class="form-signin-heading">Operations with entrants
					applications</h2>


				<div class="form-group ${status.error ? 'has-error' : ''}">
					<div class="ancor_div">
						<a href="${contextPath}/selection_options_check"
							class="form-control">automatic check</a>
					</div>
				</div>
				<br>

				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="text" name="totalBall" class="form-control"
						placeholder="the total score is not less" autofocus="true"></input>
				</div>

				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="text" name="number" class="form-control"
						placeholder="number of vacancies" autofocus="true"></input>
				</div>

				<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

				<p class="message">
					Already registered? <a href="${contextPath}/login">Sign In</a>
				</p>

			</form:form>

		</div>




	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>