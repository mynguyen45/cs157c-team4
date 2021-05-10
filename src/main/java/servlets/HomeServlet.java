package servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import daos.likeDAO;
import daos.PostDAO;
import beans.like;

/**
 * Servlet implementation class HomeServlet
 */
//@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostDAO postDAO = new PostDAO();  
	private likeDAO likeDAO = new likeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doing GET request for /home");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("posts", postDAO.getAllPosts());
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doing POST request for /home");
		System.out.println("submit button clicked: " + request.getParameter("button"));
    
    String postId = request.getParameter("postId").toString();
		System.out.println("postid: " + postId);
    
    HttpSession session = request.getSession();
    String username = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
    
		switch (request.getParameter("button")) {
			case "Comment" :
				
				break;
				
			case "Like" :
				like l = new like();
        l.setUsername(username);
        l.setPassword(password);
        l.setPostid(UUID.fromString(postId));
        System.out.println(username);
        System.out.println(postId);
				break;
		}
		
		response.sendRedirect("home");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("home");
		//dispatcher.forward(request, response);
	}

}