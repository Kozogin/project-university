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

<title><spring:message code='header.application_entrants'/></title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
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
					<sub><spring:message code='header.application_entrants'/></sub>
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

		<form:form action="${contextPath}/application_of_entrants"
			modelAttribute="checked" method="POST">

			<table>
				<tr>
					<th style="width: 10%"></th>
					<th><spring:message code='login.assignedId'/></th>
					<th><spring:message code='registration.first_name'/></th>
					<th><spring:message code='registration.last_name'/></th>
					<th><spring:message code='applicant.selected_faculty'/></th>
					<th><spring:message code='applicant.gpa'/></th>
					<th><spring:message code='applicant.sum_points'/></th>
					<th><spring:message code='applicant.checked'/></th>
					<th><spring:message code='applicant.accepted'/></th>
					<th><spring:message code='applicant.rejected'/></th>
					<th><spring:message code='applicant.revision'/></th>
				</tr>

				<c:if test="${not empty users}">
					<c:forEach items="${users}" var="currentUsers">



						<tr>
							<td></td>
							<td>${currentUsers.assignedId}</td>
							<td>${currentUsers.firstName}</td>
							<td>${currentUsers.lastName}</td>
							<td>${currentUsers.applicantss.facultys.name}</td>
							<td>${currentUsers.applicantss.ballgpa}</td>
							<td>${currentUsers.applicantss.pointsForBall}</td>


							<c:if test="${currentUsers.applicantss.checked == false}">
								<td><a
									href="application_of_entrants_check?applicantId=${currentUsers.applicantss.applicantId}">
										☒ </a></td>
							</c:if>

							<c:if test="${currentUsers.applicantss.checked == true}">
								<td><a
									href="application_of_entrants_check?applicantId=${currentUsers.applicantss.applicantId}">
										✔ </a></td>
							</c:if>

							<c:if test="${empty currentUsers.applicantss.checked}">
								<td></td>
							</c:if>


							<c:if test="${currentUsers.applicantss.accepted == false}">
								<td><a
									href="application_of_entrants_accep?applicantId=${currentUsers.applicantss.applicantId}">
										☒ </a></td>
							</c:if>
							<c:if test="${currentUsers.applicantss.accepted == true}">
								<td><a
									href="application_of_entrants_accep?applicantId=${currentUsers.applicantss.applicantId}">
										✔ </a></td>
							</c:if>
							<c:if test="${empty currentUsers.applicantss.accepted}">
								<td></td>
							</c:if>

							<c:if test="${currentUsers.applicantss.rejected == false}">
								<td><a
									href="application_of_entrants_reject?applicantId=${currentUsers.applicantss.applicantId}">
										☒ </a></td>
							</c:if>
							<c:if test="${currentUsers.applicantss.rejected == true}">
								<td><a
									href="application_of_entrants_reject?applicantId=${currentUsers.applicantss.applicantId}">
										✔ </a></td>
							</c:if>
							<c:if test="${empty currentUsers.applicantss.rejected}">
								<td></td>
							</c:if>


							<td><a
								href="singleApplicant?assignedId=${currentUsers.assignedId}">
								<spring:message code='details'/></a></td>

						</tr>

					</c:forEach>
				</c:if>


			</table>
		</form:form>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>