package shelterUser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shelterUser.suserDAO.s_user_dao;
import shelterUser.suserModel.shelterUser;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class suserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private s_user_dao suser_dao = new s_user_dao();
	
	public void init() {
		suser_dao = new s_user_dao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sfapp/account.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		
		shelterUser suser = new shelterUser();
		suser.setUsername(username);
		suser.setPassword(password);
		suser.setEmail(email);
		suser.setAddress(address);
		
		try {
			s_user_dao.registerSuser(suser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request,response);
	}

}
