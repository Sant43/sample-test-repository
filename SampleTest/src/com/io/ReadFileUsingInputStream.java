package com.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFileUsingInputStream {

	public static void main(String[] args) {

		File f = new File("C:\\Users\\171524\\Desktop\\Imp-Sothebys.txt");
			
		try(FileInputStream in = new FileInputStream(f)) {
			InputStream bf = new BufferedInputStream(in);
			while(bf.available() > 0) {
				System.out.println((char)bf.read());
			}
			in.close();
			bf.close();
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace();
		}

	}

}
