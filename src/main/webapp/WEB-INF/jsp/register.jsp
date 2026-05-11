<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello ${name}</h1>
<form action="./userregister" method = "post">
	UserName: <input type = "text" name="userName"></input>
	Age: <input type = "text" name="age"></input>
	Salary: <input type = "text" name="salary"></input>
	Password:	<input type = "password" name="password"></input>
	<button type = "submit" value="Submit"> Submit
	</button>
	</form>
	
	<a href='login.jsp'>Login</a>
</body>
</html>