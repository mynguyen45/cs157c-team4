package adoptable.java.userBusiness;

import com.datastax.driver.core.exceptions.DriverException;

import adoptable.java.transferObject.RegularUser;
//import adoptable.java.util.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Row;

public class RuserBusiness{
	static ResultSet result;
	static Cluster c = Cluster.builder().addContactPoint("127.0.0.1").build();
	public static void main(String[] args) {
		System.out.println("connected");
		System.out.println(result.all());
		
	}
    public static RegularUser login (String username, String password){   	
        //queries 
        String select_user = "SELECT * FROM regular_users WHERE username = ? and password = ? ALLOW FILTERING";
        //Creating Session object 
        Session session = c.connect("sfapp");
        PreparedStatement statement = session.prepare(select_user);
    	BoundStatement bound = statement.bind(username,password);
    	result = session.execute(bound);
    	//Row row = session.execute(bound);
    	 System.out.println(result.all());
    	if(result != null) {
    		System.out.println(result.all());
    	RegularUser user = new RegularUser();
    	for(Row row:result) {
    		user.setEmail(row.getString("email"));
    		user.setPassword(row.getString("password"));
    		user.setUsername(row.getString("username"));
    		user.setFollowers(row.getString("followers"));
    		user.setFollowings(row.getString("followings"));
    		user.setLikedPost(row.getString("likedPost"));
    	}
    	return user;
    	}
    	return null;
    	
    }
    public static Boolean register (String username, String password, String email){   	
        //queries 
    	String select_user = "INSERT INTO regular_users (username,password, email ) VALUES (? ,?, ?)";
        //Creating Session object 
        Session session = c.connect("sfapp");
        PreparedStatement statement = session.prepare(select_user);
    	BoundStatement bound = statement.bind(username,password,email);
    	result = session.execute(bound);
    	System.out.println(result.all());
    	if(result.isExhausted())
    		return true;
		return false;
    	
    	
    }
}
/*
 * ///queries 
        String insert_user = "INSERT INTO shelterusers (userid,username, address, email, password) values (12,?,?,?,?)";
        //Creating Cluster object 
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //Creating Session object 
        Session session = cluster.connect("sfapp");
  
        PreparedStatement prepared = session.prepare(insert_user);
    	BoundStatement bound = prepared.bind(suser.getUsername(),suser.getAddress(),suser.getEmail(),suser.getPassword());
    	ResultSet result = session.execute(bound);    	
    	System.out.println(result.all());
        
        
 */
