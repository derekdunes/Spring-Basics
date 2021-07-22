<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Create Customer</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		
</head>

<body>
	<div class="wrapper">
		<div class="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div class="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
				
					<tr>
						<td><Label>First Name</label>
						<td><form:input path="firstName" /></td>
					</tr>
					
					<tr>
						<td><Label>Last Name</label>
						<td><form:input path="LastName" /></td>
					</tr>
					
					<tr>
						<td><Label>Email</label>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><Label></label>
						<td><input type="submit" value="Save" class="save"/> </td>
					</tr>

				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p> 
			<a href="${oageContext.request.contextPath}/web-customer-tracker/customer/list">Back to Home</a>
		</p>
	</div>
</body>

</html>