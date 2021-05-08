package createPost;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

public class Post {
	private UUID postId;
	private UUID posterId;
	private String poster;
	private String description;
	private boolean adoptionStatus;
	List<ByteBuffer> medias;
	
	public UUID getPostId() {
		return this.postId;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	// To get associated username to posterId (userId): query Users table/column family using posterId.
	public UUID getPosterId() {
		return this.posterId;
	}
	
	public void setPosterId(UUID uuid) {
		this.posterId = uuid;
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
}
