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

<title><spring:message code='header.create_lesson'/></title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.text {
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>
				<spring:message code='university'/> - 
					<sub><spring:message code='header.create_lesson'/></sub>
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
		<div class="container">
			<div class="form">

				<form:form method="POST" modelAttribute="createLessonForm"
					class="form-signin">
					<h4 class="form-signin-heading"><spring:message code='header.create_lesson'/></h4>

					<spring:bind path="name">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="name" class="form-control"
								placeholder="" 
								autofocus="true"></form:input>
							<form:errors path="name"></form:errors>
						</div>
					</spring:bind>

					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<form id="logoutForm" method="POST" action="${contextPath}/logout">
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								<spring:message code='submit'/></button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</c:if>

				</form:form>

			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>