package springdemo.studentManagement.data;

import java.util.HashMap;
import java.util.Map;

import springdemo.studentManagement.model.StudentRecord;


public class StudentRecordsDatabase {

	public Map<Integer, StudentRecord> studentRecords;
	
	public StudentRecordsDatabase(Map<Integer, StudentRecord> studentRecords) {
		this.studentRecords=studentRecords;
	}
}
