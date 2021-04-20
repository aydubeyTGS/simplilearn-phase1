<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background-color:green;'>
<form action="registerUser" method="Post">
Enter username:-<input type = "text" name = "username"/><br/>
Enter Password:-<input type = "password" name = "password"/><br/>
Select Role:-<select name="role">
	<option>User</option>
	<option>Admin</option>
</select>
<input type="submit" value="Register"> 

</form>
</body>
</html>