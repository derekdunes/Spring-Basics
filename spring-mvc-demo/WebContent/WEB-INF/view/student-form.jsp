<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/app.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app.js"></script>

	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		Country:
		
		<form:select path="country">
		
			<form:options items="${student.countryOptions}" />
		
		</form:select>
		
		<br><br>
		
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		Php <form:radiobutton path="favoriteLanguage" value="Php"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br><br>
		
		Favorite Subject:
		
		<form:radiobuttons path="favoriteSubject" items="${student.favoriteSubjectOption}"/>
		
		<br><br>
		
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Macintosh <form:checkbox path="operatingSystems" value="Macintosh"/>
		
		<br><br>
		
		<input type="submit" value="Submit"/>
	
	</form:form>
	
</body>

</html>

