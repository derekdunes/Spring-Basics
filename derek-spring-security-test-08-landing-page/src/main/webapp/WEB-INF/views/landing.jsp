
<!DOCTYPE html>
<html>
<head>
<title>luv2code Landing Page</title>
</head>
<body>
	<h2>luv2code Landing Page</h2>
	<hr>
	<p>
		Welcome to the landing Page! This page is open to the public ... no login required 
	</p>
	<hr>
	<p>
		<a href="${pageContext.request.contextPath}/employees">Access Secure Site (requires Employee login)</a>
	</p>
	
	<p> 
		<a href="${pageContext.request.contextPath}/leaders">Access Leaders Secure Site (requires Manager login)</a>
	</p>
	
	<p> 
		<a href="${pageContext.request.contextPath}/systems">Access System Engineers Secure Site (requires Admin login)</a>
	</p>
	
</body>
</html>