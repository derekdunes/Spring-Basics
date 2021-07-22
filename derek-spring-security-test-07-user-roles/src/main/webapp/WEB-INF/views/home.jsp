<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Home Page</title>
</head>
<body>
	<h2>Luv2code Company Home Page</h2>
	
	<p>Welcome to Luv2code Company Home Page</p>
	
	<p>
	
		User: <security:authentication property="principal.username"/>
		<br>
		
		Role(s) <security:authentication property="principal.authorities"/>
	
	 </p>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="logout" />
	
	</form:form>
</body>
</html>