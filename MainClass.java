package com.code.main;

import com.code.pojo.Student;
import com.code.processor.StudentProcessor;

public class MainClass {
 public static void main(String[] args) {
	StudentProcessor processor=new StudentProcessor();
	processor.addStudents();
	Student s=processor.getStudentList().get(0);
	processor.payAmount(s);
	processor.showBalance(s);
	processor.getStatus(s);
}
}
