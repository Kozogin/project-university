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

<title>All faculties</title>

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
	<div>
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/user" class="w3-bar-item w3-button">All Application</a> 
			<a href="/create_faculty" class="w3-bar-item w3-button">Create faculty</a>
			<a href="/faculties" class="w3-bar-item w3-button">Faculties</a>
			<a href="/create_lesson" class="w3-bar-item w3-button">Create lesson</a>
			<a href="/lessons" class="w3-bar-item w3-button">Lessons</a>
			<a href="/add_lesson_to_faculty" class="w3-bar-item w3-button">Add lessons to faculty</a>
			<h4 class="text"><a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
			
		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container w3-teal">
				<h1>University    - <sub>all faculties</sub></h1>
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
					
					<c:if test="${not empty faculties}">
						<c:forEach items="${faculties}" var="currentFaculties">

							<div class="w3-card-4" style="width: 500px; margin: 8%">
								
								<div class="w3-container w3-center">
									<h3>${currentFaculties.facultyId}</h3> 
									<p>${currentFaculties.name}</p>									
								</div>								
							</div>

						</c:forEach>
					</c:if>								
					
				</div>
			</div>
		</div>
		<!-- /container -->
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>