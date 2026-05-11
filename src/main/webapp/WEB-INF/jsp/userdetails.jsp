<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>UserDetails</h1>
<body>
	
	<c:forEach items="userDetails" var="ud">

		<tr>
			<td>${ud.age}</td>
		</tr>
	</c:forEach>


</body>
</html>