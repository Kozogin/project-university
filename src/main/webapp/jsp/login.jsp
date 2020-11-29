<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html lang="en">
<head>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript"
			src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {		
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {			
			var selectedOption = $('#locales').val();			
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>

<title><spring:message code='login.title'/></title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>
				<spring:message code='university'/> - <sub><spring:message code='login.title'/></sub>
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
		<div class="login-page"> 
			<div class="form container">

				<form class="login-form form-signin" method="POST"
					action="${contextPath}/login">
					<input class="assignedId" name="assignedId" type="text"
						placeholder="<spring:message code='login.assignedId' />" /> 
					<input class="password"
						name="password" type="password" 
						placeholder="<spring:message code='login.password' />" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


					<button class="login btn btn-lg btn-primary btn-block"
						type="submit"><spring:message code='login.login' /></button>
					<p class="message">
						<spring:message code='login.not_registered'/>? <a href="${contextPath}/registration">
						<spring:message code='login.create'/></a>
					</p>

					<div>
						<fieldset>
							<label><spring:message code="login.choose_language"/></label> 
							<select id="locales">
								<option value="en"><spring:message code='login.english' /></option>
								<option value="ua"><spring:message code='login.ukrainian' /></option>
							</select>
						</fieldset>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>
