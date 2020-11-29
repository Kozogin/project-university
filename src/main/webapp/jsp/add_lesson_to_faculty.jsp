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

<title>Add lessons to faculty</title>

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
				University - <sub>grades for these 
			lessons are required</sub>
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

		<form:form modelAttribute="selectFaculty" method="POST">
			<h4 class="form-signin-heading">Choice faculty</h4>
			<form:select id="facultySelect" path="facultyId">

				<c:if test="${not empty faculties}">
					<c:forEach items="${faculties}" var="currentFaculties">

						<form:option value="${currentFaculties.facultyId}">${currentFaculties.name}</form:option>

					</c:forEach>
				</c:if>
			</form:select>


			<input type="submit" class="w3-button w3-block w3-dark-grey"
				value="+ choise this faculty">
		</form:form>

		<br>

		<c:if test="${not empty lessonThisFaculty}">
			<c:forEach items="${lessonThisFaculty}"
				var="currentLessonThisFaculty">

				<div class="w3-card-4" style="width: 500px; margin: 8%">

					<div class="w3-container w3-center">
						<h3>${currentLessonThisFaculty.nameOfLessons.name}</h3>
						<a
							href="add_lesson_to_faculty_del?facultyLessonsId= ${currentLessonThisFaculty.facultyLessonsId}">delete</a>
					</div>
				</div>

			</c:forEach>
		</c:if>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>