package com.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileUsingOutputStream {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\171524\\Desktop\\sample.txt");
		String content = "I am good boy";
		
		try {
			FileOutputStream fop = new FileOutputStream(file);
			BufferedOutputStream bfo = new BufferedOutputStream(fop);
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			byte[] bytes = content.getBytes();
			bfo.write(bytes);
			bfo.flush();
			
			bfo.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
