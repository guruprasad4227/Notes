<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<c:if test="${empty sessionScope.user}">
		<c:redirect url="login.jsp">
		</c:redirect>
	</c:if>

	<c:if test="${not empty sessionScope.user}">
		<h3>welcome ${sessionScope.user.userName}</h3>
		<h3>your age is ${sessionScope.user.age}</h3>

	</c:if>

	<a href="../logout/logoutSession">logout</a>
</body>
</html>