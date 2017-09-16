package hdu.shawn.utils;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("e:/temp/12.jpg");
		System.out.println(file.exists());;
		file.mkdirs();
	}
}
