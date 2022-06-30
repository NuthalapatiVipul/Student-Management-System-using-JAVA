package springdemo.studentManagement.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springdemo.studentManagement.data.StudentRecordsDatabase;
import springdemo.studentManagement.model.StudentRecord;

@Component
public class StudentManagementUtilsImplementations implements StudentmanagementUtils {

	@Autowired
	private StudentRecordsDatabase studentRecordsDatabase;
	
	@Override
	public void addStudent(StudentRecord studentRecord) {
		
		studentRecordsDatabase.studentRecords.put(studentRecord.getRollNo(), studentRecord);
	}

	@Override
	public List<StudentRecord> getListOfStudents() {
	
		return studentRecordsDatabase.studentRecords.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}

	@Override
	public Optional<StudentRecord> getStudentRecord(int rollNo) {
	
		return Optional.ofNullable(studentRecordsDatabase.studentRecords.get(rollNo));
	}

	@Override
	public Optional<StudentRecord> deleteStudent(int rollNo) {
	
		StudentRecord st = studentRecordsDatabase.studentRecords.get(rollNo);
		studentRecordsDatabase.studentRecords.remove(st.getRollNo());
		return Optional.ofNullable(st);
	}

	@Override
	public Optional<StudentRecord> editStudentRecord(StudentRecord studentRecord) {

		return Optional.ofNullable(studentRecordsDatabase.studentRecords.replace(studentRecord.getRollNo(), studentRecord));
	}

}
