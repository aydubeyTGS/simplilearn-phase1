package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		String name=request.getParameter("prodname");
		int quantity=Integer.parseInt(request.getParameter("prodquantity"));
		double price=Double.parseDouble(request.getParameter("prodprice"));
		
		Product prod=new Product();
		prod.setProdname(name);
		prod.setQuantity(quantity);
		prod.setPrice(price);
		
		HttpSession session=request.getSession();
		session.setAttribute("product", prod);
		
//		request.setAttribute("pname", name);
//		request.setAttribute("quant", quantity);
//		request.setAttribute("price", price);
		
		rd=request.getRequestDispatcher("viewprod.jsp");
		rd.forward(request, response);
		
	

}
}
