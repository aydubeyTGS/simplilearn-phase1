<%@page import="com.beans.TravelBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Booking</title>
</head>
<body background="images/airp8.jpg">
<form action="ticket.jsp">
	<%
	TravelBean travelBean = (TravelBean)request.getAttribute("travel");
	String personName = (String) request.getAttribute("totalPersonFromRequest");
	String SpersonName = (String) session.getAttribute("totalPerson");
	%>
	 <table border ="1" width="800" align="center">
	           <tr bgcolor=#F5BD1F>
               <th>Your Flight Id: </th>
               <td><%=travelBean.getFlightId()%></td><br>
               </tr>
               
               <tr bgcolor=#F5BD1F>
               <th>Your Flight Company: </th>
               <td><%=travelBean.getCompany()%></td> </br>
               </tr>
               
               <tr bgcolor=#F5BD1F>
               <th>Your fare: </th>
                <td><%=travelBean.getFare()%></td> </br>
               </tr>
               
                <input type = "hidden" name = "flightId" value =<%=travelBean.getFlightId()%>   />
                <input type = "hidden" name = "fare" value =<%=travelBean.getFare()%>   />
                <input type = "hidden" name = "company" value =<%=travelBean.getCompany()%>   />
        
       
        
        <%
        	int personSize = Integer.parseInt(personName);
        	for(int i=0; i<personSize; i++){%>
        	<tr bgcolor=#800000>
        	<th>Enter Person details <%=i+1%> : </th>
        	<td><input type = "text" name = "person_<%=i%>" /></td>
        	</tr>
        	</br>
        		<%
        	}
        
        %>  
        
			<tr bgcolor=#800000>
       <th> Contact Details : </th> <td><input type = "text" name = "ContactDetails" /> </td> </br>   
         </tr>
         <tr bgcolor=#800000> 
        <th>Email id: </th> <td><input type = "text" name = "emailId" /></td> </tr>  </br> 
       
       <tr><td>
            <input type="submit" value=submit  style="background-color:red; border-color:blue; color:white" /> 
            </td></tr>
       
        </table>
        </form>
</body>
</html>