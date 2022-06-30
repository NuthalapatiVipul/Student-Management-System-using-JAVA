/*
 * 
 * 1. add student 
 * 2. View all students
 * 3. View student 
 * 4 Delete student
 * 5. Edit student
 * 6. Exit application
 * 
 * 
 */

package springdemo.studentManagement.main;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springdemo.studentManagement.SpringConf;
import springdemo.studentManagement.model.StudentRecord;
import springdemo.studentManagement.utils.StudentManagementUtilsImplementations;
import springdemo.studentManagement.utils.StudentmanagementUtils;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConf.class);
		Scanner scanner = applicationContext.getBean(Scanner.class);
		StudentmanagementUtils studentmanagementUtils = applicationContext.getBean(StudentManagementUtilsImplementations.class);
		outer:
		while (true) {

			System.out.println("Welcome to my student management system \n"
					+ "Please choose required option to perform \n" + "1. Add new Student record \n"
					+ "2. View all Student records \n" + "3. View particluar student record \n"
					+ "4. Delete student record \n" + "5. Edit student record \n" + "6. Exit Application.");
			String option = scanner.next();
			int rollNo =0;
			String name=null;
			long contactNo=0;
			StudentRecord studentRecord=null;
			switch (option) {
			case "1":
				System.out.println("Please enter rollNo");
				rollNo=scanner.nextInt();
				System.out.println("Please enter name");
				name=scanner.next();
				System.out.println("Please enter contact no");
				contactNo=scanner.nextInt();
				studentRecord=applicationContext.getBean(StudentRecord.class);
				studentRecord.setRollNo(rollNo);
				studentRecord.setName(name);
				studentRecord.setContactNo(contactNo);
				studentmanagementUtils.addStudent(studentRecord);
				System.out.println("Student record added successfully");
				break;

			case "2":
				List<StudentRecord> studentList= studentmanagementUtils.getListOfStudents();
				if(studentList!=null && studentList.size()>0) {
					studentList.forEach(st -> System.out.println(st.toString()));
				}
				else {
					System.out.println("student record not found");
				}
				break;
			case "3":
				System.out.println("Please enter rollNo");
				rollNo=scanner.nextInt();
				Optional<StudentRecord> result = studentmanagementUtils.getStudentRecord(rollNo);
				if(result.isEmpty()) {
					System.out.println("student record not found");
				}
				else {
					System.out.println(result.get().toString());
				}
				break;
			case "4":
				System.out.println("Please enter rollNo");
				rollNo=scanner.nextInt();
				if(studentmanagementUtils.getStudentRecord(rollNo).isEmpty()){
					System.out.println("Student record not found");
					break;
				}
				studentmanagementUtils.deleteStudent(rollNo);
				System.out.println("Deletion successfull");
				break;
			case "5":
				System.out.println("Please enter rollNo");
				rollNo=scanner.nextInt();
				if(studentmanagementUtils.getStudentRecord(rollNo).isEmpty()){
					System.out.println("Student record not found");
					break;
				}
				System.out.println("Please enter new name");
				name=scanner.next();
				System.out.println("Please enter new contact no");
				contactNo=scanner.nextInt();
				studentRecord=applicationContext.getBean(StudentRecord.class);
				studentRecord.setRollNo(rollNo);
				studentRecord.setName(name);
				studentRecord.setContactNo(contactNo);
				studentmanagementUtils.editStudentRecord(studentRecord);
				System.out.println("Update successfully");
				break;
			case "6":

				break outer;
			}
		}
		System.out.println("Thanks for using my application.");
	}
}
