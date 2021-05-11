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

import beans.Comment;

public class CommentDAO {
	
	public void createComment(Comment c) {
		System.out.println("creating comment");
		
		//CQL Statement
		String INSERT_COMMENT = "INSERT INTO comments" +
				" (commentor, post, comment) VALUES" +
				" (?, ?, ?)";		// only using 1 image uplaod functionality
		
		// Connect to Cassandra
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		// Creating Session object Session
		Session session = cluster.connect("sfapp");
		
		// Use 'poster' to get posterId
//		int posterId = User.getIdBy(post.getPoster());
		
		PreparedStatement preparedStatement = session.prepare(INSERT_COMMENT);
		BoundStatement bound = preparedStatement.bind(c.getCommentor(), c.getPost(), c.getComment());
		ResultSet result = session.execute(bound);
		System.out.println("Comment created. " + result.all());
		session.close();
	}
	
	public List<Comment> getComments(UUID post) {
		System.out.println("getting all comments");
		
		//CQL Statement
		String query = "SELECT * FROM comments WHERE post="+post+" ALLOW FILTERING";
		
		// Connect to Cassandra
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		// Creating Session object Session
		Session session = cluster.connect("sfapp");
		
		ResultSet resultSet = session.execute(query);
//		System.out.println("result from query: " + resultSet.all());
		Iterator<Row> resultIterator = resultSet.iterator();
		List<Comment> comments = new ArrayList<Comment>();
//		Comment c = new Comment();
		while (resultIterator.hasNext()) {
			Row row = resultIterator.next();
			Comment c = new Comment();
//			System.out.println("getting comments for post " + row.getUUID(1));
			c.setCommentor(row.getString(0)); 
			c.setPost(row.getUUID(1));
			c.setComment(row.getString(2));
			comments.add(c);	
		}
		session.close();
		return comments;
	}

}
