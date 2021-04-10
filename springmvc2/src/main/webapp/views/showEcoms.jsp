<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
</head>
<body>
<h2> ${result}</h2>
 <form action = "updateUser" method = "post">
 <table border="1px">
 <tr>
 <td>Enter id:<input type="text" name="aid"/></td><br>
 </tr>
 <tr>
 <td>Enter name: <input type="text" name="pname"/></td><br>
 </tr>
 <tr>
 <td>Enter quantity: <input type="text" name="quantity"/></td><br>
 </tr>
 <tr>
 <td>Enter price: <input type="text" name="price"/></td>
 </tr>
 <center>
 <tr>
 <td><input type="submit" name="submit"/></td>
 </tr>
 </center>
 </form>
 </table>

</body>
</html>