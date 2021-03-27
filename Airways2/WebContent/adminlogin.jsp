<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body style='background-color: green;'>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
 <form method="post" action="AdminServlet">
            <table border ="0" width="800" align="center">
            <input type = "hidden" name ="method" value = "login"/>
                <tr><td colspan="2"> 
                	<center>
                <h1>Login Here</h1>
                </center>
                </td></tr>
                <tr bgcolor=#FFFFE0><td> <h2>Login Name :</h2> </td><td> <input type="text" name="username"></td></tr>
                <tr bgcolor=#FFFFE0><td><h2> Password :</h2> </td><td> <input type="password" name="password"></td></tr>
                <tr><td colspan="2"> 
                	<center>
                <button type="submit" style="background-color:red; border-color:blue; color:white">LOGIN</button>
                </center>
                </td></tr>
            </table>
        </form>


</body>
</html>