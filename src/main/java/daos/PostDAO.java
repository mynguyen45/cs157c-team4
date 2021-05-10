package daos;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import beans.Post;

public class PostDAO {

	/* 
	 * Get all posts. 
	 */
	public List<Post> getAllPosts() {
		System.out.println("getting all posts");
		
		//CQL Statement
		String query = "SELECT * FROM posts";
		
		// Connect to Cassandra
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		// Creating Session object Session
		Session session = cluster.connect("sfapp");
		
		ResultSet resultSet = session.execute(query);
//		System.out.println("result from query: " + resultSet.all());
		Iterator<Row> resultIterator = resultSet.iterator();
		List<Post> posts = new ArrayList<Post>();
		while (resultIterator.hasNext()) {
			Row row = resultIterator.next();
			Post p = new Post();
			p.setPostId(row.getUUID(0)); 
			p.setAdoptionStatus(row.getBool(1));
			p.setDescription(row.getString(2));			
			p.setMedia(row.getBytes(3));					// for only 1 image functionality
			p.setMedia(row.getList(4, ByteBuffer.class));	// for uploading/retrieving > 1 image functionality
			p.setPosterUsername(row.getString(5)); 
			posts.add(p);	
		}
		return posts;
	}
	
	
//	/* 
//	 * Get posts by poster.
//	 * Query users table to get associated userid then use that userid to query posts by userid.
//	 */ 
//	public Set<Post> getPostsBy(String poster) {
//		
//	}
//	
//	/* 
//	 * Get posts containing description.
//	 */
//	public Set<Post> getPostsContaining(String description) {
//	
//	}
//	
//	/* 
//	 * Get posts by adoption status.
//	 */
//	public Set<Post> getPostsBy(boolean status){
//		
//	}
	
	/* 
	 * Get post by tags.
	 */
	

	/* 
	 * Insert post into db. 
	 */
	public void createPost(Post post) throws ClassNotFoundException {
		System.out.println("creating post");
		
		//CQL Statement
		String INSERT_POST = "INSERT INTO posts" +
				" (postid, description, media, adoptable, poster) VALUES" +
				" (?, ?, ?, ?, ?)";		// only using 1 image uplaod functionality
		
		// Connect to Cassandra
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		// Creating Session object Session
		Session session = cluster.connect("sfapp");
		
		// Use 'poster' to get posterId
//		int posterId = User.getIdBy(post.getPoster());
		
		PreparedStatement preparedStatement = session.prepare(INSERT_POST);
		BoundStatement bound = preparedStatement.bind(UUID.randomUUID(), post.getDescription(), post.getMedia(), post.getAdoptionStatus(), post.getPosterUsername());
		ResultSet result = session.execute(bound);
//		ResultSet result = session.execute(preparedStatement.bind()
//				.setString(1, post.getDescription())
//				.setToNull(2)
////				.setString(2, post.getMedia())
//				.setBool(3, post.getAdoptionStatus())
//				.setInt(4, post.getPosterId()));

		System.out.println(result.all());
	}
}
