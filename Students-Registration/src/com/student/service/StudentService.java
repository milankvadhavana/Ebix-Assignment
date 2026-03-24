package com.student.service;
import com.student.model.Student;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

	private List<Student> students = new ArrayList<>();
	
	public void addStudent(Student s) {
     students.add(s);
	}
	public void displayall() {
		for(Student s : students) {
			s.display();
		}
	}
	public void studentsAbove70() {
		List<Student> result = students.stream().filter(s -> s.getMarks() > 70).collect(Collectors.toList());
		result.forEach(Student::display);
	}
	public void groupCourse() {
		Map<String,List<Student>> grouped = students.stream().collect(Collectors.groupingBy(Student :: getCourse));
		for(String course :grouped.keySet()) {
			System.out.println("Course :" + course);
			grouped.get(course).forEach(Student :: display);
		}

	}
	public void sortByMarks() {
		students.sort((s1,s2) -> Double.compare(s2.getMarks(),s1.getMarks()));
		students.forEach(Student :: display);
	}
}
