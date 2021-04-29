package adoptable_server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createPost")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PostServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CreatePost.jsp");	// temporary.
//		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doing post request from CreatePost.jsp");
		
//		List<Blob> media = request.getParameter("media");
		String description = request.getParameter("description");
		String poster = request.getParameter("poster");	// username from login token. Use to get posterId in PostDAO
		boolean adoptionStatus  = Boolean.valueOf(request.getParameter("adoptionStatus"));
		
		System.out.println("\nRequest params:");
		System.out.println(description);
		System.out.println(poster);
		System.out.println(adoptionStatus);
		
		
//		User user = new User();
//		user.setUsername(poster);
		
		/* Can request params only be set if they're not null? AKA do a null check on each? */
		
		Post post = new Post();
//		post.setMedia(media);
		post.setDescription(description);
		post.setAdoptionStatus(adoptionStatus);
		
		System.out.println("\nPostDAO: ");
//		System.out.println(post.getPosterId());
		System.out.println(post.getDescription());
		System.out.println(post.getAdoptionStatus());

		
//		try {
//			PostDAO.createPost(post);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		response.sendRedirect("/WEB-INF/Temporary_SuccessfulCreation.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Temporary_SuccessfulCreation.jsp");	// temporary.
//		dispatcher.forward(request, response);
	}
}
