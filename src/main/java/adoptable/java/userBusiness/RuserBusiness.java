package adoptable.java.userBusiness;

import com.datastax.driver.core.exceptions.DriverException;

import adoptable.java.transferObject.RegularUser;
//import adoptable.java.util.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Row;

public class RuserBusiness{
	//static ResultSet result;
	static RegularUser user ;
	
	public static void main(String[] args) {
		
		System.out.println(login("1","2"));		
	}
    public static boolean login (String username, String password){   	
        //queries 
        String select_user = "SELECT * FROM regular_users WHERE username = ? AND password = ? ALLOW FILTERING;";
        //Creating Session object 
        Cluster c = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = c.connect("sfapp");
        PreparedStatement statement = session.prepare(select_user);
    	BoundStatement bound = new BoundStatement(statement);
    	bound.setString(0,username);
    	bound.setString(1,password);
    	ResultSet result = session.execute(bound);
    
    	if( result.all().size() ==1) {  
    		System.out.println(result.all());
    		return true;
    	}    		
    	return false;      	
    }
    public static boolean register (String username, String password, String email){   	
        //queries 
    	String select_user = "INSERT INTO regular_users (username,password, email ) VALUES (? ,?, ?)";
        //Creating Session object 
    	Cluster c = Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = c.connect("sfapp");
        PreparedStatement statement = session.prepare(select_user);
    	BoundStatement bound = statement.bind(username,password,email);
    	ResultSet result = session.execute(bound);
		return true;    	
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
