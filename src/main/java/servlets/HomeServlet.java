package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import daos.likeDAO;
import daos.CommentDAO;
import daos.PostDAO;
import beans.Comment;
import beans.Post;
import beans.like;

/**
 * Servlet implementation class HomeServlet
 */
//@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostDAO postDAO = new PostDAO();  
	private likeDAO likeDAO = new likeDAO();
	private CommentDAO commentDAO = new CommentDAO();
	
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
		
		List<Post> posts = postDAO.getAllPosts();
		HashMap<Post, List<Comment>> map = new HashMap<Post, List<Comment>>();	// use if posts order doesn't matter
//		List<List<Comment>> comments = new ArrayList<List<Comment>>(); // # comments != # posts, so need reference to postid as well..
		System.out.println("Getting comments for all posts");
		for (Post p : posts) {
//			comments.add(commentDAO.getComments(p.getPostId()));
			System.out.println("p: " + p.getPostId());
			map.put(p, commentDAO.getComments(p.getPostId()));
		}
		
		request.setAttribute("data", map);
//		request.setAttribute("comments", comments);
//		request.setAttribute("posts", posts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doing POST request for /home");
		
		String buttonClicked = request.getParameter("button");    
		String postId = request.getParameter("postId").toString();
		String comment = request.getParameter("comment");
		
		System.out.println("submit button clicked: " + buttonClicked);
		System.out.println("postid: " + postId);
		System.out.println(comment);
		
	    HttpSession session = request.getSession();
	    String username = (String)session.getAttribute("username");
//		String password = (String)session.getAttribute("password");
    
		System.out.println("Session user: " + username);
		
		if (buttonClicked.equals("Comment")) {
			Comment c = new Comment();
			c.setPost(UUID.fromString(postId));
			c.setComment(comment);
			c.setCommentor("user1");	// should be username
			commentDAO.createComment(c);
		
		} else if (buttonClicked.equals("Like")) {
			like l = new like();
			l.setUsername(username);
//        l.setPassword(password);
			l.setPostid(UUID.fromString(postId));
			System.out.println(username);
			System.out.println(postId);
		}
		
		response.sendRedirect("home");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("home");
		//dispatcher.forward(request, response);
	}

}
