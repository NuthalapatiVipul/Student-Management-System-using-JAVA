package springdemo.studentManagement.utils;

import java.util.List;
import java.util.Optional;

import springdemo.studentManagement.model.StudentRecord;

public interface StudentmanagementUtils {

	public void addStudent(StudentRecord studentRecord);
	public List<StudentRecord> getListOfStudents();
	public Optional<StudentRecord> getStudentRecord(int rollNo);
	public Optional<StudentRecord> deleteStudent(int rollNo);
	public Optional<StudentRecord> editStudentRecord(StudentRecord studentRecord);
}
