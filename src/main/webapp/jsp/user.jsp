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
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>
				University - <sub>cabinet</sub>
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


			<%-- action="${contextPath}/logout" --%>
			<form:form action="${contextPath}/userball" method="POST">

				<c:if test="${not empty lessonThisFaculty}">

					<%-- <c:set var="count" value="0" scope="page" /> --%>

					<c:forEach items="${lessonThisFaculty}"
						var="currentLessonThisFaculty">

						<%-- <c:set var="count" value="${count + 1}" scope="page" /> --%>

						<div class="w3-card-4" style="width: 500px; margin: 8%">

							<div class="w3-container w3-center">
								<h3>${currentLessonThisFaculty.nameOfLessons.name}</h3>
								<input name="ball" type="text" placeholder="ball from 1 to 12">
								<br> <br>
							</div>
						</div>

					</c:forEach>
				</c:if>

				<div class="w3-card-4" style="width: 500px; margin: 8%">

					<div class="w3-container w3-center">
						<h3>GPA</h3>
						<input name="ballgpa" type="text" placeholder="ball from 1 to 12">
						<br> <br>
					</div>
				</div>


				<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>


			</form:form>




		</div>
	</div>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>