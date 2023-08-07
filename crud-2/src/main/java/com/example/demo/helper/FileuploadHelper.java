package com.example.demo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileuploadHelper {

	//public final String UPLOAD_DIR="E:\\JAVA\\chirag\\crud-2\\src\\main\\resources\\static\\image";
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileuploadHelper() throws IOException
	{
		
	}
	
	public boolean uploadfile(MultipartFile multipartfile)
	{
		boolean f=false;
		try {
//			InputStream is=multipartfile.getInputStream();
//			byte data[]=new byte[is.available()];
//		
//			is.read(data);
//			
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
	//or-->		
			Files.copy(multipartfile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
