package adoptable.java.transferObject;
import com.datastax.driver.core.exceptions.DriverException;

import adoptable.java.transferObject.RegularUser;
//import adoptable.java.util.*;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;

import java.util.HashSet;

import com.datastax.driver.core.BoundStatement;

public class RegularUser {
	private String email;
	private String password;
	private String username;
	private HashSet<String> followings = new HashSet<String>();
	private HashSet<String> followers = new HashSet<String>();
	private HashSet<String> likePosts = new HashSet<String>();
//	public RegularUser() {
////		this.email = "";
////		this.password="";
////		this.username="";
////		this.followers.add("");
////		this.followings.add("");
////		this.likePosts.add("");
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public void setFollowers(String username) {
		this.followers.add(username);
	}
	public HashSet<String> getFollowers() {
		return this.followers;
	}
	public void setFollowings(String username) {
		this.followings.add(username);
	}
	public HashSet<String> getFollowings() {
		return this.followings;
	}
	public void setLikedPost(String postId) {
		this.likePosts.add(postId);
	}
	public HashSet<String> getLikedPost() {
		return this.likePosts;
	}

}

