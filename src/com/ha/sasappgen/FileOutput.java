package com.ha.sasappgen;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileOutput {
	
	static final Charset ENCODING = StandardCharsets.UTF_8;
	static final String IOVERSION = "v1";
	
	public FileOutput(ArrayList<QuestionColumn> questions, String title, String author, String directory) throws IOException {
		Path pa;
		ArrayList<String> lines = new ArrayList<String>();
		
		pa = Paths.get(directory);
		lines.add(title);
		lines.add(author);
		lines.add(IOVERSION);
		for(QuestionColumn e: questions) {
			lines.add("col:");
			lines.add(e.getName());
			ArrayList<String> selections = e.getSelectionsList();
			for(String s: selections) {
				lines.add(s);
			}
		}
		write(lines, pa);
		
	}
	
	public FileOutput(ArrayList<QuestionColumn> questions, String title, String author) {
		//TODO implement dialog
	}
	
	
	private void write(ArrayList<String> o, Path p) throws IOException {
		Files.write(p, o, ENCODING);
	}
}
