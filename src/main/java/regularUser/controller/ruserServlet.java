package regularUser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import regularUser.ruserDAO.r_user_dao;
import regularUser.ruserModel.regularUser;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class ruserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private r_user_dao suser_dao = new r_user_dao();
	
	public void init() {
		suser_dao = new r_user_dao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ruserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MavenWebapp/index.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		
		regularUser suser = new regularUser();
		suser.setUsername(username);
		suser.setPassword(password);
		suser.setEmail(email);
		
		try {
			r_user_dao.registerRuser(suser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
	}

}
