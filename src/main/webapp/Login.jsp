<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Login</h1><br/>

<h3>${SPRING_SECURITY_LAST_EXCEPTION.message}</h3>
<form action="Login" method="post">
Username :<input type="text" name="username"><br/>
Password :<input type="password" name="password"><br/>
<input type="submit" value="Login">
</form>
</body>
</html>