package beans;
import java.util.UUID;
public class like {
	private String username;
	private String password;
	private UUID postid;
	public UUID getPostid() {
		return postid;
	}
	public void setPostid(UUID postid) {
		this.postid = postid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
