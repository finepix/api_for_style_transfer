package hdu.shawn.entity;

public class BaseTask {
	String id;
	String type ;
	String originalPic;
	
	
	public BaseTask() {
		long timestamp = System.currentTimeMillis();
		this.id = String.valueOf(timestamp);
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOriginalPic() {
		return originalPic;
	}
	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}
}
