<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>Luv2code - Access Denied</title>
</head>

<body>
		<h2>Access Denied - You are not authorised to access this resource</h2>
		
		<hr>
		
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
		
		<a href="${pageContext.request.contextPath}/">Back to landing Page</a>
	 
	 <br><br>
</body>

</html>