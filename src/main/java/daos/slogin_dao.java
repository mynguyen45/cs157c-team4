package daos;

import com.datastax.driver.core.exceptions.DriverException;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;
import beans.sloginInfo;

public class slogin_dao{
    public boolean loginSuser(sloginInfo suser) throws DriverException{   	
        //check if username and password matches 
        String login_shelter = "select * from shelterusers where username = ? AND password = ?;";
        //Creating Cluster object 
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //Creating Session object 
        Session session = cluster.connect("sfapp");
        
        PreparedStatement prepared = session.prepare(login_shelter);
    	BoundStatement bound = new BoundStatement(prepared);
    	bound.setString(0,suser.getUsername());
    	bound.setString(1,suser.getPassword());
    	
    	ResultSet result = session.execute(bound);    	
    	
    	
        if((result.all()).size() == 1){
        	System.out.println("Correct username and password");
        	return true;
        }
        System.out.println("Wrong username or password");
        return false;
    }
}