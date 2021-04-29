package adoptable_server;

import java.util.List;

public class Post {
	private int postId;
	private int posterId;
	private String poster;
	private String description;
	private boolean adoptionStatus;
	List<Blob> media;
	
	public int getPostId() {
		return this.postId;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPosterId() {
		return this.posterId;
	}
	
	public String getPoster() {
		return this.poster;
	}
	
	public boolean getAdoptionStatus() {
		return this.adoptionStatus;
	}
	
	public void setAdoptionStatus(boolean adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
	}
	
	public List<Blob> getMedia() {
		return this.media;
	}
	
	public void setMedia(List<Blob> media) {
		this.media = media;
	}
}
