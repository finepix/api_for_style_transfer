package hdu.shawn.api.response;

public class ResponseBuilder {
	
	public static BaseResponse build(Integer code,String msg , Object data){
		BaseResponse response = new BaseResponse();
		response.setCode(code);
		response.setMsg(msg);
		response.setData(data);
		
		return response;
	}

}
