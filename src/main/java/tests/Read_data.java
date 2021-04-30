package tests;
import com.datastax.driver.core.Cluster; 
import com.datastax.driver.core.ResultSet; 
import com.datastax.driver.core.Session; 

public class Read_data {
	public static void main(String args[]) throws Exception {
		// queries
		String query = "SELECT * FROM posts";
		
		// Creating Cluster object
		Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		
		// Creating Session object Session
		Session session = cluster.connect("cs157c");
		
		// Getting the ResultSet
		ResultSet result = session.execute(query);
		System.out.println(result.all());
	}
}