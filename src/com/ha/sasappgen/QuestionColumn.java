package com.ha.sasappgen;

import java.util.ArrayList;


public class QuestionColumn {
	String name;
	ArrayList<String> selections = new ArrayList<String>();
	
	QuestionColumn() {
		
	}
	QuestionColumn(String n) {
		name = n;
	}
	QuestionColumn(String n, ArrayList<String> i) {
		name = n;
		selections = i;
	}
	ArrayList<String> getSelectionsList() {
		return selections;
	}
	String getName() {
		return name;
	}
	void addItem(String item) {
		selections.add(item);
	}
	void setName(String n) {
		name = n;
	}
}
