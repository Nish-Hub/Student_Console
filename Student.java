package com.code.pojo;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
	private String name;
	private int gradeID;
	private int year;
	private String id;
	private int balance;
	private int paid=0;
	private List<Integer> subjects = new ArrayList<Integer>();
	private String[] gradeList= {IDLibrary.firstYear,IDLibrary.secondYear,IDLibrary.thirdYear,IDLibrary.fourthYear};
	/*private static Map<Integer,Subject> gradeList=new HashMap<Integer,Subject>();
	static {
		gradeList.put(IDLibrary.HistoryID,new Subject(IDLibrary.History));
		gradeList.put(IDLibrary.MathematicsID,new Subject(IDLibrary.Mathematics));
		gradeList.put(IDLibrary.EnglishID,new Subject(IDLibrary.English));
		gradeList.put(IDLibrary.ChemistryID,new Subject(IDLibrary.Chemistry));
	
	}
*/
	public Student(String name,int gradeID) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.gradeID=gradeID;
		setId(gradeList[this.gradeID]);
		
	}
	
	public List<Integer> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Integer> subjects) {
		this.subjects = subjects;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid+this.paid;
	}

	private int tution;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String grade) {
		String suffix=String.valueOf(999-(899*(int)Math.random()));
		this.id=grade+suffix;
		
	}

	public int getBalance() {
		return this.tution-this.paid;
	}


	public int getTution() {
		return tution;
	}

	public void setTution(int tution) {
		this.tution = tution;
	}
}
