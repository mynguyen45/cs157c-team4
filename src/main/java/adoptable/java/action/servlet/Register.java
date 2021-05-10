package adoptable.java.action.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datastax.driver.core.exceptions.DriverException;

import adoptable.java.transferObject.*;
import adoptable.java.userBusiness.*;
//import adoptable.java.util.DBUtil;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;

@WebServlet(name="register", urlPatterns = {"/register"})
public class Register extends HttpServlet {
	//private static final long serialVersionUID = 1L;
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//		dispatcher.forward(request,response);
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		try {
			//Cluster c = DBUtil.getCluster();
			Boolean registered = RuserBusiness.register(username, password, email);
			if(registered) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request,response);
			} else
			{
				request.setAttribute("err", "");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request,response);
			}
		} catch (Exception e) {
			request.setAttribute("err", "system error "+e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request,response);
		}
		
		
	}

}
