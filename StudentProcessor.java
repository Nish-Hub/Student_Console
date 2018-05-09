package com.code.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.code.pojo.Subject;
import com.code.pojo.IDLibrary;
import com.code.pojo.Student;

public class StudentProcessor {
	private static Map<Integer, Subject> subjectList = new HashMap<Integer, Subject>();
	static {
		subjectList.put(IDLibrary.HistoryID, new Subject(IDLibrary.History));
		subjectList.put(IDLibrary.MathematicsID, new Subject(IDLibrary.Mathematics));
		subjectList.put(IDLibrary.EnglishID, new Subject(IDLibrary.English));
		subjectList.put(IDLibrary.ChemistryID, new Subject(IDLibrary.Chemistry));
		subjectList.put(IDLibrary.Computer_ScienceID, new Subject(IDLibrary.Computer_Science));
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	private List<Student> studentList = new ArrayList<Student>();

	public void addStudents() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of students to add :");
		int totalStudentsToAdd = sc.nextInt();

		for (int i = 0; i < totalStudentsToAdd; i++) {
			System.out.println("Enter name for student " + i + 1);
			String name = sc.nextLine();
			System.out.println(
					"Enter grade of the student \n 1 for first year \n 2 for second year \n 3 for third year \n 4 for fourth year");
			int grade = sc.nextInt();
			Student s = new Student(name, grade);
			studentList.add(s);

			System.out.println("Enter total subjects for the student to enroll");
			int totalSubjects = sc.nextInt();
			s.setTution(Subject.COST * totalSubjects);
			System.out.println("Enter subject codes : ");
			subjectList.forEach((k, v) -> System.out.println(k + " for subject " + v.getName()));
			for (int j = 0; j < totalSubjects; j++) {
				s.getSubjects().add(sc.nextInt());
			}
		}
		sc.close();
	}

	public void payAmount(Student s) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Your outstanding amount is " + s.getBalance());
		System.out.println("Enter amount to pay");
		int amountPaid = sc.nextInt();
		s.setPaid(amountPaid);
		System.out.println("Your outstanding amount now is " + s.getBalance() + " \n Thank you");
		sc.close();

	}

	public void showBalance(Student s) {
		System.out.println("Student name " + s.getName() + " have total tution fees as " + s.getTution());
		if (s.getPaid() == 0)
			System.out.println("You have not paid anything");
		else
			System.out.println("Your outstanding amount is " + s.getBalance());
		if (s.getBalance() == 0)
			System.out.println("You are good to go !");
		else
			System.out.println("Do you want to clear your balance ? \n Yes for now \n No for later");

		Scanner sc = new Scanner(System.in);
		String choice = sc.next();

		if (choice.equalsIgnoreCase("Yes")) {
			sc.close();
			payAmount(s);
		} else
			sc.close();

	}

	public void getStatus(Student s) {
		System.out.println("Student ID " + s.getId());
		System.out.println("Student name " + s.getName());
		System.out.println("Balance left " + s.getBalance());
		System.out.println("Courses enrolled : ");
		subjectList.forEach((k, v) -> System.out.println(k + " : " + v));
	}
}
