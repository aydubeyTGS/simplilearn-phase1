<%@page import="java.util.List"%>
<%@page import="com.dao.AppDao"%>
<%@page import="com.servlets.TravelServlet"%> 
<%@page import="com.beans.TravelBean"%> 
<%@page import="java.util.ArrayList"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Flights</title>
</head>
<body background="images/airp4.jpg">
<%
AppDao dao = AppDao.getAppDaoObj();

List<TravelBean> travels = dao.availableAllFlight();
%>
 <h1>Displaying All flights</h1> 
      <table border ="1" width="800" align="center"> 
         <tr bgcolor=#FFFF00> 
          <th><b>Flight Number</b></th> 
          <th><b>Source</b></th> 
          <th><b>Destination</b></th> 
         </tr> 
        <% 
        for(TravelBean s:travels){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr bgcolor=#90EE90> 
            
                <td><%=s.getFlightId()%></td> 
                <td><%=s.getSource()%></td> 
                <td><%=s.getDestination()%></td> 
                
            </tr> 
            <%}%>
            <tr><td>
            </td></tr>
        </table> 
        <hr/> 
</body>
</html>