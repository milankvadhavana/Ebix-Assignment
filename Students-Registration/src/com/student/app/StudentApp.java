package com.student.app;
import com.student.model.Student;
import com.student.service.*;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		int choice;
		
		do {
			System.out.println("\n1 Add Student");
			System.out.println("2 View All Students");
			System.out.println("3 Students with Marks > 70");
			System.out.println("4 Group Students by Course");
			System.out.println("5 Sort Students by Marks");
			System.out.println("6 Exit");
			
			System.out.print("Enter Choice : ");
			choice =sc.nextInt();
			switch(choice) {
			case 1:
				try {
					System.out.print("Enter ID :");
					int id = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Enter Name :");
					String name = sc.nextLine();
					
					System.out.print("Enter Course :");
					String course = sc.nextLine();
					
					System.out.print("Enter Marks :");
					double marks = sc.nextDouble();
					
					if(marks < 0 || marks >100) {
						throw new InvalidMarkException("Marks must be between 0 and 100");
					}
					Student s = new Student(id,name,course,marks);
					service.addStudent(s);
					System.out.println("Student added");			
				}catch(InvalidMarkException e) {
					System.out.println("Error :" + e.getMessage());
				}break;
			case 2:
				service.displayall();
				break;
			case 3:
				service.studentsAbove70();
				break;
			case 4:
				service.groupCourse();
				break;
			case 5:
				service.sortByMarks();
				break;
			case 6:
				System.out.println("Exit...");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		while(choice != 6);
	}

}
