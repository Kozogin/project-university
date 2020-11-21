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

<title>All Application</title>

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
	<div>
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/user" class="w3-bar-item w3-button">All Application</a> <a
				href="/create_faculty" class="w3-bar-item w3-button">Create
				faculty</a> <a href="/faculties" class="w3-bar-item w3-button">Faculties</a>
			<a href="/create_lesson" class="w3-bar-item w3-button">Create
				lesson</a> <a href="/lessons" class="w3-bar-item w3-button">Lessons
				and add lessons to faculty</a> <a href="/add_lesson_to_faculty"
				class="w3-bar-item w3-button">Grades for these lessons are
				required</a> <a href="/application_of_entrants"
				class="w3-bar-item w3-button">Application of entrants</a>


			<h4 class="text">
				<a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h4>

		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container w3-teal">
				<h1>
					University - <sub>application of entrants</sub>
				</h1>
			</div>

			<div class="w3-container">

				<br>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<h3 class="text">${pageContext.request.userPrincipal.name}</h3>

				</c:if>


				<table>
					<tr>
						<th>Id</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Selected faculty</th>
						<th>GPA</th>
						<th>The sum of points</th>
						<th>Cheked</th>
						<th>Accepted</th>
						<th>Revision</th>
					</tr>

					<c:if test="${not empty users}">
						<c:forEach items="${users}" var="currentUsers">



							<tr>
								<td>${currentUsers.assignedId}</td>
								<td>${currentUsers.firstName}</td>
								<td>${currentUsers.lastName}</td>
								<td>${currentUsers.applicantss.facultys.name}</td>
								<td>${currentUsers.applicantss.ballgpa}</td>
								<td>${currentUsers.applicantss.pointsForBall}</td>
								

									<c:if test="${currentUsers.applicantss.checked == false}">								
										<td><form:checkbox path="checkeds" name="check"
											value="chec" /></td>									
									</c:if>
									<c:if test="${currentUsers.applicantss.checked == true}">								
										<td><form:checkbox path="checkeds" name="check"
											value="chec" checked="checked" /></td>									
									</c:if>
									<c:if test="${empty currentUsers.applicantss.checked}">
										<td></td>
									</c:if>
									
									
									<c:if test="${currentUsers.applicantss.accepted == false}">								
										<td><form:checkbox path="accepteds" name="accep"
											value="accept" /></td>									
									</c:if>
									<c:if test="${currentUsers.applicantss.accepted == true}">								
										<td><form:checkbox path="accepteds" name="accep"
											value="accept" checked="checked" /></td>									
									</c:if>
									<c:if test="${empty currentUsers.applicantss.accepted}">
										<td></td>
									</c:if>

								
								<td><input type="submit"></td>

							</tr>

						</c:forEach>
					</c:if>


				</table>


			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>