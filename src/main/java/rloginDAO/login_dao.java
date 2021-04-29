package rloginDAO;

import com.datastax.driver.core.exceptions.DriverException;

import regularUser.ruserModel.regularUser;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.BoundStatement;

public class login_dao{
    public static void login(regularUser ruser) throws DriverException{   	
        //queries 
        String queryUserName = "SELECT password from regularUser where userName = (?) ";
        //Creating Cluster object 
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //Creating Session object 
        Session session = cluster.connect("sfapp");
        
        PreparedStatement prepared = session.prepare(queryUserName);
    	BoundStatement bound = prepared.bind(ruser.getUsername());
    	ResultSet result = session.execute(bound);    	
    	System.out.println(result.all());    
    }
}