package hdu.shawn.entity;


public class ModelTask extends BaseTask{
	private String model_name;

	public ModelTask() {
		super();
		this.type = "model";
	}

	public ModelTask(String originalPic,String model_name) {
		super();
		this.type = "model";
		this.originalPic = originalPic;
		this.model_name = model_name;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	

}
