package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;
import com.dao.AppDao;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdminServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=null;
		
		String methodType = request.getParameter("method");
		if(methodType != null && methodType.equalsIgnoreCase("registration")) {
			String name = request.getParameter("name");
			String lgnm = request.getParameter("lgnm");
			//check lgnm is dnot duplicate and if found forward register.jsp
			
			String ps = request.getParameter("ps");
			String mb = request.getParameter("mb");
			String gen = request.getParameter("gen");
			String flight_id = request.getParameter("flight_id");
			String type = flight_id != null ? "User" :"ADMIN";
			User user = new User(name,lgnm,ps,type,gen,mb);
			HttpSession session = request.getSession();
			
			session.setAttribute("flight_id", flight_id);
			AppDao dao = AppDao.getAppDaoObj();
			int i = dao.registerUser(user);
			System.out.println("Data sunccessfully inserted :"+(i>0));
			rd=request.getRequestDispatcher("adminlogin.jsp");
			
		}else if(methodType != null && methodType.equalsIgnoreCase("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username);
			System.out.println(password);
			AppDao dao = AppDao.getAppDaoObj();
			User user =  dao.validUser(username,password);
			if(null != user) {
				HttpSession session = request.getSession();
				String flight_id =  (String)session.getAttribute("flight_id");
				session.setAttribute("username", username);
				if(flight_id == null) {
					rd=request.getRequestDispatcher("home.jsp");
				}else {
					rd=request.getRequestDispatcher("TicketServlet");
				}
			}
			else
				rd=request.getRequestDispatcher("error.jsp");
		
		}else if(methodType != null && methodType.equalsIgnoreCase("changePwd")) {
			String currentpwd = request.getParameter("currentpwd");
			String password = request.getParameter("newPwd");
			String user_id = request.getParameter("user_id");
			System.out.println("currentpwd :"+currentpwd);
//			System.out.println("newPwd :"+password);
//			System.out.println("user_id :"+user_id);
			AppDao dao = AppDao.getAppDaoObj();
			int row =  dao.changePwd(user_id, currentpwd,password);
			if (row > 1) {
				rd=request.getRequestDispatcher("error.jsp");
			}else {
				
				rd=request.getRequestDispatcher("home.jsp");
			}
		}
		
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
