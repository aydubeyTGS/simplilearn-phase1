<html>
<head>

<title>Bookings Page</title>
</head>

<body  background="images/airp10.jpg">
	<form method="post" action="TravelServlet">
		<table border ="1" width="800" align="center">
			<tr bgcolor=#800080>
				<th colspan="2" col><h2>Booking window</h2></th>
			</tr>
			<tr bgcolor=#ADD8E6>
				<td><h3>Enter source location</h3></td>
				<td><input type="text" name="source" /><br></td>
			</tr>
			<tr bgcolor=#ADD8E6>
				<td><h3>Enter destination location</h3></td>
				<td><input type="text" name="destination" /><br></td>
			</tr>
			<tr bgcolor=#ADD8E6>
				<td><h3>Enter date of travel</h3></td>
				<td><input type="text" name="date" /><br></td>
			</tr>
			<tr bgcolor=#ADD8E6>
				<td><h3>Enter the number of persons</h3></td>
				<td><input type="text" name="person" /><br></td>
			</tr>
			<tr bgcolor=#ADD8E6>
				<td colspan="4">
				
			
				<input type="submit" value=submit value=submit  style="background-color:red; border-color:blue; color:white"/>
				
				</td>
			</tr>

		</table>



	</form>
</body>

</html>