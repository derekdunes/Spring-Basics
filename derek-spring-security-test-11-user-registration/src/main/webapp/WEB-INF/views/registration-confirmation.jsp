<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">

<head>
	
	<title>Login Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div>
		
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Registration Form -->
					<form:form
						action="${pageContext.request.contextPath}/register/processRegistrationForm"
						modelAttribute="crmUser" class="form-horizontal">
						<!-- Check for registration error -->
						<c:if test="${registrationError != null}">
							<div class="alert alert-danger col-xs-offset-1 col-xs-10">
								${registrationError}</div>
						</c:if>
						
						<!-- User name -->
						<form:input path="userName" placeholder="username"
							class="form-control" />
						<!-- Password -->
						<form:password path="password" placeholder="password"
							class="form-control" />
						<!-- First Name -->

						<form:input path=”firstName” placeholder-“first
							name” class=”form-control” />
						<button type="submit" class="btn btn-primary">Register</button>
					</form:form>

				</div>

			</div>

		</div>
		
		<div>

		<a href="${pageContext.request.contextPath}/showLoginForm" class="btn btn-primary" role="button" aria-pressed="true">
		Login User
		</a>
		
	</div>

</body>
</html>