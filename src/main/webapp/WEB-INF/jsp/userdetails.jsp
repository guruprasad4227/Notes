<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student Details</title>
</head>
<h1>UserDetails</h1>
<body>
	<table border="1">
		<tr>
			<th>SI No.</th>
			<th>User Name</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${userDetails}" var="ud" varStatus="i">
			<tr>
				<td>${i.index+1}</td>
				<td>${ud.userName}</td>
				<td>${ud.age}</td>
				<td>${ud.salary}</td>
				<td><a href="${pageContext.request.contextPath}/userview/delete/${ud.userId}">Delete</a>
				
				&nbsp;
				
				<a href="${pageContext.request.contextPath}/userview/edit/${ud.userId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>