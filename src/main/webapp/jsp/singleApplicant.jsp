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
<title><spring:message code='applicant.single'/></title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>
				<spring:message code='university'/> - 
					<sub><spring:message code='applicant.single'/></sub>
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


	<div class="container">

		<form:form action="${contextPath}/singleApplicant" method="POST">

			<br>

			<h2>${userSingle.assignedId}</h2>
			<h2>${userSingle.firstName}${userSingle.lastName}</h2>
			<h2>${userSingle.email}</h2>
			<h2>faculty ${userSingle.applicantss.facultys.name}</h2>

			<!-- nameOfLesson -->

			<c:if test="${not empty lessons}">

				<c:forEach items="${lessons}" var="currentLessonThisFaculty">

					<div class="w3-card-4" style="width: 500px; margin: 8%">

						<div class="w3-container w3-center">
							<h3>${currentLessonThisFaculty.name}</h3>
							<input name="ball" type="text"
								value="${currentLessonThisFaculty.ball}"> <br> <br>
						</div>
					</div>

				</c:forEach>
			</c:if>


			<div class="w3-card-4" style="width: 500px; margin: 8%">

				<div class="w3-container w3-center">
					<h3><spring:message code='applicant.gpa'/></h3>
					<input name="ballgpa" type="text"
						value="${userSingle.applicantss.ballgpa}"> <br> <br>
				</div>
			</div>

			<input name="assignedId" type="hidden"
				value="${userSingle.assignedId}">


			<button class="btn btn-lg btn-primary btn-block" type="submit">
				<spring:message code='submit'/></button>
			<br>
			<br>
			<a href="${contextPath}/application_of_entrants">Exit</a>
			<br>
			<br>

		</form:form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>