
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<link rel="stylesheet" href="../css/login.css">

<title>Registration successfully</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.text {
	text-align: center;
}
</style>


<div>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			
			<security:authorize access="hasRole('ROLE_ADMIN')">			
				<a href="/user" class="w3-bar-item w3-button">All Application</a> 
				<a href="/create_faculty" class="w3-bar-item w3-button">Create faculty</a>
				<a href="/faculties" class="w3-bar-item w3-button">Faculties</a>
				<a href="/create_lesson" class="w3-bar-item w3-button">Create lesson</a>
				<a href="/lessons" class="w3-bar-item w3-button">Lessons and add lessons to faculty</a>
				<a href="/add_lesson_to_faculty" class="w3-bar-item w3-button">Grades for these 
				lessons are required</a>
				<a href="/application_of_entrants" class="w3-bar-item w3-button">Application of entrants</a>
				<a href="/selection_options" class="w3-bar-item w3-button">Selection options</a>
				<h4 class="text"><a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_USER')">	
				<h4 class="text"><a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
			</security:authorize>
			
			<security:authorize access=" not hasAnyRole('USER', 'ADMIN')">	
				<a href="/login" class="w3-bar-item w3-button">LogIn</a>
				<a href="/login" class="w3-bar-item w3-button">LogIn</a>
				<a href="/login" class="w3-bar-item w3-button">LogIn</a>
			</security:authorize>
			
			
			
			
		</div>	

</div>

