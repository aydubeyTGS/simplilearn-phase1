<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<html>
<body  style='background-color:yellow;'>
<form action="AdminServlet" method="post">
<table class="center" border ="1" width="800" align="center" >
 <input type = "hidden" name = "method" value ="changePwd"   />
                <input type = "hidden" name = "user_id" value =<%=session.getAttribute("username")%>   />
<tr><th colspan="4" col>Current Password</th><td><input type="password" name="currentpwd" ></td></tr>
<tr><th colspan="4" col>New Password</th><td><input type="password" name="newPwd"></td></tr>
<tr><th colspan="4" col>Confirm Password</th><td><input type="password" name="confirm"></td></tr>
<tr><th colspan="4" col><input type="submit" value="Change Password" style="background-color:red; border-color:blue; color:white"></th></tr>
</table>
</form>

<%-- <%
String currentPassword=request.getParameter("current");
String Newpass=request.getParameter("new");
String conpass=request.getParameter("confirm");
String connurl = "jdbc:mysql://localhost:3306/users";
Connection con=null;
String pass="";
int id=0;
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(connurl, "admin", "");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from login where password='"+currentPassword+"'");
while(rs.next()){
id=rs.getInt(1);
pass=rs.getString(3);
} System.out.println(id+ " "+pass);
if(pass.equals(currentPassword)){
Statement st1=con.createStatement();
int i=st1.executeUpdate("update login set password='"+Newpass+"' where id='"+id+"'");
out.println("Password changed successfully");
st1.close();
con.close();
}
else{
out.println("Invalid Current Password");
}
}
catch(Exception e){
out.println(e);
}
%> --%>




</body>
</html>







</html>