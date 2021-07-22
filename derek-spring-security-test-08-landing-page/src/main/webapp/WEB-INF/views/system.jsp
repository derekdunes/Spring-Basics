<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>luv2code Landing Page</title>
</head>
<body>
	<h2>luv2code Landing Page</h2>
	<hr>
	<p>
		Welcome to the landing Page for System Engineers! 
	</p>
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/">Goto Landing Page</a>
	</p>
	
		<p>
	
		User: <security:authentication property="principal.username"/>
		<br>
		
		Role(s) <security:authentication property="principal.authorities"/>
	
	 </p>
	 
	 <security:authorize access="hasRole('EMPLOYEE')">
		 <p>
			<a href="${pageContext.request.contextPath}/employees">Access Secure Site (requires Employee login)</a>
		</p>
	</security:authorize>	

	<security:authorize access="hasRole('MANAGER')">
		<p> 
			<a href="${pageContext.request.contextPath}/leaders">Access Leaders Secure Site (requires Manager login)</a>
		</p>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p> 
			<a href="${pageContext.request.contextPath}/systems">Access System Engineers Secure Site (requires Admin login)</a>
		</p>
	</security:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="logout" />
	
	</form:form>

</body>
</html>