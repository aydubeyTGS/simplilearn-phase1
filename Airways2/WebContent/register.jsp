<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style='background-color: red;'>
 <form action="AdminServlet"  method="POST" >
            <table align="center">
            <%
            	String flight_id =  request.getParameter("flight_id");
            	if(flight_id != null){ %>
            	<input type = "hidden" name ="flight_id" value = "<%=flight_id%>"/>
             <%		
            	}
            %>
            <input type = "hidden" name ="method" value = "registration"/>
                <tr><td> <h3>Name :</h3> </td><td> <input  type="text" name="name"></td></tr>
                <tr><td> <h3>Login Name :</h3> </td><td> <input type="text" name="lgnm"></td></tr>
                <tr><td><h3> Password :</h3> </td><td> <input type="password" name="ps"></td></tr>
                <tr><td> <h3>Mobile :</h3> </td><td><input type="text" name="mb"></td></tr>
                <tr><td><h3> Gender :</h3> </td><td><input type="radio" name="gen" value="Male" checked="yes">Male</td></tr>
                <tr><td>         </td><td><input type="radio" name="gen" value="Female">Female</td></tr>
                
                 <tr ><td colspan="2"> <button style="background-color:red; border-color:blue; color:white" >REGISTER</button></td></tr>
            </table>
        </form>
</body>
</html>

