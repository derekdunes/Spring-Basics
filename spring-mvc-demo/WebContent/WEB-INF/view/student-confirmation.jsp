<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

The Student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

Favorite Language: ${student.favoriteLanguage}

<br><br>

Favorite Subject: ${student.favoriteSubject}

<br><br>

Favorite Subject: ${student.favoriteSubject}

<br><br>

Operating System: 

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	
		<li> ${temp}</li>
	
	</c:forEach>
</ul>

<br><br>


</body>
</html>