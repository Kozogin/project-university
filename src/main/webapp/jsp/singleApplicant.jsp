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
<title>Cabinet</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>

	<div>
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

				<h4>
					<a onclick="document.forms['logoutForm'].submit()">Logout</a>
				</h4>

			</c:if>

		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container w3-teal">
				<h1>
					University - <sub>detail <c:if
							test="${pageContext.request.userPrincipal.name != null}">
							<form id="logoutForm" method="POST"
								action="${contextPath}/logout">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form> ${pageContext.request.userPrincipal.name}


						</c:if>
					</sub>
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

				<div class="container">

					<form:form action="${contextPath}/singleApplicant" method="POST">

						<br>

							<h2>${userSingle.assignedId}</h2>
							<h2>${userSingle.firstName} ${userSingle.lastName}</h2>
							<h2>${userSingle.email}</h2>
							<h2>faculty ${userSingle.applicantss.facultys.name}</h2>
						

						<div class="w3-card-4" style="width: 500px; margin: 8%">

							<div class="w3-container w3-center">
								<h3>GPA</h3>
								<input name="ballgpa" type="text"
									placeholder="ball from 1 to 12"> <br> <br>
							</div>
						</div>


						<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

					</form:form>




				</div>
			</div>
			<!-- /container -->
		</div>




		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>