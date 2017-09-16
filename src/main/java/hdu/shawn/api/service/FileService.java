package hdu.shawn.api.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import hdu.shawn.api.response.BaseResponse;
import hdu.shawn.api.response.ResponseBuilder;
import hdu.shawn.conf.Conf;

@RestController
@RequestMapping("/file")
public class FileService {

	
	private final static String FILE_DIR = Conf.DIR;
	private final static String FILE_SUFFIX = ".jpg";
	private final static String URL_PREFIX = Conf.URL;
	
	
	private static void checkFileDir(){
		File file  = new File(FILE_DIR);
		if(!file.exists())
			file.mkdirs();
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public BaseResponse fileUpload(HttpServletRequest request) {
		//检查文件夹是否存在，或者创建
		checkFileDir();
		
		Map<String, String> urls = new HashMap<>();
		
		
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            
           //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                	long  timestamp = System.currentTimeMillis();
                	String file_name = timestamp + file.getOriginalFilename().hashCode() + FILE_SUFFIX;
                    String path = FILE_DIR + file_name;
                    String url = URL_PREFIX + file_name;
                    //上传
                    try {
						file.transferTo(new File(path));
					} catch (IllegalStateException | IOException e) {
						return ResponseBuilder.build(1, "upload failed.", null);
					}
                    urls.put(file.getName(), url);
                }
                 
            }
           
        }
        if(urls.size() > 0)
        	return ResponseBuilder.build(0, "urls for imgs.", urls);
        else
        	return ResponseBuilder.build(1, "upload failed.", null);
	}
}
