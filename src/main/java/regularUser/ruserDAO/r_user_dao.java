package regularUser.ruserDAO;

import com.datastax.driver.core.exceptions.DriverException;

import regularUser.ruserModel.regularUser;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;

public class r_user_dao{
    public static void registerRuser(regularUser ruser) throws DriverException{   	
        //queries 
        String insert_user = "INSERT INTO regularUser (username,email, password) values (?,?,?)";
        //Creating Cluster object 
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //Creating Session object 
        Session session = cluster.connect("sfapp");
  
        PreparedStatement prepared = session.prepare(insert_user);
    	BoundStatement bound = prepared.bind(ruser.getUsername(),ruser.getEmail(),ruser.getPassword());
    	ResultSet result = session.execute(bound);    	
    	System.out.println(result.all());
      
    }
}