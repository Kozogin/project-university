<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html lang="en"> 
<head>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
 	<link rel="stylesheet" href="../css/login.css">

    <title>Log in with your account</title>
     
</head>

<body>

	<div class="login-page">
		<div class="form container">		

			<form class="login-form form-signin" method="POST" action="${contextPath}/login">
				<input class="assignedId" name="assignedId" type="text" placeholder="Assigned Id" />
				<input class="password" name="password" type="password" placeholder="password" />
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					
					
				<button class="login btn btn-lg btn-primary btn-block" type="submit">login</button>
				<p class="message">
					Not registered? <a href="${contextPath}/registration">Create an account</a>
				</p>
												
			</form>
		</div>

	</div>


</body>
</html>
