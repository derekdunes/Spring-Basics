<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
	<title>Custom Login Page</title>
</head>
<body>

<style>
	
	.warning {
		color: red;
	}
	
</style>

<h1>My Custom Login Page</h1>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		
		<c:if test="${param.error != null}">
			<i class="warning">Sorry! You entered invalid username/password.</i>
		</c:if>
		
		<p>
			User Name: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="text" name="password" />
		 </p>
		 
		 <input type="submit" value="login" />
				
	</form:form>
	
</body>
</html>