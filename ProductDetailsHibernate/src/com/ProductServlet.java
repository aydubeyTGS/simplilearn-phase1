package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;





public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		
		int pid=Integer.parseInt(request.getParameter("prodid"));
		
		ProductService ps=new ProductService();
		Product pr=ps.checkForId(pid);
		if(pr!=null) {
			out.println("<h1>"+ pr+"</h1>");
		}
		
		
		else{
			out.println("<h1>Product id not found</h1>");
			}
		
		
	
	

}
}
