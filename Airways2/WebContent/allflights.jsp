<%@page import="com.servlets.TravelServlet"%> 
<%@page import="com.beans.TravelBean"%> 
<%@page import="java.util.ArrayList"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><center><h1>Available Flights</h1></center></title>
</head>
<body>
 <h1>Displaying flights</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
         <th> Select Flight</th>
          <th><b>Flight Number</b></th> 
          <th><b>Flight name</b></th> 
          <th><b>Fare</b></th> 
         </tr> 
         <form action= "register.jsp">
        <%ArrayList<TravelBean> std =  
            (ArrayList<TravelBean>)request.getAttribute("travels"); 
        for(TravelBean s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
            
                <td>
               <input type = "radio" name ="flight_id" value = "<%=s.getFlightId()%>"></input>
               </td>
                <td><%=s.getFlightId()%></td> 
                <td><%=s.getCompany()%></td> 
                <td><%=s.getFare()%></td> 
                
            </tr> 
            <%}%>
            <tr><td>
            <input type="submit" value=submit /> 
            </td></tr>
        </table> 
        </form> 
        <hr/> 
</body>
</html>