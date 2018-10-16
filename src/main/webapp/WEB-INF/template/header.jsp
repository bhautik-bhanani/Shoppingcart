<!-- 
Author: Bhautik Bhanani
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href='<c:url value="/resources/css/bootstrap.min.css"/>' />
<title>Shopping Cart</title>
<style type="text/css">
.header-title{
	padding: 5px 10px;
}
</style>
</head>
<body>
	<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<c:choose>
			<c:when test="${sessionScope.loginUser != null}">
				<h5 class="my-0 mr-md-auto font-weight-normal"><small>Welcome:</small> ${sessionScope.loginUser.getFull_name()}</h5>
				<nav class="my-2 my-md-0 mr-md-3"> 
					<a class="p-2 text-dark" href="./home">Home</a>
					<a class="p-2 text-dark" href="./cartlist">Cart</a>
					<a class="p-2 text-dark" href="./wishlist">Wishlist</a>
					<a class="p-2 text-dark" href="javascript:document.getElementById('logoutForm').submit();">Logout</a>
					<c:url value="/j_spring_security_logout" var="logoutURL" />
					<form action="${logoutURL}" method="POST" id="logoutForm">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</nav>
			</c:when>
			<c:otherwise>
				<nav class="my-2 my-md-0 mr-md-3"> 
					<a class="p-2 text-dark" href="./home">Home</a>
					<a class="p-2 text-dark" href="./login">Login</a>
				</nav>
			</c:otherwise>
		</c:choose>
	</div>