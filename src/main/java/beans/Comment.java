package beans;

import java.util.UUID;

public class Comment {
	private String commentor;
	private UUID post;
	private String comment;
	
	public String getCommentor() {
		return commentor;
	}
	
	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}
	
	public UUID getPost() {
		return post;
	}
	
	public void setPost(UUID post) {
		this.post = post;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
