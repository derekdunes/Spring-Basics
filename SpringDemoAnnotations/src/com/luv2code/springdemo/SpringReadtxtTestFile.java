package com.luv2code.springdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SpringReadtxtTestFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "fortunes.txt";
		
		ClassLoader classLoader = new SpringReadtxtTestFile().getClass().getClassLoader();
		
		File file = new File(classLoader.getResource(filename).getFile());
		
		System.out.println("File Found : " + file.exists());
		
		String content = new String(Files.readAllBytes(file.toPath()));
		
		System.out.println(content);
		
		String[] yoga = content.split(",");
		
		for(String s : yoga) {
			System.out.println(s);
		}
	}

}
