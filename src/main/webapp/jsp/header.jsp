
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<link rel="stylesheet" href="../css/login.css">
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
			<h3 class="w3-bar-item"><spring:message code='menu'/></h3>
			
			<security:authorize access="hasRole('ROLE_ADMIN')">			
				<a href="/user" class="w3-bar-item w3-button"><spring:message code='header.all_aplication'/></a> 
				<a href="/create_faculty" class="w3-bar-item w3-button"><spring:message code='header.create_faculty'/></a>
				<a href="/faculties" class="w3-bar-item w3-button"><spring:message code='header.faculties'/></a>
				<a href="/create_lesson" class="w3-bar-item w3-button"><spring:message code='header.create_lesson'/></a>
				<a href="/lessons" class="w3-bar-item w3-button"><spring:message code='header.lessons_add_to_faculty'/></a>
				<a href="/add_lesson_to_faculty" class="w3-bar-item w3-button"><spring:message code='header.grades_this_lesson'/></a>
				<a href="/application_of_entrants" class="w3-bar-item w3-button"><spring:message code='header.application_entrants'/></a>
				<a href="/selection_options" class="w3-bar-item w3-button"><spring:message code='header.selected_options'/></a>
				<h4 class="text"><a onclick="document.forms['logoutForm'].submit()"><spring:message code='logout'/></a></h4>
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_USER')">	
				<h4 class="text"><a onclick="document.forms['logoutForm'].submit()"><spring:message code='logout'/></a></h4>
			</security:authorize>
			
			<security:authorize access=" not hasAnyRole('USER', 'ADMIN')">	
				<a href="${contextPath}/login" class="w3-bar-item w3-button"><spring:message code='login.login'/></a> 
				<a href="${contextPath}/registration" class="w3-bar-item w3-button"><spring:message code='login.create'/></a> 	
			</security:authorize>
			
			
			
			
			
		</div>	

</div>

