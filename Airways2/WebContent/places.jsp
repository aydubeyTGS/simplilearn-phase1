<%@page import="com.beans.TravelBean"%>
<%@page import="java.util.*"%>

 import=
<%@page import="com.dao.AppDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Booking</title>
</head>
<body>
<form >
	<%
	TravelBean travelBean = (TravelBean)request.getAttribute("travel");
	%>
	
	<table border ="1" width="800" align="center">
	           <tr bgcolor=#F5BD1F>
               <th>Source: </th>
               <td><%=travelBean.getSource()%></td><br>
               </tr>
               
               <tr bgcolor=#F5BD1F>
               <th>Destination: </th>
               <td><%=travelBean.getDestination()%></td> </br>
               </tr>
               
               
               
                <input type = "hidden" name = "source" value =<%=travelBean.getSource()%>   />
                <input type = "hidden" name = "destination" value =<%=travelBean.getDestination()%>   />
              
        
	</form>
	</body>
	</html>
	