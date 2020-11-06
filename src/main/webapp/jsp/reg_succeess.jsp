<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>User success registration</title>



<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

</head>

<body>

	<br>
	<br>
	<div>
		<form>
			<div>

				<div class="w3-container w3-center">
				<br>
				<br>
					<h2>registration successfully</h2>
					<br>					
					<h3>${lastUser.firstName}</h3>
					<h3>${lastUser.lastName}</h3>
					<h3>${lastUser.email}</h3>
					
					<p>you are assigned an id</p>
					<h3>${lastUser.assignedId}</h3>
					<br>
					<div>
						<a href="login">Ok</a>
					</div>
				</div>
			</div>
		</form>

	</div>


	<input name="_csrf" type="hidden" value="${_csrf.token}" />


</body>
</html>












<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<meta charset="ISO-8859-1">
<title>registration successfully</title>
</head>
<body>
		<br><br>
		<h2>registration successfully</h2>
		
	<div>
	<form>
		<div> 
			<a href="login">Ok</a>
		</div>	
	</form>		
	</div>

	
		<input name="_csrf" type="hidden" value="${_csrf.token}" />
</body>
</html> --%>