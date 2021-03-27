package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.TravelBean;
import com.dao.AppDao;



@WebServlet("/TravelServlet")
public class TravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		response.setContentType("text/html");
		System.out.println("TravelServlet---doGet");
		PrintWriter out=response.getWriter();
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String date=request.getParameter("date");
		String person=request.getParameter("person");
		System.out.println("source :"+source);
		System.out.println("destination :"+destination);
		System.out.println("date :"+date);
		System.out.println("person :"+person);

		AppDao dao = AppDao.getAppDaoObj();
		
		List<TravelBean> travels = dao.availableFlight(source, destination, date, person);
		System.out.println("getting data from jsp");
		//write the products data back to the client browser
		/*String page = getHTMLString(req.getServletContext().getRealPath("/html/searchResults.html"), products);
		resp.getWriter().write(page);*/
		request.setAttribute("travels", travels);
		HttpSession session = request.getSession();
		
		session.setAttribute("totalPerson", person);
		
		rd=request.getRequestDispatcher("available.jsp");
		
		rd.forward(request, response);
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		System.out.println("****************doGet");
	}
	




}
