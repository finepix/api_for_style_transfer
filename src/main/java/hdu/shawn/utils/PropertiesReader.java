package hdu.shawn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 配置文件读取类，封装了properties的方法
 * @author f-zx
 *
 */
public class PropertiesReader {
	private static PropertiesReader readerInstance = new PropertiesReader();
	private Properties properties = new Properties();
	private final static String PROPERTIES_FILE = "main/java/hdu/shawn/conf/conf.properties";
	
	/**
	 * 单例模式，获取reader
	 * @return
	 */
	public static PropertiesReader getInstance(){
		return readerInstance;
	}
	
	
	/**
	 * 
	 * 获取配置文件信息
	 * @param key 需要获取的key值
	 * @throws IOException
	 */
	public String getProperty(String key) throws IOException{
		Thread currentThread = Thread.currentThread();
		
		System.out.println(Thread.currentThread().getContextClassLoader());
		ClassLoader contextClassLoader = currentThread.getContextClassLoader();
		InputStream propertiesStream = contextClassLoader.getResourceAsStream(PROPERTIES_FILE);
		if (propertiesStream != null) {
			
		  properties.load(propertiesStream);
		  String value = properties.getProperty(key);
		  return value;
		  
		} else {
		  // Properties file not found!
			return "/tmp/";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(PropertiesReader.getInstance().getProperty("dir"));
	}

}
