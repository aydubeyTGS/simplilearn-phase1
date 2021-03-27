<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket</title>
</head>
<form method="post" action="payment.jsp">
<body background="images/airp8.jpg">


<%
String SpersonName = (String) session.getAttribute("totalPerson");
	String flightId = request.getParameter("flightId");
	String fare = request.getParameter("fare");
	String company = request.getParameter("company");
	
	int personSize = Integer.parseInt(SpersonName);
	List<String> personNames = new ArrayList();
	for(int i=0; i<personSize; i++){
		personNames.add(request.getParameter("person_"+i));
	}
	String ContactDetails = request.getParameter("ContactDetails");
	String emailId = request.getParameter("emailId");

	HttpSession s=request.getSession();
	s.setAttribute("fare", fare);
	
%>

<table border ="1" width="800" align="center"> 
         <tr bgcolor=#FFFF00> 
		<th colspan="2">
			Ticket Info
		</th>
	</tr>
	<tr bgcolor=#4C9A2A>
		    <th>Passenger Name:</th>
			<td> <%= personNames %></td>
	</tr>
	<tr bgcolor=#4C9A2A>
		
			<th>flightId: </th>
			<td> <%= flightId %></td>
		
	</tr>
	<tr bgcolor=#4C9A2A>
		
			<th>fare: </th>
			<td> <%= fare %></td>

	</tr>
	<tr bgcolor=#4C9A2A>
		
			<th>company: </th>
			<td> <%= company %></td>
		
	</tr>
	<tr bgcolor=#4C9A2A>
		
			<th>ContactDetails: </th>
			<td> <%= ContactDetails %></td>
	</tr>
	<tr bgcolor=#4C9A2A>
		
			<th>emailId: </th>
			<td> <%= emailId %>	</td>
	
	</tr>
	 <tr><td>
            <input type="submit" value=submit  style="background-color:red; border-color:blue; color:white" /> 
            </td></tr>
</table>
</form>
</body>
</html>