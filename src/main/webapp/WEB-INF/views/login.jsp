<%@ include file="../template/header.jsp"%>
<p>${error}</p>
<div class="col-4">
	<c:if test="${not empty param.error}">
		<div class="alert alert-danger" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">Error:</span> Email Address or
			password is incorrect!!!
		</div>
	</c:if>
	<c:url value="/j_spring_security_check" var="loginURL" />
	<%-- <form:form method="POST" action="${loginURL}"
		commandName="user">
		<div class="form-group">
			<form:label path="username">Username</form:label>
			<form:input path="username" class="form-control"
				placeholder="Username" />
			<form:errors path="username"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:password path="password" class="form-control"
				placeholder="Password" />
			<form:errors path="password"></form:errors>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Login" class="btn btn-primary" />
	</form:form> --%>
	<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
		  <div class="form-group">
		  	<input type="text" class="form-control" name="username" placeholder="Username" />
		  </div>
		  <div class="form-group">
		  	<input type="password" class="form-control" name="password" placeholder="Password" />
		  </div>
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		  <input type="submit" value="Login" class="btn btn-primary" />
	</form>
</div>
<%@ include file="../template/footer.jsp"%>