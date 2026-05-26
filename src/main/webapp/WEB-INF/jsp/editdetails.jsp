<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userview/update"
		method="post">
		<input type="hidden" name="userId" value="${user.userId}"></input>

		UserName: <input type="text" name="userName" value="${user.userName}"></input>
		Age: <input type="text" name="age" value="${user.age}"></input>
		Salary: <input type="text" name="salary" value="${user.salary}"></input>
		Password: <input type="text" name="password" value="${user.password}"></input>
		<button type="submit" value="Submit">Update</button>
	</form>

</body>
</html>