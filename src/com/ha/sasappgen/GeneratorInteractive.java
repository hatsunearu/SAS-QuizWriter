package com.ha.sasappgen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class GeneratorInteractive {

	static Scanner s = new Scanner(System.in);
	static ArrayList<QuestionColumn> cols = new ArrayList<QuestionColumn>();
	
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println("SAS Quiz Generator, HA, io rev "+FileOutput.IOVERSION);
		System.out.println("Welcome to the CLI Quiz Generator\n");
		for(;;) {
			System.out.println("Please input title of column "+ (cols.size() + 1));
			String r = s.nextLine();
			QuestionColumn currCol;
			if (r.equals(""))
				break;
			else {
				currCol = new QuestionColumn(r);
			}
			boolean con2 = true;
			while(con2) {
				System.out.println("Column: "+currCol.getName()+" Size: "+(currCol.getSelectionsList().size()));
				String resp = s.nextLine();
				if(resp.equals("")) {
					con2 = false;
				}
				else {
					currCol.addItem(resp);
				}
			}
			cols.add(currCol);
		}
		output();
	}
	public static void output() throws IOException {
		System.out.println("Input write file directory:");
		String p = s.nextLine();
		System.out.println("Input Title");
		String t = s.nextLine();
		System.out.println("Input your name");
		String a = s.nextLine();
		FileOutput f = new FileOutput(cols, t, a, p);
		System.out.println("Done. Title: "+t+" Author: "+a+" Columns:"+cols.size());
	}
	
}
