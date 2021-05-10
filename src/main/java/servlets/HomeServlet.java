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
@WebServlet("/home")
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
		System.out.println("Doing get request for /home");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("posts", postDAO.getAllPosts());
		
//		System.out.println("setAttribute posts: " + postDAO.getAllPosts());
		// or sendRedirect? need to pass data to home.jsp
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//add like functionality
		System.out.println("Post running /home");
		HttpSession session = request.getSession();

		like l = new like();
		String username = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
		String postId = request.getParameter("Like");
		l.setUsername(username);
		l.setPassword(password);
		l.setPostid(UUID.fromString(postId));
		System.out.println(username);
		System.out.println(postId);
		response.sendRedirect("home");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("home");
		//dispatcher.forward(request, response);
	}

}
