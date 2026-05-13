<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
<form action="../login/userlogin" method = "post">
	username: <input type = "text" name="username"></input>
	password:	<input type = "password" name="password"></input>
	
	<button type = "submit"> Submit
	</button>
	</form>
	
	<a href='../register/register'>Register</a>
</body>
</html>