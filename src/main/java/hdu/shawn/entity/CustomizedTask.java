package hdu.shawn.entity;

public class CustomizedTask extends BaseTask {
	private String stylePic;

	public CustomizedTask(String originalPic, String stylePic) {
		super();
		this.type = "customized";
		this.originalPic = originalPic;
		this.stylePic = stylePic;
	}

	public String getStylePic() {
		return stylePic;
	}

	public CustomizedTask() {
		super();
		this.type = "customized";
	}

	public void setStylePic(String stylePic) {
		this.stylePic = stylePic;
	}
	

}
