package beans;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class Post {
	private UUID postId;
	private String posterUsername;
	private String description;
	private boolean adoptionStatus;
	List<ByteBuffer> medias;	// > 1 image
	ByteBuffer media;	// 1 image
	
	public UUID getPostId() {
		return this.postId;
	}

	public void setPostId(UUID postId) {
		this.postId = postId;
	}	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	// To get associated username to posterId (userId): query Users table/column family using posterId.
	public String getPosterUsername() {
		return this.posterUsername;
	}
	
	public void setPosterUsername(String posterUsername) {
		this.posterUsername = posterUsername;
	}
	
	public boolean getAdoptionStatus() {
		return this.adoptionStatus;
	}
	
	public void setAdoptionStatus(boolean adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
	}
	
	public List<ByteBuffer> getAllMedia() {
		return this.medias;
	}
	
	public ByteBuffer getFirstMedia() {
//		if (medias.size() > 0) return this.medias.get(0);
//		return null;
		return this.medias.get(0);	// do null/size check in caller
	}
	
	public void setMedia(List<ByteBuffer> medias) {
		this.medias = medias;
	}
	
	public void setMedia(ByteBuffer media) {
		this.media = media;
	}
	
	public ByteBuffer getMedia() {
		return this.media;
	}
}
