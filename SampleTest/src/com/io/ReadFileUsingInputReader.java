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

public class ReadFileUsingInputReader {

	public static void main(String[] args) {
		//FileReader file = null;
		File f = new File("C:\\Users\\171524\\Desktop");
		//BufferedReader br = null;
		String match = "Gandepalli";
		List<String> matchFilesList = new ArrayList<>();
		
		try {
				List<File> filesList = listOfAllFiles(f);
				
				for(File fil : filesList) {
					if(matchFound(fil, match)) {
						System.out.println(fil.getAbsolutePath());
					}
				}
				/*
				matchFilesList = filesList.stream().filter(p -> {
				try {
					Path path = FileSystems.getDefault().getPath(p.getAbsolutePath());
					List<String> allLines = Files.readAllLines(path);
					return allLines.stream().anyMatch(line -> line.toLowerCase().contains(match.toLowerCase()));*/
					
				
				/*} catch(IOException io) {
					return false;
				}
				}).map(p -> p.getAbsolutePath()).collect(Collectors.toList());*/

			//}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace();
		}
			//System.out.println(matchFilesList);
	}
	
	private static boolean matchFound(File f, String match) throws FileNotFoundException, IOException {
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
		String content = br.readLine();
		while(content != null) {
			if(content.contains(match)) {
				return true;
			}
			/*StringTokenizer tokens = new StringTokenizer(content, ",");
			while(tokens.hasMoreTokens()) {
				System.out.println(tokens.nextToken());
			}*/
			content = br.readLine();
		}
		} finally {
			if(br!=null) {
			br.close();
			}
			if(file != null) {
			file.close();
			}
		}
		return false;
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

}
