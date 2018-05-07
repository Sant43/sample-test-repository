package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ReadFileUsingNIO {

	public static void main(String[] args) {
		FileReader file = null;
		File f = new File("C:\\Users\\171524\\Desktop");
		BufferedReader br = null;
		String match = "Santosh";
		List<String> matchFilesList = new ArrayList<>();
		
		//try {
				List<File> filesList = listOfAllFiles(f);
				
				matchFilesList = filesList.stream().filter(p -> matchFound(p, match)).map(p -> p.getAbsolutePath()).collect(Collectors.toList());

				// NIO code - reads only TXT and XML
				/*matchFilesList = filesList.stream().filter(p -> {
					try {
						Path path = FileSystems.getDefault().getPath(p.getAbsolutePath());
						List<String> allLines = Files.readAllLines(path);
						return allLines.stream().anyMatch(line -> line.toLowerCase().contains(match.toLowerCase()));
					} catch(IOException io) {
						return false;
					}
					}).map(p -> p.getAbsolutePath()).collect(Collectors.toList());*/
		//	}
		//} catch(FileNotFoundException ex) {
		//	ex.printStackTrace();
		//} catch(IOException io) {
		//	io.printStackTrace();
		//}
			System.out.println(matchFilesList);
	}
	
	private static List<File> listOfAllFiles(File f) {
		
		List<File> filesList = new ArrayList<>();
		if(f.isDirectory()) {
			File[] listOfFiles = f.listFiles();
			for(File file : listOfFiles) {
				if(file.isDirectory()) {
					filesList.addAll(listOfAllFiles(file));
				} else if(file.isFile() && file.canRead()) {
					filesList.add(file);
				}
			}
		} else if(f.isFile() && f.canRead()) {
			filesList.add(f);
		}
		return filesList;
	}
	
	private static boolean matchFound(File f, String match) {
		FileReader file = null;
		BufferedReader br = null;
		try {
		file = new FileReader(f);
		br = new BufferedReader(file);
		
		/*int num = 0;
		
		while((num = br.read()) != -1) {
			char c = (char) num;
			System.out.println(c);
		}*/
		String content = null;
		while((content = br.readLine()) != null) {
			if(content.toLowerCase().contains(match.toLowerCase())) {
				return true;
			}
			/*StringTokenizer tokens = new StringTokenizer(content, ",");
			while(tokens.hasMoreTokens()) {
				System.out.println(tokens.nextToken());
			}*/
		}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
			return false;
		} catch(IOException io) {
			io.printStackTrace();
			return false;
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
