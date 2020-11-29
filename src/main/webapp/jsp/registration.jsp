<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title><spring:message code='login.create'/></title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>
				<spring:message code='university'/> - 
					<sub><spring:message code='login.create'/></sub>
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

		<br>

		<div class="container form">

			<form:form method="POST" action="${contextPath}/registration"
				enctype="multipart/form-data" class="form-signin">
				<h2 class="form-signin-heading"><spring:message code='login.create'/></h2>


				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="text" name="firstName" class="form-control"
						placeholder="<spring:message code='registration.first_name'/>" autofocus="true"></input>

				</div>

				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="text" name="lastName" class="form-control"
						placeholder="<spring:message code='registration.last_name'/>" autofocus="true"></input>
				</div>

				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="text" name="email" class="form-control"
						placeholder="<spring:message code='registration.email'/>" autofocus="true"></input>
				</div>



				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="password" name="password" class="form-control"
						placeholder="<spring:message code='login.password'/>"></input>
				</div>



				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="password" name="passwordConfirm" class="form-control"
						placeholder="<spring:message code='registration.password_confirm'/>"></input>
				</div>



				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="file" class="form-control" name="imgFile"></input>
				</div>





				<button class="btn btn-lg btn-primary btn-block" type="submit">
					<spring:message code='submit'/></button>

				<p class="message">
					<spring:message code='registration.already'/>? <a href="${contextPath}/login"><spring:message code='login.login'/></a>
				</p>

			</form:form>

		</div>
		<!-- /container -->
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>