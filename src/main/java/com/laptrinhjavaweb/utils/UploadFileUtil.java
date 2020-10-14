package com.laptrinhjavaweb.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

public class UploadFileUtil {
	private static final String root = "/usr/var";
	public static void writeOrUpdateFile(byte[] bytes,String path) {
		File file = new File(StringUtils.substringBeforeLast(root+path, "/"));
		if(!file.exists()) {
			file.mkdir();
		}
		try(FileOutputStream fileOutputStream = new FileOutputStream(new File(root+path))){
			fileOutputStream.write(bytes);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
