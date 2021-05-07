package slogin.sloginController;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import slogin.sloginDAO.slogin_dao;
import slogin.sloginModel.sloginInfo;

@WebServlet("/slogin")
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
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			response.sendRedirect("home.jsp");
		} else {
			//HttpSession session = request.getSession();
			//session.setAttribute("user", username);
			response.sendRedirect("slogin.jsp");
		}
	}
}
