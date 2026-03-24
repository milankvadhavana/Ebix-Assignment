package com.student.model;

public class Student {
	private int studentId;
	private String name;
	private String course;
	private double marks;
	
	public Student(int studentId, String name, String course, double marks) {
		this.studentId = studentId;
		this.name = name;
		this.course=course;
		this.marks=marks;
	}
	public int getStudentId() {
		return studentId;
	}
	public String getCourse() {
		return course;
	}
	public double getMarks() {
		return marks;
	}
	
	public void display() {
		System.out.println(studentId + " | " + name + " | " + course + " | " +marks);
	}

}
