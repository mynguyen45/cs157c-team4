package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.slogin_dao;
import beans.sloginInfo;

//@WebServlet("/slogin")
public class sloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private slogin_dao loginDao;

	public void init() {
		loginDao = new slogin_dao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		sloginInfo suser = new sloginInfo();
		suser.setUsername(username);
		suser.setPassword(password);

		if (loginDao.loginSuser(suser)) {
			System.out.println("leading to home");
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			session.setAttribute("password",password);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
			//dispatcher.forward(request, response);
			response.sendRedirect("home");
		} else {
			System.out.println("else entered");
			//HttpSession session = request.getSession();
			//session.setAttribute("user", username);
			response.sendRedirect("slogin.jsp");
		}
	}
}
