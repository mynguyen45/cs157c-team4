package regularUser.ruserModel;
import com.datastax.driver.core.exceptions.DriverException;

import regularUser.ruserModel.regularUser;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.PreparedStatement;

import java.util.*;

import com.datastax.driver.core.BoundStatement;

public class regularUser {
	private String email;
	private String password;
	private String username;
	private HashSet<Integer> followings = new HashSet<Integer>();
	private HashSet<Integer> followers = new HashSet<Integer>();
	private HashSet<Integer> likes = new HashSet<Integer>();

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
	public void setFollowers(int id) {
		this.followers.add(id);
	}
	public HashSet<Integer> getFollowers() {
		return this.followers;
	}
	public void setFollowings(int id) {
		this.followings.add(id);
	}
	public HashSet<Integer> getFollowings() {
		return this.followings;
	}
	public void likes(int id) {
		this.likes.add(id);
	}
	public HashSet<Integer> getLikes() {
		return this.likes;
	}

}

