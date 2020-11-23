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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Create an account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
		<h3 class="w3-bar-item">Menu</h3>
		<a href="${contextPath}/login" class="w3-bar-item w3-button">Log
			in</a> <a href="${contextPath}/registration"
			class="w3-bar-item w3-button">Create an account</a>
	</div>

	<!-- Page Content -->


	<div style="margin-left: 10%">

		<div class="w3-container w3-teal">
			<h1>
				University <sub>Create an account</sub>
			</h1>
		</div>

		<div class="w3-container">

			<br>

			<div class="container form">

				<form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data"
					class="form-signin">
					<h2 class="form-signin-heading">Create your account</h2>

					
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<input type="text" name="firstName" class="form-control"
								placeholder="First name" autofocus="true"></input>
							
						</div>					
					
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<input type="text" name="lastName" class="form-control"
								placeholder="Last name" autofocus="true"></input>
						</div>
					
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<input type="text" name="email" class="form-control"
								placeholder="Email" autofocus="true"></input>							
						</div>
					

					
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<input type="password" name="password" class="form-control"
								placeholder="Password"></input>
						</div>
					

					
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<input type="password" name="passwordConfirm"
								class="form-control" placeholder="Confirm your password"></input>							
						</div>
					
					
					
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<input type="file" class="form-control" name="imgFile"></input>
						</div> 
					
					
					
					

					<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

					<p class="message">
						Already registered? <a href="${contextPath}/login">Sign In</a>
					</p>

				</form:form>

			</div>
			<!-- /container -->
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>