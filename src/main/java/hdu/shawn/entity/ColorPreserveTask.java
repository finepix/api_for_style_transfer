package hdu.shawn.entity;

public class ColorPreserveTask extends BaseTask{
	private String renderPic;

	public ColorPreserveTask(String originalPic , String renderPic) {
		super();
		this.type = "color";
		this.originalPic = originalPic;
		this.renderPic = renderPic;
	}

	public String getRenderPic() {
		return renderPic;
	}

	public ColorPreserveTask() {
		super();
		this.type = "color";
	}

	public void setRenderPic(String renderPic) {
		this.renderPic = renderPic;
	}
	
	

}
