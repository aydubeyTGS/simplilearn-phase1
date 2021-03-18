package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		RequestDispatcher rd=null;
		if(name.equalsIgnoreCase("ayush") && pwd.equals("ad@755"))
		{
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("login.html");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.println("<center><span style='color:red'>Invalid Credentials!!!</span></center>");
		}
	}


}
