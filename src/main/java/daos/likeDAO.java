package daos;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.DriverException;

import beans.like;

public class likeDAO {
	   public static void likePost(like l) throws DriverException{   
	//query for likes
    String insert_user = "UPDATE sfapp.shelterusers SET likedpost = ? WHERE username=? AND password=?";
    //Creating Cluster object 
    Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
    //Creating Session object 
    Session session = cluster.connect("sfapp");

    PreparedStatement prepared = session.prepare(insert_user);
	BoundStatement bound = prepared.bind(l.getPostid(),l.getUsername(),l.getPassword());
	ResultSet result = session.execute(bound);    	
	System.out.println(result.all());
	   }
}
