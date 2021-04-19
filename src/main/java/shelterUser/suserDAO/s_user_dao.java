package shelterUser.suserDAO;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import shelterUser.suserModel.shelterUser;

public class s_user_dao{
    public static void registerSuser(shelterUser suser) throws DriverException{
    	
        //queries 
        String query = "SELECT * FROM shelterUsers";
        //Creating Cluster object 
        try{
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        //Creating Session object 
        Session session = cluster.connect("sfapp");
        ResultSet result = session.execute(query);
        System.out.println(suser.getUsername());
        /*System.out.println(result.all());*/
        }catch (DriverException e) {
            // process exception
            System.out.println(e);
        }
       
        
    }
}