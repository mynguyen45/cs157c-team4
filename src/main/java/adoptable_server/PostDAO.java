package adoptable_server;

import java.util.Set;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class PostDAO {

	/* 
	 * Get all posts. 
	 */
	public Set<Post> getAllPosts() {
		
	}
	
	/* 
	 * Get posts by poster.
	 * Query users table to get associated userid then use that userid to query posts by userid.
	 */ 
	public Set<Post> getPostsBy(String poster) {
		
	}
	
	/* 
	 * Get posts containing description.
	 */
	public Set<Post> getPostsContaining(String description) {
	
	}
	
	/* 
	 * Get posts by adoption status.
	 */
	public Set<Post> getPostsBy(boolean status){
		
	}
	
	/* 
	 * Get post by tags.
	 */
	

	/* 
	 * Insert post into db. 
	 */
	public void createPost(Post post) throws ClassNotFoundException {
		String INSERT_POST = "INSERT INTO posts" +
				" (postid, description, media, adoptable, userid) VALUES" +
				" (NULL, ?, ?, ?, ?)";	// postid value is NULL, db auto increments it.
		
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		// Creating Session object Session
		Session session = cluster.connect("sfapp");
		
		// Use 'poster' to get posterId
		int posterId = User.getIdBy(post.getPoster());
		
		PreparedStatement preparedStatement = session.prepare(INSERT_POST);
		ResultSet result = session.execute(preparedStatement.bind()
				.setString(1, post.getDescription())
				.setString(2, post.getMedia())
				.setString(3, post.getAdoptionStatus())
				.setStrign(4, post.getPosterId()));

		
	}
}
