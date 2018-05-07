package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		
		Scanner s = null;
		try {
			s = new Scanner(new File("C:\\Users\\171524\\Desktop\\sample.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = s.nextLine();
		
		//StringBuffer sb = new StringBuffer(str);
		//System.out.println(sb.reverse());
		
		/*char[] charset = str.toCharArray();
		
		for(int i=charset.length; i > 0; i--) {
			System.out.print(charset[i-1]);
		}*/
		while(str.contains(" ")) {
			int endIndex = str.length();
			int beginIndex = str.lastIndexOf(" ");
			System.out.print(str.substring(beginIndex+1, endIndex));
			System.out.print(" ");
			str = str.substring(0, beginIndex);
		}
		System.out.print(str);
	}
}
