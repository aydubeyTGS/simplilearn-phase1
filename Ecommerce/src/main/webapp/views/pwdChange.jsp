<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Change</title>
</head>

<body  style='background-color:yellow;'>
<form action="changePwd" method="post">
<table class="center" border ="1" width="800" align="center" >
 <input type = "hidden" name = "method" value ="changePwd"   />
<input type="hidden" name="username" value="<%=session.getAttribute("username")%>"/>          
<tr><th colspan="4" col>Current Password</th><td><input type="password" name="currentPwd" ></td></tr>
<tr><th colspan="4" col>New Password</th><td><input type="password" name="newPwd"></td></tr>
<tr><th colspan="4" col>Confirm Password</th><td><input type="password" name="confirm"></td></tr>
<tr><th colspan="4" col><input type="submit" value="Change Password" style="background-color:red; border-color:blue; color:white"></th></tr>
</table>
</form>
</body>
</html>