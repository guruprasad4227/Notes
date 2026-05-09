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
	<c:if test="${not empty userDetails}">
	${userDetails}
		<c:forEach var="ud" items="userDetails">

		</c:forEach>

	</c:if>

</body>
</html>