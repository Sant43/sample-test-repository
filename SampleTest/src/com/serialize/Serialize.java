package com.serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {

	public static void main(String[] args) {
		
		A a = new B(24);
		try (FileOutputStream file = new FileOutputStream("D:/171524/test")) {
			ObjectOutputStream ob = new ObjectOutputStream(file);
			ob.writeObject(a);
			
			ob.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
