package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.TravelBean;
import com.dao.AppDao;


@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TicketServlet----doGet ");
		System.out.println("Parameter List :"+request.getParameterMap());
		AppDao dao = AppDao.getAppDaoObj();
		String flight_id = request.getParameter("flight_id");
		if(flight_id == null)		{
			HttpSession session = request.getSession();
			flight_id =  (String)session.getAttribute("flight_id");
			//session.removeAttribute("flight_id");
		}
		
		
		TravelBean travelBean = dao.getFlight(flight_id);
		request.setAttribute("travel", travelBean);
		HttpSession session = request.getSession();
		
		String person = (String)session.getAttribute("totalPerson");
		request.setAttribute("totalPersonFromRequest", person);
		
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("booking.jsp");
		
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
