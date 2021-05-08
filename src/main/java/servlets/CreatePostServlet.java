package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.PostDAO;

@WebServlet("/createPost")
@MultipartConfig(maxFileSize= 16177215)	//upload file's size up to 16MB
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostDAO postDAO = new PostDAO();
	
	public CreatePostServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doing GET request from create_post.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("create_post.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Doing POST request from CreatePost.jsp");

		String description = request.getParameter("description");
//		id posterId = request.getParameter("posterId");	// Only use if storing this instead or username in session token.
//		String poster = request.getParameter("poster");	// username from session token. Use to get posterId in PostDAO
		Boolean adoptionStatus  = Boolean.valueOf(request.getParameter("adoptionStatus"));
		
		// Supports one file upload. Loop to implement multiple as List<InputStream>
		InputStream mediaInputStream = null;
		
		Part filePart = request.getPart("media");
		if (filePart != null) {
			System.out.println("File name: " + filePart.getName());
			System.out.println("File size: " + filePart.getSize());
			System.out.println("File type: " + filePart.getContentType());	// must be image
			
			if (!filePart.getContentType().equals("image/jpeg") && !filePart.getContentType().equals("image/png")) {
				System.out.println("Uploaded file is not an image");
				
				/*
				 * TODO: send error message to user, let them know that uploaded file must be .jpeg or .png
				 */
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("create_post.jsp");	// temporary.			
				dispatcher.forward(request, response);
				return;
				
			}
			mediaInputStream = filePart.getInputStream();
		}
		
		// Convert InputStream -> byte[] -> ByteBuffer to pass to post and store in cassandra db.
		byte[] mediaBytes = mediaInputStream.readAllBytes(); 
		ByteBuffer mediaByteBuffer = ByteBuffer.wrap(mediaBytes);
		
		
		// iterate through all files to add media content to list for > 1 image upload functionality.
//		List<ByteBuffer> medias = new ArrayList<ByteBuffer>();
//		medias.add(mediaByteBuffer);
		
		
		System.out.println("\nRequest params:");
		System.out.println("Description: " + description);
//		System.out.println("Poster: " + poster);
//		System.out.println("PosterId: " + posterId);
		System.out.println("Adoptable: " + adoptionStatus);
		System.out.println("InputStream: " + mediaInputStream);		
		System.out.println("ByteBuffer: " + mediaByteBuffer);
		
		
		/* Can request params only be set if they're not null? AKA do a null check on each? */
		
		Post post = new Post();
		post.setPosterUsername("jalend");	// Get userId orusername (post-posterId) from session token. If username, must query users table to get associated userId.
		post.setDescription(description);
		post.setAdoptionStatus(adoptionStatus);
//		post.setMedia(medias);	// > 1 image functionality
		post.setMedia(mediaByteBuffer);
		
		
		System.out.println("\nPostDAO: ");
//		System.out.println(post.getPosterId());
		System.out.println(post.getDescription());
		System.out.println(post.getAdoptionStatus());

		try {
			System.out.println("going to createpost method");
			postDAO.createPost(post);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		response.sendRedirect("Temporary_SuccessfulCreation.jsp");
		
		/*
		 * TODO: send the results of all posts query as response to home page
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("Temporary_SuccessfulCreation.jsp");	// temporary.
		dispatcher.forward(request, response);
	}
}
