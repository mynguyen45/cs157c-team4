package daos;

import com.datastax.driver.core.exceptions.DriverException;

import beans.shelterUser;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;

public class s_user_dao{
    public static void registerSuser(shelterUser suser) throws DriverException{   	
        //queries 
        String insert_user = "INSERT INTO shelterusers (userid,username, address, email, password) values (12,?,?,?,?)";
        //Creating Cluster object 
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //Creating Session object 
        Session session = cluster.connect("sfapp");
  
        PreparedStatement prepared = session.prepare(insert_user);
    	BoundStatement bound = prepared.bind(suser.getUsername(),suser.getAddress(),suser.getEmail(),suser.getPassword());
    	ResultSet result = session.execute(bound);    	
    	System.out.println(result.all());
        
    
    }
}