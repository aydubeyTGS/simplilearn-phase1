 <%@ page import="com.Product" %>
 
 <html>
<body>
 <!--    <h1><p>Product name:&nbsp;&nbsp;&nbsp;&nbsp;${session}</p></h1>
    <h1><p>Product quantity:&nbsp;&nbsp;&nbsp;&nbsp;${quant}</p></h1>
   <h1><p>Product price:&nbsp;&nbsp;&nbsp;&nbsp;${price}</p></h1> 
   -->
   <%
   Product prod=(Product)session.getAttribute("product");
   out.println(prod);
   %>
    
</body>

</html>