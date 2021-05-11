package daos;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.DriverException;
import com.google.common.collect.ImmutableSet;

import java.util.UUID;
import beans.like;

public class likeDAO {
	   public static void likePost(like l) throws DriverException{   
	//query for likes
		   
    String likepost = "UPDATE sfapp.shelterusers SET likedpost = likedpost + ? WHERE username=? AND password=?";
    //Creating Cluster object 
    Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
    //Creating Session object 
    Session session = cluster.connect("sfapp");
    System.out.println((l.getPostid()).getClass());
    PreparedStatement prepared = session.prepare(likepost);
	BoundStatement bound = new BoundStatement(prepared);
	bound.setSet(0,ImmutableSet.of(l.getPostid()));
	bound.setString(1, l.getUsername());
	bound.setString(2, l.getPassword());
	ResultSet result = session.execute(bound);    	
	System.out.println(result.all());
	   }
}
